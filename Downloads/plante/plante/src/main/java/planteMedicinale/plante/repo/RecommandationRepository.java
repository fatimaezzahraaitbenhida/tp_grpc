package planteMedicinale.plante.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import planteMedicinale.plante.entity.Recommandation;

import java.util.List;

public interface RecommandationRepository extends JpaRepository<Recommandation, Integer> {
    List<Recommandation> findByUtilisateurId(Long utilisateurId);

}
