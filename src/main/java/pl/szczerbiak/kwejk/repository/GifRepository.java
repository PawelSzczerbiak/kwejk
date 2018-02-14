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
    private static final int DEFAULT_CATEGORY = 3; // default category: other
    private static final List<Gif> DEFAULT_GIFS;
    private static List<Gif> UPLOADED_GIFS;
    private static List<Gif> ALL_GIFS;

    static {
        // Default gifs initialization
        DEFAULT_GIFS = new ArrayList<>();
        DEFAULT_GIFS.add(new Gif("android-explosion.gif", DEFAULT_USER, true, 1));
        DEFAULT_GIFS.add(new Gif("ben-and-mike.gif", DEFAULT_USER, true, 2));
        DEFAULT_GIFS.add(new Gif("book-dominos.gif", DEFAULT_USER, false, 3));
        DEFAULT_GIFS.add(new Gif("compiler-bot.gif", DEFAULT_USER, false, 3));
        DEFAULT_GIFS.add(new Gif("cowboy-coder.gif", DEFAULT_USER, true, 1));
        DEFAULT_GIFS.add(new Gif("infinite-andrew.gif", DEFAULT_USER, false, 2));
        // Uploaded gifs initialization
        UPLOADED_GIFS = new ArrayList<>();
        // All gifs initially contains only default gifs
        ALL_GIFS = new ArrayList<Gif>(DEFAULT_GIFS);
    }

    public static List<Gif> findAllDefault() {
        return DEFAULT_GIFS;
    }

    public static List<Gif> findAllUploaded() {
        return UPLOADED_GIFS;
    }

    public static List<Gif> findAll() {
        return ALL_GIFS;
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

    public static List<Gif> findAllByName(String name) {
        return findAll().stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public static List<Gif> findAllByCategoryId(int categoryId) {
        return findAll().stream()
                .filter(p -> p.getCategoryId() == categoryId)
                .collect(Collectors.toList());
    }

    // TODO: more efficient updating !!!

    public static void updateUploadedGifs() {

        UPLOADED_GIFS = new ArrayList<>();
        File f = new File(StorageProperties.getLocation());
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));

        for (String name : names) {
            UPLOADED_GIFS.add(new Gif(name, DEFAULT_USER, false, DEFAULT_CATEGORY, true));
        }

        ALL_GIFS = Arrays.asList(findAllDefault(), findAllUploaded()).stream()
                .flatMap(p -> p.stream())
                .collect(Collectors.toList());
    }

}