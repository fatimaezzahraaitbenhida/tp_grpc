package planteMedicinale.plante.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planteMedicinale.plante.entity.Image;
import planteMedicinale.plante.repo.ImageRepository;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getImagesByPlanteId(Long planteId) {
        return imageRepository.findByPlanteId(planteId);
    }

    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }
}