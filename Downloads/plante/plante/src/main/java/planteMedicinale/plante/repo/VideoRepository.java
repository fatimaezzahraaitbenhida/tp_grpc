package planteMedicinale.plante.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import planteMedicinale.plante.entity.Video;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video,Long> {
    List<Video> findByPlanteId(Long planteId);
}
