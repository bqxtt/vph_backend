package com.vph.vph.mapper;

import com.vph.vph.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author tcg
 * @date 2021/4/26
 */
@Mapper
@Component
public interface UserMapper {
    @Insert("insert into users(username,password) values(#{username},#{password})")
    Integer addUser(User user);

    @Select("select * from users where username = #{username}")
    User getUserByUsername(String username);
}
