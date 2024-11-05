package unit04;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Channel {
    private String description;
    private String imagePath;
    private MediaPlayer mediaPlayer;
    @SuppressWarnings("unused")
    private double volume;

    public Channel(String description, String imagePath, String audioPath) throws Exception {
        this.description = description;
        this.imagePath = imagePath;
        Media media = new Media(new File(audioPath).toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);
        this.volume = 5;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void startMediaPlayer() {
        mediaPlayer.stop();
        mediaPlayer.play();
    }

    public void stopMediaPlayer() {
        if (mediaPlayer.isAutoPlay()) {
            mediaPlayer.stop();
        }
    }

    public double getVolume() {
        return mediaPlayer.getVolume();
    }

    public void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }

    public void incrementVolume() {
        double newVolume = mediaPlayer.getVolume() + 0.1;
        if (newVolume <= 1.0) {
            mediaPlayer.setVolume(newVolume);
        }
    }



    public void decrementVolume() {
        double newVolume = mediaPlayer.getVolume() - 0.1;
        if (newVolume >= 0.0) {
            mediaPlayer.setVolume(newVolume);
        }
    }
}