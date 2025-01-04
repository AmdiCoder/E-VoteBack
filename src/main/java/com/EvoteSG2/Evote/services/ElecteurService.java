package com.EvoteSG2.Evote.services;

import com.EvoteSG2.Evote.entities.Electeur;
import com.EvoteSG2.Evote.entities.Electeur;
import com.EvoteSG2.Evote.repositories.ElecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElecteurService {

    private final ElecteurRepository electeurRepository;

    @Autowired
    public ElecteurService(ElecteurRepository electeurRepository) {
        this.electeurRepository = electeurRepository;
    }

    public List<Electeur> getAllElecteurs() {
        return electeurRepository.findAll();
    }

    public Electeur getElecteurById(Integer id) {
        return electeurRepository.findById(id).orElse(null);
    }

    public Electeur createElecteur(Electeur electeur) {
        return electeurRepository.save(electeur);
    }

    // Méthode pour mettre à jour un electeur
    public Electeur updateElecteur(Integer id, Electeur electeur) {
        // Vérifie si l'electeur existe dans la base de données
        Electeur existingelecteur = electeurRepository.findById(id).orElse(null);

        if (existingelecteur != null) {
            // Met à jour les propriétés du electeur existant
            existingelecteur.setPrenom(electeur.getPrenom());
            existingelecteur.setNom(electeur.getNom());
            existingelecteur.setRegion(electeur.getRegion());
            existingelecteur.setDepartement(electeur.getDepartement());
            // Sauvegarde l'electeur mis à jour
            return electeurRepository.save(existingelecteur);
        }

        // Si l'electeur n'existe pas, retourne null (ou lance une exception)
        return null;
    }

    public void deleteElecteur(Integer id) {
        electeurRepository.deleteById(id);
    }

    public List<Electeur> findByRegion(String region) {
        return electeurRepository.findByRegion(region);
    }

    public List<Electeur> findByDepartement(String departement) {
        return electeurRepository.findByDepartement(departement);
    }
}