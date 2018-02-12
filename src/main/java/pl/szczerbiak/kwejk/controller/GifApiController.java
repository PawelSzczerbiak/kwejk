package pl.szczerbiak.kwejk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.szczerbiak.kwejk.model.Gif;
import pl.szczerbiak.kwejk.repository.GifRepository;

import java.util.List;

// JSON format

@RestController
public class GifApiController {

    @GetMapping("/api/gifs")
    public List<Gif> gifs(){
        return GifRepository.findAll();
    }

    @GetMapping("api/gifs/find")
    public List<Gif> findGifs(@RequestParam String name){
        return GifRepository.findAllByName(name);
    }
}
