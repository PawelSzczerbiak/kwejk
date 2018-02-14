package pl.szczerbiak.kwejk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.szczerbiak.kwejk.repository.CategoryRepository;
import pl.szczerbiak.kwejk.repository.GifRepository;

@Controller
public class CategoryController {

    @GetMapping("/categories")
    public String displayAllCategories(Model model){
        model.addAttribute("categories", CategoryRepository.findAll());
        return "categories";
    }

    // TODO: more efficient searching !!!

    @PostMapping("/categories")
    public String categorySearch(@RequestParam String name, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("name", name);
        return "redirect:/categoriesfound";
    }

    @GetMapping("/categoriesfound")
    public String displayFoundCategories(Model model, @ModelAttribute("name") String name){
        model.addAttribute("categories", CategoryRepository.findAllByName(name));
        return "categories";
    }

    @GetMapping("category/{id}")
    public String displayCategoryGifs(@PathVariable int id, Model model){
        model.addAttribute("category", CategoryRepository.findByCategoryId(id));
        model.addAttribute("gifs", GifRepository.findAllByCategoryId(id));
        return "category";
    }
}
