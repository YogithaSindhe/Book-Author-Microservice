package com.example.author_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.author_service.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
