package com.johncode.fundamentos.springboot.app.repository;

import com.johncode.fundamentos.springboot.app.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
