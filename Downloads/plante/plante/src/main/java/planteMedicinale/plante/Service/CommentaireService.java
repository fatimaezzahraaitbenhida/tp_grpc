package planteMedicinale.plante.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planteMedicinale.plante.entity.Commentaire;
import planteMedicinale.plante.repo.CommentaireRepository;
import planteMedicinale.plante.dto.CommentaireDTO;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    // Récupérer les commentaires par ID de plante
    public List<CommentaireDTO> getCommentairesByPlante(Long planteId) {
        List<Commentaire> commentaires = commentaireRepository.findByPlanteId(planteId);
        return commentaires.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Sauvegarder un commentaire
    public Commentaire saveCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    // Méthode pour convertir une entité en DTO
    private CommentaireDTO convertToDTO(Commentaire commentaire) {
        CommentaireDTO dto = new CommentaireDTO();
        dto.setId(commentaire.getId());
        dto.setCommentaire(commentaire.getCommentaire());
        dto.setDate(commentaire.getDate());
        dto.setPlanteId(commentaire.getPlante().getId());
        dto.setUtilisateurId(commentaire.getUtilisateur().getId());
        return dto;
    }
}
