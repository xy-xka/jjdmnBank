package com.org.jjdmn.bank.persistence;

import com.org.jjdmn.bank.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @PackageUrl com.org.jjdmn.bank.persistence
 * @ClassName UserMapper
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    public User getByusername(@Param("username") String username);

    @Insert("insert into user(userId, username,password,identityCard,salt)values(#{userId}, #{username}),#{password},#{identityCard},#{salt}")
    public int insert(User user);
}
