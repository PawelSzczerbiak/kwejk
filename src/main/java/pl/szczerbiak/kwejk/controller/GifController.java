package pl.szczerbiak.kwejk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.szczerbiak.kwejk.repository.GifRepository;

@Controller
public class GifController {

    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("gifs", GifRepository.findAll());
        return "home";
    }

    @PostMapping("/")
    public String helloSearch(@RequestParam String name, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("gif", GifRepository.findByName(name));
        // TODO: better to show all found matches instead of only one
        return "redirect:/gif/"+name;
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
