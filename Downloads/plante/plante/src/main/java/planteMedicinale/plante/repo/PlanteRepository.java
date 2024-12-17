package planteMedicinale.plante.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import planteMedicinale.plante.entity.Plante;

import java.util.List;
@Repository
public interface PlanteRepository extends JpaRepository<Plante, Long> {
    List<Plante> findByProprietesContainingIgnoreCase(String antecedents);
       List<Plante> findByInteractionsContainingIgnoreCase(String keyword);

    List<Plante> findByPrecautionsContainingIgnoreCase(String keyword);
    @Query("SELECT p FROM Plante p WHERE " +
            "(:nom IS NULL OR LOWER(p.nom) LIKE LOWER(CONCAT('%', :nom, '%'))) AND " +
            "(:proprietes IS NULL OR LOWER(p.proprietes) LIKE LOWER(CONCAT('%', :proprietes, '%'))) AND " +
            "(:utilisations IS NULL OR LOWER(p.utilisations) LIKE LOWER(CONCAT('%', :utilisations, '%'))) AND " +
            "(:regionGeographique IS NULL OR LOWER(p.regionGeographique) LIKE LOWER(CONCAT('%', :regionGeographique, '%')))")
    List<Plante> findByAdvancedSearch(@Param("nom") String nom,
                                      @Param("proprietes") String proprietes,
                                      @Param("utilisations") String utilisations,
                                      @Param("regionGeographique") String regionGeographique);

    Plante findByNom(String menthe);

    List<Plante> findByUtilisationsContaining(String antecedents);
}
