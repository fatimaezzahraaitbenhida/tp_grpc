package planteMedicinale.plante.entity;

import jakarta.persistence.*;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plante_id")
    private Plante plante;

    private String url;
    private String description;

    // Getters et Setters
}