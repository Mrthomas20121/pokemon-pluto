package mrthomas20121.pokemon_pluto.api.helper;

/**
 * GameLocation.java
 * @author mrthomas20121
 * This is an implementation from scratch of Minecraft Resource Location.
 * It is used to point to a file. example pokemon_pluto:assets
 * Here how it works : the name is the folder it looks at inside the resource folder under assets/name and the path is the path to a file/folder within that folder.
 */
public class GameLocation {

    private final String name;
    private final String path;

    public GameLocation(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public GameLocation(String location) {
        String[] arr = location.split(":");
        this.name = arr[0];
        this.path = arr[1];
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", this.name, this.path);
    }
}
