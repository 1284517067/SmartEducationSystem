package rzh.smartsducationsystem.service.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import rzh.smartsducationsystem.service.impl.MD5;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class EncryptionAspect {

    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Pointcut("execution(* rzh.smartsducationsystem.controller..*.*(..))")
    public void EncryptionAspect() {
    }

    @Around("EncryptionAspect()")
    public Object encryptionPassword(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("---开始密码加密---");
        //获取方法名称列表
        MethodSignature msg = (MethodSignature) joinPoint.getSignature();
        String[] paramName = msg.getParameterNames();
        List<String> paramNameList = Arrays.asList(paramName);

        //获取传入的参数数组
        Object[] args = joinPoint.getArgs();
        //寻找名为password的参数
        if (paramNameList.contains("password")){
            //获取password在数组的位置
            Integer position = paramNameList.indexOf("password");
            //获取password的值
            String password = (String)args[position];
            //MD5加密
            String newPassword = MD5.getMD5(password);
            //把加密后的密码放回password原来的位置
            args[position] = newPassword;
        }
        Object retVal = joinPoint.proceed(args);
        return retVal;
    }


}
