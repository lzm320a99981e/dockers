package com.dokers.demo.example;

import com.alibaba.fastjson.JSON;
import com.dokers.demo.example.entity.User;
import com.dokers.demo.example.repository.EsUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
class ExampleApplicationTests {

    @Autowired
    private EsUserRepository esUserRepository;

    @Test
    void testSave() {
        final User entity = new User();
        entity.setUsername("zhangsan");
        entity.setEmail("1234234@qq.com");
        esUserRepository.save(entity);
        System.out.println(JSON.toJSONString(entity, true));
    }

    @Test
    void testQuery() {
        final List<User> users = esUserRepository.findUserByUsername("zhangsan", PageRequest.of(0, 5)).getContent();
        System.out.println(JSON.toJSONString(users, true));
    }

    @Test
    void testQuery1() {
        final Iterable<User> users = esUserRepository.findByUsernameIsLikeOrEmailIsLike("gs", "1");
        System.out.println(JSON.toJSONString(users, true));
    }
}
