package rzh.smartsducationsystem.bean;

import org.springframework.context.annotation.Bean;
import rzh.smartsducationsystem.model.*;

import java.util.List;

public class BeanFactory {
    @Bean
    public static Student getStudent(){
        return new Student();
    }
    @Bean
    public static Teacher getTeacher(){
        return new Teacher();
    }
    @Bean
    public static Admin getAdmin(){
        return new Admin();
    }
    @Bean
    public static UserBean getUserBean(){
        return new UserBean();
    }
    @Bean
    public static Student getStudent(long stuId,String password,String name,String school,String department,String classes,String major,String tel){
        return new Student(stuId,password,name,school,department,major,classes,tel,0);
    }
    @Bean
    public static Admin getAdmin(String username,String password,String name){
        return new Admin(username,password,name);
    }
    @Bean
    public static Teacher getTeacher(long id,String name, String school,String department,String password,String major,String tel){
        return new Teacher(id,name,school,department,password,major,tel);
    }
    @Bean
    public static Topic getTopic(){
        return new Topic();
    }
    @Bean
    public static Topic getTopic(long id, long exam_Id, String topic_content, String answer, List<Option> options){
        return new Topic(id,exam_Id,topic_content,answer,options);
    }
    @Bean
    public static Topic getTopic(String topic_content, String answer, List<Option> options){
        return new Topic(topic_content,answer,options);
    }
    @Bean
    public static Option getOption(){
        return new Option();
    }
    @Bean
    public static Option getOption(long topic_Id, String option, String option_content){
        return new Option(topic_Id,option,option_content);
    }
    @Bean
    public static Option getOption(long id, long topic_Id, String option, String option_content){
        return new Option(id,topic_Id,option,option_content);
    }
    @Bean
    public static Work getWork(){
        return new Work();
    }
}
