package pl.szczerbiak.kwejk.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private static String location = "upload/files";

    public static String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}