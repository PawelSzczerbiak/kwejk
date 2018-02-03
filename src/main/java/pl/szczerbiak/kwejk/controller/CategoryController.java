package pl.szczerbiak.kwejk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.szczerbiak.kwejk.repository.CategoryRepository;

@Controller
public class CategoryController {

    @GetMapping("/categories")
    public String displayAll(Model model){
        model.addAttribute("categories", CategoryRepository.findAll());
        return "categories";
    }
}
