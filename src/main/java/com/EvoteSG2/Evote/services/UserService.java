package com.EvoteSG2.Evote.services;

import com.EvoteSG2.Evote.entities.Utilisateur;
import com.EvoteSG2.Evote.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;
  
  public List<Utilisateur> getAllUsers() {
    return userRepository.findAll();
  }

}