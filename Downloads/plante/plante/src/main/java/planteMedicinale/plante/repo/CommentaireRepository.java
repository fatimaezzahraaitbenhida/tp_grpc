package planteMedicinale.plante.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planteMedicinale.plante.entity.Commentaire;

import java.util.List;
@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    List<Commentaire> findByPlanteId(Long planteId);  // Récupérer les commentaires pour une plante donnée

}

