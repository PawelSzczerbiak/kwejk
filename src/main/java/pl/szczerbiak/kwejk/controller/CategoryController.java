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

    @PostMapping("/categories")
    public String categorySearch(@RequestParam String name, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("id", String.valueOf(CategoryRepository.findByName(name).getId()));
        // TODO: better to show all found matches instead of only one
        return "redirect:/categoryfound";
    }

    @GetMapping("/categoryfound")
    public String displayFoundCategory(Model model, @ModelAttribute("id") int id){
        model.addAttribute("categories", CategoryRepository.findByCategoryId(id));
        return "categories";
    }

    @GetMapping("category/{id}")
    public String displayCategoryGifs(@PathVariable int id, Model model){
        model.addAttribute("category", CategoryRepository.findByCategoryId(id));
        model.addAttribute("gifs", GifRepository.findByCategoryId(id));
        return "category";
    }
}
