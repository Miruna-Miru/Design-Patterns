package AdapterPattern.MediaPlayer;

public class CompatableMediaPlayer {
    public static void main(String[] args) {
        System.out.println("Testing the Media Player...");
        System.out.println("---------------------------");

        Player player = new Player();

       
        player.playMedia("song.mp3");

        System.out.println(); 

        player.playMedia("movie.mp4");

        System.out.println();
        player.playMedia("document.pdf");
    }
}


interface Media {
    void play(String filename);
}

// Mp3Player.java

class Mp3Player implements Media {
    @Override
    public void play(String filename) {
        if (filename.endsWith(".mp3")) {
            System.out.println("Playing MP3 file: " + filename);
        } else {
            System.out.println("Invalid format. Cannot play " + filename + " with Mp3Player.");
        }
    }
}


// Mp4Player.java
class Mp4Player {
    public void playMp4(String filename) {
        System.out.println("Playing MP4 file: " + filename);
    }
}


// MediaAdapter.java
class MediaAdapter implements Media {
    private Mp4Player mp4Player;

    public MediaAdapter() {
        this.mp4Player = new Mp4Player();
    }

    @Override
    public void play(String filename) {
        if (filename.endsWith(".mp4")) {
            mp4Player.playMp4(filename);
        } else {
            System.out.println("Invalid format. Cannot play " + filename + " with Mp4 adapter.");
        }
    }
}


// Player.java
class Player {
    public void playMedia(String filename) {
        Media media;

        if (filename.endsWith(".mp3")) {
            media = new Mp3Player();
            media.play(filename);
        } else if (filename.endsWith(".mp4")) {
            media = new MediaAdapter(); 
            media.play(filename);
        } else {
            System.out.println("Unsupported file format: " + filename);
        }
    }
}