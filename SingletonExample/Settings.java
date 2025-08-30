package SingletonExample;

public class Settings {
    private static Settings instance;
    private String theme;

    private Settings() {
        // private constructor to prevent instantiation
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        
        return instance;
    }

    public void setTheme(String t) {
        this.theme = t;
        System.out.println("Set to theme " + t);
    }

    public String getTheme() {
        return theme;
    }
}
