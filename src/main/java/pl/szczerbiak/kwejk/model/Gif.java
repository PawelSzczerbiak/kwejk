package pl.szczerbiak.kwejk.model;

import pl.szczerbiak.kwejk.storage.StorageProperties;

public class Gif {
    private String name;
    private String username;
    private boolean favorite;
    private int categoryId;
    private boolean uploaded;

    public Gif(String name, String username, boolean favorite, int categoryId) {
        this.name = name;
        this.username = username;
        this.favorite = favorite;
        this.categoryId = categoryId;
    }

    public Gif(String name, String username, boolean favorite, int categoryId, boolean uploaded) {
        this(name, username, favorite, categoryId);
        this.uploaded = uploaded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean getUploaded() {
        return uploaded;
    }

    public void setUploaded(boolean uploaded) {
        this.uploaded = uploaded;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getFilePath() {
        if (getUploaded() == false) {
            return new StringBuilder("/").append("gifs/").append(getName()).toString();
        } else {
            return new StringBuilder("~/").append(StorageProperties.getLocation()).append("/").append(getName()).toString();
        }
    }
}
