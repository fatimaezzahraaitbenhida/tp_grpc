package planteMedicinale.plante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planteMedicinale.plante.Service.RecommandationService;
import planteMedicinale.plante.dto.PlanteDTO;
import planteMedicinale.plante.dto.RecommandationDTO;
import planteMedicinale.plante.entity.Recommandation;
import planteMedicinale.plante.entity.Utilisateur;
import planteMedicinale.plante.exception.ResourceNotFoundException;
import planteMedicinale.plante.repo.UtilisateurRepository;

import java.util.List;

@RestController
@RequestMapping("/api/recommandations")
public class RecommandationController {

    @Autowired
    private RecommandationService recommandationService;
    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @PostMapping("/add")
    public Recommandation addRecommandation(@RequestBody Recommandation recommandation) {
        return recommandationService.saveRecommandation(recommandation);
    }
    @GetMapping("/{utilisateurId}/obtenir")
    public List<PlanteDTO> obtenirRecommandations(@PathVariable Long utilisateurId) {
        return recommandationService.recommanderPlantes(utilisateurId);
    }
    @GetMapping("/{utilisateurId}/recommendations")
    public ResponseEntity<List<Recommandation>> getRecommendations(@PathVariable Long utilisateurId) {
        List<Recommandation> recommendations = recommandationService.getRecommendationsForUser(utilisateurId);
        return ResponseEntity.ok(recommendations);
    }

    @GetMapping("/user/{idUtilisateur}")
    public List<RecommandationDTO> getRecommandations(@PathVariable Long idUtilisateur) {
        return recommandationService.genererRecommandations(idUtilisateur);
    }
}