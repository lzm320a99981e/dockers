package com.dokers.demo.example.repository;

import com.dokers.demo.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsUserRepository extends ElasticsearchRepository<User, String> {
    Page<User> findUserByUsername(String username, Pageable pageable);

    Iterable<User> findByUsernameIsLikeOrEmailIsLike(String username, String email);
}
