package pl.szczerbiak.kwejk.controller;

import com.sun.imageio.plugins.gif.GIFStreamMetadataFormatResources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.szczerbiak.kwejk.repository.CategoryRepository;
import pl.szczerbiak.kwejk.repository.GifRepository;

@Controller
public class GifController {

    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("gifs", GifRepository.findAll());
        return "home";
    }

    @PostMapping("/")
    public String gifSearch(@RequestParam String name, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("name", name);
        return "redirect:/gifsfound";
    }

    @GetMapping("gifsfound")
    public String displayFoundGifs(Model model, @ModelAttribute("name") String name){
        model.addAttribute("gifs", GifRepository.findAllByName(name));
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
