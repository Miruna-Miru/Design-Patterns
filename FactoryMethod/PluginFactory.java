// Player interface
interface Player {
    void play();
}

// Concrete Players
class Mp3Player implements Player {
    public void play() {
        System.out.println("Playing MP3 file...");
    }
}

class WavPlayer implements Player {
    public void play() {
        System.out.println("Playing WAV file...");
    }
}

class AacPlayer implements Player {
    public void play() {
        System.out.println("Playing AAC file...");
    }
}

// Factory class
class AudioPlayerFactory {
    public static Player getPlayer(String fileType) {
        switch (fileType.toLowerCase()) {
            case "mp3": return new Mp3Player();
            case "wav": return new WavPlayer();
            case "aac": return new AacPlayer();
            default: throw new IllegalArgumentException("Unsupported format: " + fileType);
        }
    }
}

// Test
public class PluginFactory {
    public static void main(String[] args) {
        Player mp3 = AudioPlayerFactory.getPlayer("mp3");
        mp3.play();

        Player wav = AudioPlayerFactory.getPlayer("wav");
        wav.play();

        Player aac = AudioPlayerFactory.getPlayer("aac");
        aac.play();
    }
}
