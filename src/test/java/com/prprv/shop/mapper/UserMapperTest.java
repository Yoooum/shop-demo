package com.prprv.shop.mapper;

import com.prprv.shop.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 未確認の庭師
 */
@Slf4j
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void insertUser() {
        User user = new User();
        user.setEmail("root@prprv.com");
        user.setUsername("root");
        user.setPassword("password");
        userMapper.insertUser(user);
        log.info("插入：{}", user);
    }

    @Test
    void updateUserById() {
    }

    @Test
    void updateUserByEmail() {
        User user = new User();
        user.setEmail("root@prprv.com");
        user.setAddress("眉山");
        user.setRole(1);
        int result = userMapper.updateUserByEmail(user);
        if (result == 1) {
            log.info("更新成功");
        } else {
            log.info("更新失败: {}", result);
        }
    }

    @Test
    void deleteUserById() {
        User user = userMapper.selectUserByEmail("root@prprv.com");
        if (user != null) {
            userMapper.deleteUserById(user.getId());
            log.info("删除：{}", user);
        } else {
            log.info("用户不存在");
        }
    }

    @Test
    void deleteUserByEmail() {
        int result = userMapper.deleteUserByEmail("root@prprv.com");
        if (result != 1) {
            log.info("删除失败");
        } else {
            log.info("删除成功");
        }
    }

    @Test
    void selectUserById() {
        User user = userMapper.selectUserById(1L);
        log.info("查询：{}", user);
    }

    @Test
    void selectUserByEmail() {
        User user1 = userMapper.selectUserByEmail("von.towne@yahoo.com");
        log.info("查询：{}", user1);
        User user2 = userMapper.selectUserByEmail("von.towne@yahoo.com");
        log.info("查询：{}", user2);
    }

    @Test
    void selectUserByName() {
        userMapper.selectUserByName("七森莉莉").forEach(user -> log.info("查询：{}", user));
    }

    @Test
    void selectUserByLogin() {
        User user = userMapper.selectUserByLogin("arleen.cruickshank@gmail.com", "password");
        log.info("查询：{}", user);
    }

    @Test
    void selectAllUser() {
        userMapper.selectAllUser().forEach(user -> log.info("查询：{}", user));
    }
}