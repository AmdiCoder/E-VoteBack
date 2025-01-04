package com.EvoteSG2.Evote.controlleurs;

import com.EvoteSG2.Evote.entities.Administrateur;
import com.EvoteSG2.Evote.services.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdministrateurController {

    private final AdministrateurService administrateurService;

    @Autowired
    public AdministrateurController(AdministrateurService administrateurService) {
        this.administrateurService = administrateurService;
    }
    //Recuperer La liste des administrateurs
    @GetMapping
    public ResponseEntity<List<Administrateur>> getAllAdministrateurs() {
        List<Administrateur> administrateurs = administrateurService.getAllAdministrateurs();
        return ResponseEntity.ok(administrateurs);
    }
    //Recuperer un administrateur par son identifiant
    @GetMapping("/{id}")
    public ResponseEntity<Administrateur> getAdministrateurById(@PathVariable Integer id) {
        Administrateur administrateur = administrateurService.getAdministrateurById(id);
        return ResponseEntity.ok(administrateur);
    }
    //Ajouter un administrateur
    @PostMapping
    public ResponseEntity<Administrateur> createAdministrateur(@RequestBody Administrateur administrateur) {
        Administrateur newAdministrateur = administrateurService.createAdministrateur(administrateur);
        return ResponseEntity.ok(newAdministrateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrateur> updateAdministrateur(@PathVariable Integer id, @RequestBody Administrateur administrateur) {
        Administrateur updatedAdministrateur = administrateurService.updateAdministrateur(id,administrateur);
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