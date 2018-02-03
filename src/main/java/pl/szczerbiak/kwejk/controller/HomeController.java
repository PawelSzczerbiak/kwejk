package pl.szczerbiak.kwejk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.szczerbiak.kwejk.model.Gif;
import pl.szczerbiak.kwejk.repository.GifRepository;

@Controller
public class HomeController {

    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("gifs", GifRepository.findAll());
        return "home";
    }

    @GetMapping("/favorites")
    public String favorites(Model model){
        model.addAttribute("gifs", GifRepository.findFavorites());
        return "favorites";
    }

    @GetMapping("/gif/{name}")
    public String displayGif(@PathVariable String name, Model model){
        model.addAttribute("gif", GifRepository.findByName(name));
        return "gif-details";
    }
}
