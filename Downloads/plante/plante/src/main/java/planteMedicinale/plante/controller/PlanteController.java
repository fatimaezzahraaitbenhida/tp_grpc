package planteMedicinale.plante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planteMedicinale.plante.Service.PlanteService;
import planteMedicinale.plante.dto.PlanteDTO;
import planteMedicinale.plante.entity.Plante;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/plantes")
public class PlanteController {

    @Autowired
    private PlanteService planteService;

    // Obtenir toutes les plantes (avec conversion en DTO)
    @GetMapping
    public ResponseEntity<List<PlanteDTO>> getAllPlantes() {
        List<PlanteDTO> plantes = planteService.getAllPlantes()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(plantes);
    }

    // Obtenir une plante par ID
    @GetMapping("/{id}")
    public ResponseEntity<PlanteDTO> getPlanteById(@PathVariable Long id) {
        Plante plante = planteService.getPlanteById(id);
        return ResponseEntity.ok(convertToDTO(plante));
    }

    // Ajouter une plante
    @PostMapping("/add")
    public ResponseEntity<PlanteDTO> addPlante(@RequestBody PlanteDTO planteDTO) {
        try {
            Plante plante = convertToEntity(planteDTO);
            Plante savedPlante = planteService.savePlante(plante);
            return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(savedPlante));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    // Recherche avancée
    @GetMapping("/search")
    public ResponseEntity<List<PlanteDTO>> searchPlantes(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String proprietes,
            @RequestParam(required = false) String utilisations,
            @RequestParam(required = false) String regionGeographique) {

        // Appeler le service pour rechercher les plantes en fonction des critères
        List<Plante> plantes = planteService.searchPlantes(nom, proprietes, utilisations, regionGeographique);

        // Convertir les entités en DTO et renvoyer la réponse
        List<PlanteDTO> result = plantes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }


    // Obtenir les précautions
    @GetMapping("/{id}/precautions")
    public ResponseEntity<String> getPrecautions(@PathVariable Long id) {
        String precautions = planteService.getPrecautionsById(id);
        return ResponseEntity.ok(precautions);
    }

    // Obtenir les interactions
    @GetMapping("/{id}/interactions")
    public ResponseEntity<String> getInteractions(@PathVariable Long id) {
        String interactions = planteService.getInteractionsById(id);
        return ResponseEntity.ok(interactions);
    }

    // Recherche par précautions
    @GetMapping("/search/precautions")
    public ResponseEntity<List<PlanteDTO>> searchByPrecautions(@RequestParam String keyword) {
        List<Plante> plantes = planteService.getPlantesByPrecautionKeyword(keyword);
        List<PlanteDTO> result = plantes.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    // Recherche par interactions
    @GetMapping("/search/interactions")
    public ResponseEntity<List<PlanteDTO>> searchByInteractions(@RequestParam String keyword) {
        List<Plante> plantes = planteService.getPlantesByInteractionKeyword(keyword);
        List<PlanteDTO> result = plantes.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}/details")
    public ResponseEntity<String> getPrecautionsAndInteractions(@PathVariable Long id) {
        String details = planteService.getPrecautionsAndInteractions(id);
        return ResponseEntity.ok(details);
    }

    // Méthode de conversion Entité -> DTO
    private PlanteDTO convertToDTO(Plante plante) {
        PlanteDTO dto = new PlanteDTO();
        dto.setId(plante.getId());
        dto.setNom(plante.getNom());
        dto.setDescription(plante.getDescription());
        dto.setFamille(plante.getFamille());
        dto.setProprietes(plante.getProprietes());
        dto.setUtilisations(plante.getUtilisations());
        dto.setPrecautions(plante.getPrecautions());
        dto.setInteractions(plante.getInteractions());
        dto.setRegionGeographique(plante.getRegionGeographique());
        return dto;
    }

    // Méthode de conversion DTO -> Entité
    private Plante convertToEntity(PlanteDTO planteDTO) {
        Plante plante = new Plante();
        plante.setNom(planteDTO.getNom());
        plante.setDescription(planteDTO.getDescription());
        plante.setFamille(planteDTO.getFamille());
        plante.setProprietes(planteDTO.getProprietes());
        plante.setUtilisations(planteDTO.getUtilisations());
        plante.setPrecautions(planteDTO.getPrecautions());
        plante.setInteractions(planteDTO.getInteractions());
        plante.setRegionGeographique(planteDTO.getRegionGeographique());
        return plante;
    }
}
