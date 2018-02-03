package pl.szczerbiak.kwejk.model;

public class Category {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
