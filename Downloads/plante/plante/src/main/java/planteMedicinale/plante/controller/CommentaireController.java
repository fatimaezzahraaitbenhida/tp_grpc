package planteMedicinale.plante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planteMedicinale.plante.Service.ArticleService;
import planteMedicinale.plante.Service.CommentaireService;
import planteMedicinale.plante.dto.ArticleDTO;
import planteMedicinale.plante.dto.CommentaireDTO;
import planteMedicinale.plante.entity.Commentaire;

import java.util.List;
@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    // Récupérer les commentaires pour une plante donnée
    @GetMapping("/plante/{planteId}")
    public ResponseEntity<List<CommentaireDTO>> getCommentairesByPlante(@PathVariable Long planteId) {
        List<CommentaireDTO> commentaires = commentaireService.getCommentairesByPlante(planteId);
        return ResponseEntity.ok(commentaires);
    }

    // Ajouter un nouveau commentaire
    @PostMapping("/add")
    public ResponseEntity<Commentaire> addCommentaire(@RequestBody Commentaire commentaire) {
        Commentaire savedCommentaire = commentaireService.saveCommentaire(commentaire);
        return ResponseEntity.ok(savedCommentaire);
    }
}
