package planteMedicinale.plante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import planteMedicinale.plante.Service.ImageService;
import planteMedicinale.plante.entity.Image;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/plante/{planteId}")
    public List<Image> getImagesByPlanteId(@PathVariable Long planteId) {
        return imageService.getImagesByPlanteId(planteId);
    }


    @PostMapping("/add")
    public Image addImage(@RequestBody Image image) {
        return imageService.saveImage(image);
    }
}
