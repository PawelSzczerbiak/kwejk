package pl.szczerbiak.kwejk.repository;

import pl.szczerbiak.kwejk.model.Gif;
import pl.szczerbiak.kwejk.storage.StorageProperties;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GifRepository {

    private static final String DEFAULT_USER = "Pawel"; // TODO: add login possibility
    private static final int DEFAULT_CATEGORY = 3; // category: other
    private static final List<Gif> DEFAULT_GIFS = new ArrayList<>();
    private static List<Gif> UPLOADED_GIFS = new ArrayList<>();

    static {
        // "Default" gifs
        DEFAULT_GIFS.add(new Gif("android-explosion", DEFAULT_USER, true, 1));
        DEFAULT_GIFS.add(new Gif("ben-and-mike", DEFAULT_USER, true, 2));
        DEFAULT_GIFS.add(new Gif("book-dominos", DEFAULT_USER, false, 3));
        DEFAULT_GIFS.add(new Gif("compiler-bot", DEFAULT_USER, false, 3));
        DEFAULT_GIFS.add(new Gif("cowboy-coder", DEFAULT_USER, true, 1));
        DEFAULT_GIFS.add(new Gif("infinite-andrew", DEFAULT_USER, false, 2));
    }

    public static List<Gif> findAllDefault() {
        return DEFAULT_GIFS;
    }

    public static List<Gif> findAllUploaded() {
        return UPLOADED_GIFS;
    }

    public static List<Gif> findAll() {
        GifRepository.updateUploadedGifs();
        return Arrays.asList(findAllDefault(), findAllUploaded()).stream()
                .flatMap(p -> p.stream())
                .collect(Collectors.toList());
    }

    public static List<Gif> findFavorites() {
        return findAll().stream()
                .filter(Gif::getFavorite)
                .collect(Collectors.toList());
    }

    public static Gif findByName(String name) {
        return findAll().stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst()
                .orElse(findAll().get(1)); // TODO: better choice?
    }

    public static void updateUploadedGifs() {
        UPLOADED_GIFS = new ArrayList<>();
        File f = new File(StorageProperties.getLocation());
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));

        for (String name : names) {
            UPLOADED_GIFS.add(new Gif(name.split("\\.")[0], DEFAULT_USER, false, DEFAULT_CATEGORY, true));
        }
    }

    public static List<Gif> findByCategoryId(int categoryId) {
        return findAll().stream()
                .filter(p -> p.getCategoryId() == categoryId)
                .collect(Collectors.toList());
    }
}