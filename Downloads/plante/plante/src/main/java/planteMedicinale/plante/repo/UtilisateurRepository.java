package planteMedicinale.plante.repo;

import org.springframework.data.repository.CrudRepository;
import planteMedicinale.plante.entity.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
    Utilisateur findByEmail(String email);
}
