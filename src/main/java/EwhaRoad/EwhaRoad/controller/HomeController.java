package EwhaRoad.EwhaRoad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "SetDestinations";//여기를 수정
    }
}