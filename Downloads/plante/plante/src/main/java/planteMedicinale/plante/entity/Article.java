package planteMedicinale.plante.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String contenu;
    private String auteur;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime datePublication;

    @ManyToOne
    @JoinColumn(name = "plante_id")
    private Plante plante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @PrePersist
    public void prePersist() {
        this.datePublication = LocalDateTime.now();
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public LocalDateTime getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDateTime datePublication) {
        this.datePublication = datePublication;
    }

    public Plante getPlante() {
        return plante;
    }

    public void setPlante(Plante plante) {
        this.plante = plante;
    }
// Getters et Setters
}