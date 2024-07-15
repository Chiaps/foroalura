package com.ejemplo.miproyecto.repository;

import com.ejemplo.miproyecto.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}