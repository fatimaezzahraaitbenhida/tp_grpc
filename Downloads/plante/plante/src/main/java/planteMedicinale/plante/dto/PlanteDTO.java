package planteMedicinale.plante.dto;

public class PlanteDTO {
    private Long id;
    private String nom;
    private String description;
    private String famille;
    private String proprietes;
    private String utilisations;
    private String precautions;
    private String interactions;
    private String regionGeographique;

    public PlanteDTO(Long id, String nom,String description,String utilisations) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.utilisations = utilisations;


    }
public PlanteDTO() {}
    public PlanteDTO(Long id, String nom, String description, String famille, String proprietes, String utilisations, String precautions, String interactions, String regionGeographique) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.famille = famille;
        this.proprietes = proprietes;
        this.utilisations = utilisations;
        this.precautions = precautions;
        this.interactions = interactions;
        this.regionGeographique = regionGeographique;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
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
}
