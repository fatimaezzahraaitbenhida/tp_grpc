package planteMedicinale.plante.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planteMedicinale.plante.dto.PlanteDTO;
import planteMedicinale.plante.dto.RecommandationDTO;
import planteMedicinale.plante.entity.Plante;
import planteMedicinale.plante.entity.Recommandation;
import planteMedicinale.plante.entity.Utilisateur;
import planteMedicinale.plante.repo.PlanteRepository;
import planteMedicinale.plante.repo.RecommandationRepository;
import planteMedicinale.plante.repo.UtilisateurRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommandationService {

    @Autowired
    private PlanteRepository planteRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RecommandationRepository recommendationRepository;
    @Autowired
    private RecommandationService recommandationService;


    public Recommandation saveRecommandation(Recommandation recommandation) {
        return recommendationRepository.save(recommandation);
    }

    public List<Recommandation> getRecommendationsForUser(Long utilisateurId) {
        return recommendationRepository.findByUtilisateurId(utilisateurId);
    }
    public List<RecommandationDTO> getRecommandationsByAntecedents(String antecedents) {
        // Vous pouvez ajouter des logiques spécifiques ici pour filtrer les plantes
        // basées sur les antécédents médicaux
        List<Plante> plantes = planteRepository.findByUtilisationsContaining(antecedents);
        List<RecommandationDTO> recommandations = new ArrayList<>();

        // Convertir les plantes en recommandations
        for (Plante plante : plantes) {
            RecommandationDTO recommandationDTO = new RecommandationDTO();
            recommandationDTO.setPlante(plante);
            recommandationDTO.setRaison("Recommandée pour: " + plante.getUtilisations());
            recommandations.add(recommandationDTO);
        }
        return recommandations;
    }


    public List<PlanteDTO> recommanderPlantes(Long utilisateurId) {
        Utilisateur utilisateur = utilisateurRepository.findById(Math.toIntExact(utilisateurId)).orElse(null);
        if (utilisateur == null) {
            throw new IllegalArgumentException("Utilisateur non trouvé");
        }

        List<PlanteDTO> recommandations = new ArrayList<>();

        // Exemple : une simple logique basée sur les antécédents médicaux de l'utilisateur
        String antecedents = utilisateur.getAntecedentsMedicaux().toLowerCase();

        if (antecedents.contains("digestion")) {
            // Ajouter des plantes recommandées pour la digestion
            Plante plante = planteRepository.findByNom("Menthe");
            recommandations.add(new PlanteDTO(plante.getId(), plante.getNom(), plante.getDescription(), plante.getUtilisations()));
        }

        if (antecedents.contains("maux de tête")) {
            // Ajouter des plantes recommandées pour les maux de tête
            Plante plante = planteRepository.findByNom("Lavande");
            recommandations.add(new PlanteDTO(plante.getId(), plante.getNom(), plante.getDescription(), plante.getUtilisations()));
        }

        // Vous pouvez ajouter plus de conditions pour d'autres maladies ou besoins de santé

        return recommandations;
    }
    public List<RecommandationDTO> genererRecommandations(Long utilisateurId) {
        // Récupérer l'utilisateur
        Utilisateur utilisateur = utilisateurRepository.findById(Math.toIntExact(utilisateurId))
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        // Récupérer les antécédents médicaux de l'utilisateur
        String antecedentsMedicaux = utilisateur.getAntecedentsMedicaux();

        // Créer une liste pour stocker les recommandations
        List<RecommandationDTO> recommandations = new ArrayList<>();

        // Exemple de logique basée sur les antécédents médicaux
        if (antecedentsMedicaux.contains("Hypertension")) {
            Plante plante = planteRepository.findByNom("Ail"); // Plante recommandée pour l'hypertension
            RecommandationDTO recommandation = new RecommandationDTO();
            recommandation.setUtilisateur(utilisateur);
            recommandation.setPlante(plante);
            recommandation.setRaison("Réduction de la pression artérielle");
            recommandations.add(recommandation);
        }

        if (antecedentsMedicaux.contains("Diabète")) {
            Plante plante = planteRepository.findByNom("Fenugrec"); // Plante recommandée pour le diabète
            RecommandationDTO recommandation = new RecommandationDTO();
            recommandation.setUtilisateur(utilisateur);
            recommandation.setPlante(plante);
            recommandation.setRaison("Contrôle de la glycémie");
            recommandations.add(recommandation);
        }

        if (antecedentsMedicaux.contains("Renforcement du système immunitaire")) {
            Plante plante = planteRepository.findByNom("Echinacea"); // Plante recommandée pour l'immunité
            RecommandationDTO recommandation = new RecommandationDTO();
            recommandation.setUtilisateur(utilisateur);
            recommandation.setPlante(plante);
            recommandation.setRaison("Renforcement du système immunitaire");
            recommandations.add(recommandation);
        }

        // Sauvegarder les recommandations dans la base de données
        for (RecommandationDTO recommandationDTO : recommandations) {
            Recommandation recommandation = new Recommandation();
            recommandation.setUtilisateur(recommandationDTO.getUtilisateur());
            recommandation.setPlante(recommandationDTO.getPlante());
            recommandation.setRaison(recommandationDTO.getRaison());
            recommendationRepository.save(recommandation);
        }

        return recommandations;
    }
}
