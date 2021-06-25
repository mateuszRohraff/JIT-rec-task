package com.rohraff.jitrectask.mapper;

import com.rohraff.jitrectask.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USERS (username, password) VALUES(#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "userID")
    int insert(User user);

    @Select("SELECT * FROM USERS")
    List<User> getUsers();

}
