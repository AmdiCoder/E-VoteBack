package com.EvoteSG2.Evote.services;

import com.EvoteSG2.Evote.entities.Administrateur;
import com.EvoteSG2.Evote.repositories.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService {

    private final AdministrateurRepository administrateurRepository;

    @Autowired
    public AdministrateurService(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }

    public Administrateur getAdministrateurById(Integer id) {
        return administrateurRepository.findById(id).orElse(null);
    }

    public Administrateur createAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    public Administrateur updateAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    public void deleteAdministrateur(Integer id) {
        administrateurRepository.deleteById(id);
    }

    public Administrateur findByMatricule(String matricule) {
        return administrateurRepository.findByMatricule(matricule);
    }
}