package pl.szczerbiak.kwejk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.szczerbiak.kwejk.repository.CategoryRepository;
import pl.szczerbiak.kwejk.repository.GifRepository;

@Controller
public class CategoryController {

    @GetMapping("/categories")
    public String displayAll(Model model){
        model.addAttribute("categories", CategoryRepository.findAll());
        return "categories";
    }

    @GetMapping("category/{id}")
    public String displayCategory(@PathVariable int id, Model model){
        model.addAttribute("category", CategoryRepository.findByCategoryId(id));
        model.addAttribute("gifs", GifRepository.findByCategoryId(id));
        return "category";
    }
}
