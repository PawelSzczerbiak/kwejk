package pl.szczerbiak.kwejk.repository;

import pl.szczerbiak.kwejk.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = new ArrayList<>();

    static {
        ALL_CATEGORIES.add(new Category(1L, "Programming"));
        ALL_CATEGORIES.add(new Category(2L, "Fun"));
        ALL_CATEGORIES.add(new Category(2L, "Other"));
    }

    public static List<Category> findAll() {
        return ALL_CATEGORIES;
    }
}
