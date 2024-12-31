-- Création de la base de données
CREATE DATABASE IF NOT EXISTS evote_db;
USE evote_db;

-- Table Utilisateur (classe parent)
CREATE TABLE utilisateur (
    id_utilisateur INT PRIMARY KEY AUTO_INCREMENT,
    prenom VARCHAR(100) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    date_naissance DATE NOT NULL,
    numero_carte VARCHAR(50) UNIQUE NOT NULL,
    telephone VARCHAR(20) NOT NULL,
    role VARCHAR(20) NOT NULL,
    mot_de_passe VARCHAR(255) NOT NULL,
    date_creation DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Table Electeur
CREATE TABLE electeur (
    id_electeur INT PRIMARY KEY,
    region VARCHAR(100) NOT NULL,
    departement VARCHAR(100) NOT NULL,
    a_vote BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_electeur) REFERENCES utilisateur(id_utilisateur)
);

-- Table Candidat
CREATE TABLE candidat (
    id_candidat INT PRIMARY KEY,
    parti VARCHAR(100) NOT NULL,
    programme TEXT,
    biographie TEXT,
    FOREIGN KEY (id_candidat) REFERENCES utilisateur(id_utilisateur)
);

-- Table Administrateur
CREATE TABLE administrateur (
    id_admin INT PRIMARY KEY,
    matricule VARCHAR(50) UNIQUE NOT NULL,
    FOREIGN KEY (id_admin) REFERENCES utilisateur(id_utilisateur)
);

-- Table Election
CREATE TABLE election (
    id_election INT PRIMARY KEY AUTO_INCREMENT,
    date_debut DATETIME NOT NULL,
    date_fin DATETIME NOT NULL,
    type VARCHAR(100) NOT NULL,
    est_active BOOLEAN DEFAULT TRUE,
    created_by INT,
    FOREIGN KEY (created_by) REFERENCES administrateur(id_admin)
);

-- Table Vote (classe d'association)
CREATE TABLE vote (
    id_election INT,
    id_electeur INT,
    id_candidat INT,
    heure_vote DATETIME DEFAULT CURRENT_TIMESTAMP,
    est_valide BOOLEAN DEFAULT TRUE,
    est_anonyme BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (id_election, id_electeur),
    FOREIGN KEY (id_election) REFERENCES election(id_election),
    FOREIGN KEY (id_electeur) REFERENCES electeur(id_electeur),
    FOREIGN KEY (id_candidat) REFERENCES candidat(id_candidat)
);

-- Table de liaison Election-Candidat
CREATE TABLE election_candidat (
    id_election INT,
    id_candidat INT,
    date_inscription DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_election, id_candidat),
    FOREIGN KEY (id_election) REFERENCES election(id_election),
    FOREIGN KEY (id_candidat) REFERENCES candidat(id_candidat)
);

-- Création des index
CREATE INDEX idx_user_numero_carte ON utilisateur(numero_carte);
CREATE INDEX idx_user_role ON utilisateur(role);
CREATE INDEX idx_electeur_region ON electeur(region);
CREATE INDEX idx_candidat_parti ON candidat(parti);
CREATE INDEX idx_admin_matricule ON administrateur(matricule);
