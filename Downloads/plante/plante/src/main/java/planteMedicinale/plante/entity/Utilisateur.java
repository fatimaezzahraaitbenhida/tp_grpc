package planteMedicinale.plante.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;

    @Lob
    private String antecedentsMedicaux;

    // Relations avec Commentaires et Recommandations
    @OneToMany(mappedBy = "utilisateur")
    private List<Commentaire> commentaires;

    @JsonManagedReference
    @OneToMany(mappedBy = "utilisateur")
    private List<Recommandation> recommandations;



    public List<Recommandation> getRecommandations() {
        return recommandations;
    }

    public void setRecommandations(List<Recommandation> recommandations) {
        this.recommandations = recommandations;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public String getAntecedentsMedicaux() {
        return antecedentsMedicaux;
    }

    public void setAntecedentsMedicaux(String antecedentsMedicaux) {
        this.antecedentsMedicaux = antecedentsMedicaux;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur(Long id, String nom, String email, String antecedentsMedicaux, List<Commentaire> commentaires, List<Recommandation> recommandations) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.antecedentsMedicaux = antecedentsMedicaux;
        this.commentaires = commentaires;
        this.recommandations = recommandations;
    }
    public Utilisateur() {
    }
    public Utilisateur(Long id) {
        this.id = id;
    }
}