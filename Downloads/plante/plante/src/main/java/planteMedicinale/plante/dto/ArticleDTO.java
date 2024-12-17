package planteMedicinale.plante.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ArticleDTO {
    private Long id;
    private String titre;
    private String contenu;
    private String auteur;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")// ID de l'utilisateur qui a posté le commentaire
    private LocalDateTime datePublication;
    private String planteNom; // Nom de la plante associée

    // Getters et Setters
    public ArticleDTO(){

}
    public ArticleDTO(Long id, String titre, String contenu, String auteur, LocalDateTime datePublication, String planteNom) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.planteNom = planteNom;
    }

    public String getPlanteNom() {
        return planteNom;
    }

    public void setPlanteNom(String planteNom) {
        this.planteNom = planteNom;
    }

    public LocalDateTime getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDateTime datePublication) {
        this.datePublication = datePublication;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
