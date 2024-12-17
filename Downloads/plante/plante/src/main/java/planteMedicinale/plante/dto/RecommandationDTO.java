package planteMedicinale.plante.dto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import planteMedicinale.plante.entity.Plante;
import planteMedicinale.plante.entity.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class RecommandationDTO {
    private Long id;

    private Utilisateur utilisateur;

    private Plante plante;

    private String raison;
    public RecommandationDTO() {}

    public RecommandationDTO(Long id, Utilisateur utilisateur, Plante plante, String raison) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.plante = plante;
        this.raison = raison;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Plante getPlante() {
        return plante;
    }

    public void setPlante(Plante plante) {
        this.plante = plante;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }
    public List<RecommandationDTO> genererRecommandations(Long utilisateurId) {
        List<RecommandationDTO> recommandations = new ArrayList<>();
        // Populate recommendations with necessary fields
        return recommandations;
    }

}
