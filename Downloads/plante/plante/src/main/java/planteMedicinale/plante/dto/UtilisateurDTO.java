package planteMedicinale.plante.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import planteMedicinale.plante.entity.Commentaire;
import planteMedicinale.plante.entity.Recommandation;

import java.util.List;

public class UtilisateurDTO {
    private Long id;
    private String nom;
    private String email;
    private String antecedentsMedicaux;
    private List<Commentaire> commentaires;
    private List<RecommandationDTO> recommandations;
    public UtilisateurDTO() {}

    public UtilisateurDTO(Long id, String nom, String email, String antecedentsMedicaux, List<RecommandationDTO> recommandations) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.antecedentsMedicaux = antecedentsMedicaux;
        this.recommandations = recommandations;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAntecedentsMedicaux() {
        return antecedentsMedicaux;
    }

    public void setAntecedentsMedicaux(String antecedentsMedicaux) {
        this.antecedentsMedicaux = antecedentsMedicaux;
    }

    public List<RecommandationDTO> getRecommandations() {
        return recommandations;
    }

    public void setRecommandations(List<RecommandationDTO> recommandations) {
        this.recommandations = recommandations;
    }
}
