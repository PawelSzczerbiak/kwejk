package pl.szczerbiak.kwejk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.szczerbiak.kwejk.model.Gif;

@Controller
public class HomeController {

    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("gif", new Gif("compiler-bot"));
        return "home";
    }
}
