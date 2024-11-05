package unit04;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer implements EventHandler<ActionEvent>{
    private final MediaPlayer player;

    public SoundPlayer(MediaPlayer player){
        this.player = player;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println(player.getStatus());
        player.stop();
        player.play();
    }
}