package com.EvoteSG2.Evote.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.EvoteSG2.Evote.dto.RegisterRequest;
import com.EvoteSG2.Evote.entities.Utilisateur;
import com.EvoteSG2.Evote.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository utilisateurRepository;

  public List<Utilisateur> getAllUsers() {
    return utilisateurRepository.findAll();
  }

  public Utilisateur getUserById(Integer id) {
    return utilisateurRepository.findById(Long.valueOf(id)).orElse(null);
  }

  public Utilisateur createUser(Utilisateur user) {
    return utilisateurRepository.save(user);
  }

  public Utilisateur updateUser(Integer id, Utilisateur user) {
    Utilisateur existingUser = getUserById(id);
    if (existingUser!= null) {
      existingUser.setNom(user.getNom());
      existingUser.setPrenom(user.getPrenom());
      return utilisateurRepository.save(existingUser);
    } else {
      return null;
    }
  }

  public void deleteUser(Integer id) {
    utilisateurRepository.deleteById(Long.valueOf(id));
  }




  //enregistrement dans la dase de données
  @Autowired
  private PasswordEncoder passwordEncoder;

    public void register(RegisterRequest registerRequest){
        Utilisateur user=new Utilisateur();
        user.setPrenom(registerRequest.getPrenom());
        user.setNom(registerRequest.getNom());
        user.setDateNaissance(registerRequest.getDateNaissance());
        user.setNumeroCarte(registerRequest.getNumeroCarte());
        user.setTelephone(registerRequest.getTelephone());
        user.setRole(registerRequest.getRole());
        user.setEmail(registerRequest.getEmail());
        //on va encoder le mot de passe avant d'enregistrer l'utilisateur
        user.setMotDePasse(passwordEncoder.encode(registerRequest.getMotDePasse()));
        user.setDateCreation(registerRequest.getDateCreation());
        utilisateurRepository.save(user);
    }

    //authentification avec le mot de passe et l'email
    public boolean login(String email, String MotDePasse){
        Utilisateur user=utilisateurRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return passwordEncoder.matches(MotDePasse, user.getMotDePasse());

    }

    public void logout(String email) {
        // Vous pouvez utiliser un mécanisme pour invalider la session utilisateur.
        // Si vous utilisez un système de tokens (comme JWT), il faut invalider ou marquer le token comme expiré.
        Utilisateur user = utilisateurRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
    
        // Exemple : Vous pouvez enregistrer un état "déconnecté" ou invalider une session côté serveur
        System.out.println("L'utilisateur " + user.getEmail() + " a été déconnecté.");
        
        // Si vous gérez des sessions, elles peuvent être détruites ici.
        // Si vous utilisez Spring Security, pensez à SecurityContextHolder.clearContext().
    }
}