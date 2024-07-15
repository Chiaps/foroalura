package com.ejemplo.miproyecto.service;

import com.ejemplo.miproyecto.model.Post;
import com.ejemplo.miproyecto.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post updatedPost) {
        return postRepository.findById(id)
                .map(existingPost -> {
                    existingPost.setTitle(updatedPost.getTitle());
                    existingPost.setContent(updatedPost.getContent());
                    existingPost.setAuthor(updatedPost.getAuthor());
                    // other fields if necessary
                    return postRepository.save(existingPost);
                })
                .orElse(null);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
