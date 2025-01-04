package com.EvoteSG2.Evote.controllers;

import com.EvoteSG2.Evote.entities.Utilisateur;
import com.EvoteSG2.Evote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    // 1. Vérifier si l'utilisateur avec l'ID donné existe dans la base de données
    Optional<Utilisateur> existingUserOpt = Optional.ofNullable(userService.getUserById(id));

    if (existingUserOpt.isEmpty()) {
      // Si aucun utilisateur n'est trouvé pour cet ID, renvoyer une réponse HTTP 404 (Not Found)
      return ResponseEntity.notFound().build();
    }

    // 2. Récupérer l'utilisateur existant et mettre à jour ses champs avec les nouvelles données
    Utilisateur existingUser = existingUserOpt.get();
    // Mise à jour des champs individuels de l'utilisateur
    existingUser.setPrenom(user.getPrenom());                 // Mettre à jour le prénom
    existingUser.setNom(user.getNom());                       // Mettre à jour le nom
    existingUser.setDateNaissance(user.getDateNaissance());   // Mettre à jour la date de naissance
    existingUser.setNumeroCarte(user.getNumeroCarte());       // Mettre à jour le numéro de carte
    existingUser.setTelephone(user.getTelephone());           // Mettre à jour le téléphone
    existingUser.setEmail(user.getEmail());                   // Mettre à jour l'email
    existingUser.setMotDePasse(user.getMotDePasse());         // Mettre à jour le mot de passe

    // 3. Sauvegarder les modifications dans la base de données
    Utilisateur updatedUser = userService.updateUser(existingUser);

    // 4. Retourner une réponse HTTP 200 OK contenant l'utilisateur mis à jour
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }
}