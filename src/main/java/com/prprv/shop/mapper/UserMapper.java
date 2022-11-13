package com.prprv.shop.mapper;

import com.prprv.shop.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 未確認の庭師
 */
@Repository
public interface UserMapper {
    int insertUser(User user);
    int updateUserById(User user);
    int updateUserByEmail(User user);
    int deleteUserById(Long id);
    int deleteUserByEmail(String email);
    User selectUserById(Long id);
    User selectUserByEmail(String email);
    List<User> selectUserByName(String username);
    User selectUserByLogin(
            @Param("email") String email,
            @Param("password") String password
    );
    List<User> selectAllUser();
}
