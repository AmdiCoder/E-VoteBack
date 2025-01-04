package com.EvoteSG2.Evote.services;

import com.EvoteSG2.Evote.entities.Utilisateur;
import com.EvoteSG2.Evote.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

  public Utilisateur updateUser(Utilisateur utilisateur) {
    return utilisateurRepository.save(utilisateur);
  }

  public void deleteUser(Integer id) {
    utilisateurRepository.deleteById(Long.valueOf(id));
  }
}