package pl.szczerbiak.kwejk.repository;

import pl.szczerbiak.kwejk.model.Gif;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GifRepository {

    private static final String DEFAULT_USER = "Pawel"; // TODO: add login possibility
    private static final List<Gif> ALL_GIFS = new ArrayList<>();

    static{
        ALL_GIFS.add(new Gif("android-explosion",DEFAULT_USER, true));
        ALL_GIFS.add(new Gif("ben-and-mike",DEFAULT_USER, true));
        ALL_GIFS.add(new Gif("book-dominos",DEFAULT_USER, false));
        ALL_GIFS.add(new Gif("compiler-bot",DEFAULT_USER, false));
        ALL_GIFS.add(new Gif("cowboy-coder",DEFAULT_USER, true));
        ALL_GIFS.add(new Gif("infinite-andrew",DEFAULT_USER, false));
    }

    public static List<Gif> findAll(){
        return ALL_GIFS;
    }

    public static List<Gif> findFavorites(){
        return ALL_GIFS.stream()
                .filter(Gif::getFavorite)
                .collect(Collectors.toList());
    }

    public static Gif findByName(String name){
        return ALL_GIFS.stream()
                .filter(p-> p.getName().contains(name))
                .findFirst()
                .orElse(ALL_GIFS.get(1)); // TODO: better choice?
    }
}