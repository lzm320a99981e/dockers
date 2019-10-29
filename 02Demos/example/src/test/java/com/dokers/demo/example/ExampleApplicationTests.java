package com.dokers.demo.example;

import com.alibaba.fastjson.JSON;
import com.dokers.demo.example.entity.User;
import com.dokers.demo.example.repository.EsUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        System.out.println(esUserRepository.findAll());
//        final Page<User> page = esUserRepository.findUserByUsername("zhang", PageRequest.of(0, 10));
//        System.out.println(JSON.toJSONString(page.get().collect(Collectors.toList()), true));
    }
}
