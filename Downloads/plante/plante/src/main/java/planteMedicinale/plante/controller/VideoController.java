package planteMedicinale.plante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import planteMedicinale.plante.Service.VideoService;
import planteMedicinale.plante.entity.Video;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/plante/{planteId}")
    public List<Video> getVideosByPlanteId(@PathVariable Long planteId) {
        return videoService.getVideosByPlanteId(planteId);
    }

    @PostMapping("/add")
    public Video addVideo(@RequestBody Video video) {
        return videoService.saveVideo(video);
    }
}