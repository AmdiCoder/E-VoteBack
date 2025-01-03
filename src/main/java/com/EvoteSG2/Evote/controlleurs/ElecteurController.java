package com.EvoteSG2.Evote.controlleurs;

import com.EvoteSG2.Evote.entities.Electeur;
import com.EvoteSG2.Evote.services.ElecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/electeurs")
public class ElecteurController {

    private final ElecteurService electeurService;

    @Autowired
    public ElecteurController(ElecteurService electeurService) {
        this.electeurService = electeurService;
    }

    @GetMapping
    public ResponseEntity<List<Electeur>> getAllElecteurs() {
        List<Electeur> electeurs = electeurService.getAllElecteurs();
        return ResponseEntity.ok(electeurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Electeur> getElecteurById(@PathVariable Integer id) {
        Electeur electeur = electeurService.getElecteurById(id);
        return ResponseEntity.ok(electeur);
    }

    @PostMapping
    public ResponseEntity<Electeur> createElecteur(@RequestBody Electeur electeur) {
        Electeur newElecteur = electeurService.createElecteur(electeur);
        return ResponseEntity.ok(newElecteur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Electeur> updateElecteur(@PathVariable Integer id, @RequestBody Electeur electeur) {
        Electeur updatedElecteur = electeurService.updateElecteur(electeur);
        return ResponseEntity.ok(updatedElecteur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElecteur(@PathVariable Integer id) {
        electeurService.deleteElecteur(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/region/{region}")
    public ResponseEntity<List<Electeur>> findByRegion(@PathVariable String region) {
        List<Electeur> electeurs = electeurService.findByRegion(region);
        return ResponseEntity.ok(electeurs);
    }

    @GetMapping("/departement/{departement}")
    public ResponseEntity<List<Electeur>> findByDepartement(@PathVariable String departement) {
        List<Electeur> electeurs = electeurService.findByDepartement(departement);
        return ResponseEntity.ok(electeurs);
    }

    @GetMapping("/a_vote/{aVote}")
    public ResponseEntity<List<Electeur>> findByAVote(@PathVariable Boolean aVote) {
        List<Electeur> electeurs = electeurService.findByAVote(aVote);
        return ResponseEntity.ok(electeurs);
    }
}