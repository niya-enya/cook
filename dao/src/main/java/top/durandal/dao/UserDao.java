package top.durandal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.durandal.entity.User;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    /**
     * 创建对象并返回主键
     * @param user
     * @return
     */
    @Results(id="user",value = {
            @Result(property="userId",column="user_id",id = true)
    })
    @Insert("insert into user(user_name,user_pass,user_date,user_phone,user_email" +
            ",user_show) values(#{userName},#{userPass},#{userDate}," +
            "#{userPhone},#{userEmail},#{userShow})")
    @Options(useGeneratedKeys = true,keyProperty = "userId",keyColumn="user_id")
    int saveUser(User user);

    @Select("select user_name,user_pass from user where user_name=#{userName}")
    User findByName(String userName);

    @Select("select user_id,user_name,user_date,user_email,user_phone,user_img,user_day,user_sex," +
            "user_home,user_now,user_self,user_job from user where user_name=#{userName}")
    User queryByName(String userName);

    @Update("update user set user_pass = #{userPass} where user_name = #{userName}")
    void updateByName(@Param("userName") String userName,@Param("userPass") String userPass);

    @Update("update user set user_show = 'false' where user_name = #{userName}")
    void banByName(String userName);

    @Select("select user_show from user where user_name = #{userName}")
    String hasUser(String userName);

    @Update("update user set user_show = 'true' where user_name = #{userName}")
    void relieveByName(String userName);

//    @Select("select user_id,user_name,user_date,user_email,user_phone,user_img,user_day,user_sex," +
//            "user_home,user_now,user_self,user_job from user where user_id=#{userId}")
//    User findUserById(Integer userId);

    @Select("select user_id,user_name,user_date,user_email,user_phone,user_img,user_day,user_sex," +
            "user_home,user_now,user_self,user_job from user where user_id=#{userId}")
    User getUserById(Integer userId);

    @Update("update user set user_email = #{userEmail} where user_id = #{userId}")
    int updateEmail(@Param("userId") Integer userId, @Param("userEmail")String userEmail);

    @Select("select user_email,user_password from user where user_email = #{userEmail}")
    User findByEmail(String userEmail);
}
