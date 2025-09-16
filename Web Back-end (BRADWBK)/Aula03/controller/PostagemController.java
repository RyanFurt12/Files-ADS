package aula._3.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aula._3.demo.model.Postagem;

@RestController
@RequestMapping("/posts")
public class PostagemController {

  private List<Postagem> posts = new ArrayList<>();
  private Long counterID = 1L;

  @GetMapping
  public List<Postagem> getAllPosts() {
    return posts;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Postagem> getPost(@PathVariable Long id) {
    return posts.stream()
        .filter(p -> p.getId().equals(id))
        .findFirst()
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Postagem> createPost(@RequestBody Postagem post) {
    post.setId(counterID++);
    post.setDataCriacao(LocalDateTime.now());
    posts.add(post);
    return ResponseEntity.status(201).body(post);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Postagem> updatePost(@PathVariable Long id, @RequestBody Postagem newPost) {
    for (Postagem p : posts) {
      if (p.getId().equals(id)) {
        p.setTitulo(newPost.getTitulo());
        p.setConteudo(newPost.getConteudo());
        return ResponseEntity.ok(p);
      }
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public BodyBuilder deletePost(@PathVariable Long id) {
    if (posts.removeIf(p -> p.getId().equals(id)))
      return ResponseEntity.ok();
    return (BodyBuilder) ResponseEntity.notFound().build();
  }
}