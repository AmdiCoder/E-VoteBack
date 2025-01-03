package com.EvoteSG2.Evote.controllers;

import com.EvoteSG2.Evote.entities.Utilisateur;
import com.EvoteSG2.Evote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<Utilisateur>> getAllUsers() {
    List<Utilisateur> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Utilisateur> getUserById(@PathVariable Integer id) {
    Utilisateur user = userService.getUserById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping
  public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur user) {
    Utilisateur newUser = userService.createUser(user);
    return ResponseEntity.ok(newUser);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Utilisateur> updateUser(@PathVariable Integer id, @RequestBody Utilisateur user) {
    Utilisateur updatedUser = userService.updateUser(id, user);
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }
}