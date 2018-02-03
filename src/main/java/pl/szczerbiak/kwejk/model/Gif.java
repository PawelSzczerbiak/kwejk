package pl.szczerbiak.kwejk.model;

public class Gif {
    private String name;
    private String username;
    private boolean favorite;

    public Gif(String name) {
        this.name = name;
    }

    public Gif(String name, String username, boolean favorite) {
        this.name = name;
        this.username = username;
        this.favorite = favorite;
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

    public String getThymeleafFilePath(){
        return new StringBuilder("").append("/gifs/").append(getName()).append(".gif").toString();
    }
}
