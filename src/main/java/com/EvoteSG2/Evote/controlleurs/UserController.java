package com.EvoteSG2.Evote.controlleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EvoteSG2.Evote.dto.LoginRequest;
import com.EvoteSG2.Evote.dto.LogoutRequest;
import com.EvoteSG2.Evote.dto.RegisterRequest;
import com.EvoteSG2.Evote.entities.Utilisateur;
import com.EvoteSG2.Evote.services.UserService;

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


  //Endpoint d'inscription
   @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest){
        userService.register(registerRequest);
        return "utilisateur ajouté avec succès";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        if (userService.login(loginRequest.getEmail(), loginRequest.getMotDePasse())){
            return "login successfull";
        }
        else{
            return "invalide username and password";
        }

    }

    @PostMapping("/logout")
    public String logout(@RequestBody LogoutRequest logoutRequest) {
        try {
            userService.logout(logoutRequest.getEmail());
            return "logout successful";
        } catch (RuntimeException e) {
            return "error: " + e.getMessage();
        }
    }


}