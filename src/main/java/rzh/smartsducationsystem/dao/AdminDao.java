package rzh.smartsducationsystem.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import rzh.smartsducationsystem.model.Admin;

import java.util.List;

@Repository
@Mapper
public interface AdminDao {
    @Select("select * from admin")
    List<Admin>getAdminList();
    @Select("select * from admin where username = #{username}")
    Admin getAdminByUsername(String username);
    @Update("update admin set password = #{password},name = #{name} where username = #{uaername}")
    int updateAdminByUsername(String username);
    @Insert("insert into admin (username,password,name) values (#{username},#{password},#{name})")
    int insertAdmin(Admin admin);
    @Delete("delete from admin where username = #{username}")
    int deleteAdminByUsername(String username);
}
