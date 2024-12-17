package planteMedicinale.plante.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Plante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private String famille;
    private String proprietes;
    private String utilisations;
    private String precautions;
    private String interactions;
    private String regionGeographique;

    // Relations avec Images, Vidéos, Commentaires, Articles et Recommandations
    @OneToMany(mappedBy = "plante")
    private List<Image> images;

    @OneToMany(mappedBy = "plante")
    private List<Video> videos;

    @OneToMany(mappedBy = "plante")
    private List<Commentaire> commentaires;

    @OneToMany(mappedBy = "plante")
    private List<Article> articles;
    @JsonIgnoreProperties({"recommandations"})
    @OneToMany(mappedBy = "plante")
    private List<Recommandation> recommandations;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getProprietes() {
        return proprietes;
    }

    public void setProprietes(String proprietes) {
        this.proprietes = proprietes;
    }

    public String getUtilisations() {
        return utilisations;
    }

    public void setUtilisations(String utilisations) {
        this.utilisations = utilisations;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getInteractions() {
        return interactions;
    }

    public void setInteractions(String interactions) {
        this.interactions = interactions;
    }

    public String getRegionGeographique() {
        return regionGeographique;
    }

    public void setRegionGeographique(String regionGeographique) {
        this.regionGeographique = regionGeographique;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Recommandation> getRecommandations() {
        return recommandations;
    }

    public void setRecommandations(List<Recommandation> recommandations) {
        this.recommandations = recommandations;
    }

}