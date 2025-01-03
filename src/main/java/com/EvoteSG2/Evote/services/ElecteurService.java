package com.EvoteSG2.Evote.services;

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

    public Electeur updateElecteur(Electeur electeur) {
        return electeurRepository.save(electeur);
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

    public List<Electeur> findByAVote(Boolean aVote) {
        return electeurRepository.findByaVote(aVote);
    }
}