package pl.szczerbiak.kwejk.repository;

import pl.szczerbiak.kwejk.model.Category;
import pl.szczerbiak.kwejk.model.Gif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = new ArrayList<>();

    static {
        ALL_CATEGORIES.add(new Category(1L, "Programming"));
        ALL_CATEGORIES.add(new Category(2L, "Fun"));
        ALL_CATEGORIES.add(new Category(3L, "Other"));
    }

    public static Category findByCategoryId(int categoryId){
        return ALL_CATEGORIES.stream()
                .filter(category -> (category.getId() == categoryId))
                .collect(Collectors.toList()).get(0);
    }

    public static List<Category> findAll() {
        return ALL_CATEGORIES;
    }
}
