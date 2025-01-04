package com.EvoteSG2.Evote.services;

import com.EvoteSG2.Evote.entities.Administrateur;
import com.EvoteSG2.Evote.entities.Candidat;
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

    // Méthode pour mettre à jour un administrateur
    public Administrateur updateAdministrateur(Integer id, Administrateur administrateur) {
        // Vérifie si l'administrateur existe dans la base de données
        Administrateur existingAdministrateur = administrateurRepository.findById(id).orElse(null);

        if (existingAdministrateur != null) {
            // Met à jour les propriétés du administrateur existant
            existingAdministrateur.setPrenom(administrateur.getPrenom());
            existingAdministrateur.setNom(administrateur.getNom());
            existingAdministrateur.setMatricule(administrateur.getMatricule());


            // Sauvegarde l'administrateur mis à jour
            return administrateurRepository.save(existingAdministrateur);
        }

        // Si l'administrateur n'existe pas, retourne null (ou lance une exception)
        return null;
    }


    public void deleteAdministrateur(Integer id) {
        administrateurRepository.deleteById(id);
    }

    public Administrateur findByMatricule(String matricule) {
        return administrateurRepository.findByMatricule(matricule);
    }
}