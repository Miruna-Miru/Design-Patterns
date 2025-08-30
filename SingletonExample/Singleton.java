package SingletonExample;

public class Singleton {
    public static void main(String args[]) {
        Settings settings = Settings.getInstance();
        settings.setTheme("Light");

        
        Settings another = Settings.getInstance();
        System.out.println("Current theme: " + another.getTheme());
    }
}
