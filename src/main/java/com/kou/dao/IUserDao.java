package com.kou.dao;
import com.kou.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.imageio.ImageIO;
import java.util.List;

/**
 * @author jiajun kou
 *
 * 注解配置
 *
 *
 *
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存添加用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday) " +
            "values(" +
            "#{username},#{address},#{sex},#{birthday})")
    void addUser(User user);


    /**
     * 更新用户
     * @param user
     */
    @Update("update user set " +
            "username=#{username}," +
            "address=#{address}," +
            "sex=#{sex}," +
            "birthday=#{birthday} " +
            "where id=#{id};\n")
    void updateUser(User user);

    /**
     * 删除用户 根据id
     * @param uid
     */
    @Delete("delete from user where id=#{id};")
    void deleteUser(Integer uid);

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer uid);

    /**
     * 根据名称模糊查询用户
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);

}
