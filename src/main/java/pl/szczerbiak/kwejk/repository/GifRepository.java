package pl.szczerbiak.kwejk.repository;

import pl.szczerbiak.kwejk.model.Gif;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GifRepository {

    private static final String DEFAULT_USER = "Pawel";
    private static List<Gif> ALL_GIFS = new ArrayList<>();

    static{
        ALL_GIFS.add(new Gif("android-explosion",getDefaultUser(), true));
        ALL_GIFS.add(new Gif("ben-and-mike",getDefaultUser(), false));
        ALL_GIFS.add(new Gif("book-dominos",getDefaultUser(), true));
        ALL_GIFS.add(new Gif("compiler-bot",getDefaultUser(), false));
        ALL_GIFS.add(new Gif("cowboy-coder",getDefaultUser(), false));
        ALL_GIFS.add(new Gif("infinite-andrew",getDefaultUser(), true));
    }

    public static String getDefaultUser() {
        return DEFAULT_USER;
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
                .filter(p-> p.getName().equals(name))
                .findFirst()
                .orElse(ALL_GIFS.get(1));
    }

}
