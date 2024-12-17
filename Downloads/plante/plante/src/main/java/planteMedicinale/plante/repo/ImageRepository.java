package planteMedicinale.plante.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import planteMedicinale.plante.entity.Image;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByPlanteId(Long planteId);
}
