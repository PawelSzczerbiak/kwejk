package pl.szczerbiak.kwejk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.szczerbiak.kwejk.model.Category;
import pl.szczerbiak.kwejk.model.Gif;
import pl.szczerbiak.kwejk.repository.CategoryRepository;
import pl.szczerbiak.kwejk.repository.GifRepository;

import java.util.List;

// JSON format

@RestController
public class CategoryApiController {

    @GetMapping("/api/categories")
    public List<Category> categories(){
        return CategoryRepository.findAll();
    }

    @GetMapping("api/categories/find")
    public List<Category> findCategories(@RequestParam String name){
        return CategoryRepository.findAllByName(name);
    }
}
