package com.example.author_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.author_service.exceptionHandler.ResourceNotFoundException;
import com.example.author_service.model.Author;
import com.example.author_service.repository.AuthorRepository;

@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository authorRepository;

    // Get all authors
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Get an author by ID
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    // Create a new author
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Update an existing author
    public Author updateAuthor(Long id, Author authorDetails) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));

        author.setName(authorDetails.getName());
        author.setNationality(authorDetails.getNationality());
        return authorRepository.save(author);
    }

    // Delete an author
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
