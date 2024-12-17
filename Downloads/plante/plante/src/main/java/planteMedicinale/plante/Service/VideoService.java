package planteMedicinale.plante.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planteMedicinale.plante.entity.Video;
import planteMedicinale.plante.repo.VideoRepository;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getVideosByPlanteId(Long planteId) {
        return videoRepository.findByPlanteId(planteId);
    }

    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }
}