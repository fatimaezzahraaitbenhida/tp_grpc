package planteMedicinale.plante.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planteMedicinale.plante.entity.Plante;
import planteMedicinale.plante.exception.ResourceNotFoundException;
import planteMedicinale.plante.repo.PlanteRepository;

import java.util.List;

@Service
public class PlanteService {

    @Autowired
    private PlanteRepository planteRepository;

    public List<Plante> getAllPlantes() {
        return planteRepository.findAll();
    }

    public Plante getPlanteById(Long id) {
        return planteRepository.findById(id).orElse(null);
    }

    public Plante savePlante(Plante plante) {
        return planteRepository.save(plante);
    }
    public Plante getPlanteDetails(Long id) {
        return planteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Plante non trouvée"));
    }
    public List<Plante> searchPlantes(String nom, String proprietes, String utilisations, String regionGeographique) {
        return planteRepository.findByAdvancedSearch(nom, proprietes, utilisations, regionGeographique);
    }
    public List<Plante> getPlantesByPrecautionKeyword(String keyword) {
        return planteRepository.findByPrecautionsContainingIgnoreCase(keyword);
    }

    public List<Plante> getPlantesByInteractionKeyword(String keyword) {
        return planteRepository.findByInteractionsContainingIgnoreCase(keyword);
    }

    public String getPrecautionsById(Long planteId) {
        Plante plante = planteRepository.findById(planteId)
                .orElseThrow(() -> new RuntimeException("Plante non trouvée"));
        return plante.getPrecautions();
    }

    public String getInteractionsById(Long planteId) {
        Plante plante = planteRepository.findById(planteId)
                .orElseThrow(() -> new RuntimeException("Plante non trouvée"));
        return plante.getInteractions();
    }
    public String getPrecautionsAndInteractions(Long id) {
        Plante plante = planteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plante non trouvée"));
        return "Précautions : " + plante.getPrecautions() + "\n" +
                "Interactions : " + plante.getInteractions();
    }
}