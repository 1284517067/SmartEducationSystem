package rzh.smartsducationsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"rzh.smartsducationsystem.bean","rzh.smartsducationsystem.controller","rzh.smartsducationsystem.dao","rzh.smartsducationsystem.model","rzh.smartsducationsystem.service"})
@MapperScan("rzh.smartsducationsystem.dao")
public class SmartsducationsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartsducationsystemApplication.class, args);
    }

}
