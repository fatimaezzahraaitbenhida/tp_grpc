package planteMedicinale.plante.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
public class CommentaireDTO {

    private Long id;
    private String commentaire;
    private Long planteId;  // ID de la plante liée au commentaire
    private Long utilisateurId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")// ID de l'utilisateur qui a posté le commentaire
    private LocalDateTime date;

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Long getPlanteId() {
        return planteId;
    }

    public void setPlanteId(Long planteId) {
        this.planteId = planteId;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
