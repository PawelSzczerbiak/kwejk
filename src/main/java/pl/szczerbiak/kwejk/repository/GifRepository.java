package pl.szczerbiak.kwejk.repository;

import pl.szczerbiak.kwejk.model.Gif;
import pl.szczerbiak.kwejk.storage.StorageProperties;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GifRepository {

    private static final String DEFAULT_USER = "Pawel"; // TODO: add login possibility
    private static final List<Gif> ALL_GIFS = new ArrayList<>();
    private static List<Gif> ALL_GIFS_UPLOADED;

    static {
        // "Default" gifs
        ALL_GIFS.add(new Gif("android-explosion", DEFAULT_USER, true));
        ALL_GIFS.add(new Gif("ben-and-mike", DEFAULT_USER, true));
        ALL_GIFS.add(new Gif("book-dominos", DEFAULT_USER, false));
        ALL_GIFS.add(new Gif("compiler-bot", DEFAULT_USER, false));
        ALL_GIFS.add(new Gif("cowboy-coder", DEFAULT_USER, true));
        ALL_GIFS.add(new Gif("infinite-andrew", DEFAULT_USER, false));
    }

    public static List<Gif> findAll() {
        return ALL_GIFS;
    }

    public static List<Gif> findAllUploaded() {
        updateUploadedGifs();
        return ALL_GIFS_UPLOADED;
    }

    public static List<Gif> findFavorites() {
        return ALL_GIFS.stream()
                .filter(Gif::getFavorite)
                .collect(Collectors.toList());
    }

    public static Gif findByName(String name) {
        return Arrays.asList(ALL_GIFS, ALL_GIFS_UPLOADED).stream()
                .flatMap(p -> p.stream())
                .filter(p -> p.getName().contains(name))
                .findFirst()
                .orElse(ALL_GIFS.get(1)); // TODO: better choice?
    }

    private static void updateUploadedGifs(){
        ALL_GIFS_UPLOADED = new ArrayList<>();
        File f = new File(StorageProperties.getLocation());
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));

        for (String name : names) {
            ALL_GIFS_UPLOADED.add(new Gif(name.split("\\.")[0], DEFAULT_USER, false, true));
        }
    }
}