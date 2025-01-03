package com.EvoteSG2.Evote.controlleurs;

import com.EvoteSG2.Evote.entities.Administrateur;
import com.EvoteSG2.Evote.services.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrateurs")
public class AdministrateurController {

    private final AdministrateurService administrateurService;

    @Autowired
    public AdministrateurController(AdministrateurService administrateurService) {
        this.administrateurService = administrateurService;
    }

    @GetMapping
    public ResponseEntity<List<Administrateur>> getAllAdministrateurs() {
        List<Administrateur> administrateurs = administrateurService.getAllAdministrateurs();
        return ResponseEntity.ok(administrateurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrateur> getAdministrateurById(@PathVariable Integer id) {
        Administrateur administrateur = administrateurService.getAdministrateurById(id);
        return ResponseEntity.ok(administrateur);
    }

    @PostMapping
    public ResponseEntity<Administrateur> createAdministrateur(@RequestBody Administrateur administrateur) {
        Administrateur newAdministrateur = administrateurService.createAdministrateur(administrateur);
        return ResponseEntity.ok(newAdministrateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrateur> updateAdministrateur(@PathVariable Integer id, @RequestBody Administrateur administrateur) {
        Administrateur updatedAdministrateur = administrateurService.updateAdministrateur(administrateur);
        return ResponseEntity.ok(updatedAdministrateur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrateur(@PathVariable Integer id) {
        administrateurService.deleteAdministrateur(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/matricule/{matricule}")
    public ResponseEntity<Administrateur> findByMatricule(@PathVariable String matricule) {
        Administrateur administrateur = administrateurService.findByMatricule(matricule);
        return ResponseEntity.ok(administrateur);
    }
}