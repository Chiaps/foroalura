package com.ejemplo.miproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Title is mandatory")
    private String title;

    @Column(nullable = false, length = 10000)
    @NotBlank(message = "Content is mandatory")
    private String content;

    @Column(nullable = false)
    @NotBlank(message = "Author is mandatory")
    private String author;

    @Column(nullable = false)
    @NotNull(message = "Creation date is mandatory")
    @PastOrPresent(message = "Creation date cannot be in the future")
    private LocalDateTime createdAt; // Nota: Considera usar LocalDateTime.now() en el constructor y posiblemente cambiarlo a @NotNull si lo inicializas en el constructor

    // Constructor
    public Post() {
        this.createdAt = LocalDateTime.now(); // Inicialización en el momento de la creación del objeto
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
