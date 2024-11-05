// package unit04;

// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;


// public class TVGui extends Application {

//     private Channel[] channels;
//     private Channel currentChannel;
//     private ImageView imageView;
//     private Label descriptionLabel;
//     private Button volumeUpButton;
//     private Button volumeDownButton;
//     private Label volumeLabel;

//     private static final String PATH = "unit04-LyingScholar/media/";

//     @Override
//     public void start(Stage stage) throws Exception {
//         BorderPane root = new BorderPane();
//         channels = initializeChannels();
//         currentChannel = channels[0];
//         currentChannel.setVolume(5);
//         Image image = new Image(currentChannel.getImagePath());
//         ImageView view = new ImageView(image);
//         descriptionLabel = new Label(currentChannel.getDescription());
//         volumeUpButton = new Button("+");
//         volumeDownButton = new Button("-");
//         volumeLabel = new Label("Volume: 5");
        
//         changeChannel(0);
//         HBox channelButtons = createChannelButtons();

//         volumeUpButton.setOnAction(e -> increaseVolume());
//         volumeDownButton.setOnAction(e -> decreaseVolume());

//         root.getChildren().addAll(
//             new Label("TV Set"),
//             view,
//             descriptionLabel,
//             channelButtons,
//             volumeDownButton,
//             volumeLabel,
//             volumeUpButton);

        

//         Scene scene = new Scene(root, 1500, 1000);
//         stage.setScene(scene);
//         stage.setTitle("TV Interface");
//         stage.show();
//     }

//     private HBox createChannelButtons() {
//         HBox channelButtons = new HBox(10);
//         for (int i = 0; i < channels.length; i++) {
//             Button channelButton = new Button("Channel " + i);
//             int channelNumber = i;
//             channelButton.setOnAction(e -> changeChannel(channelNumber));
//             channelButtons.getChildren().add(channelButton);
//         }
//         return channelButtons;
//     }

//     private Channel[] initializeChannels() throws Exception {
//         Channel[] channels = new Channel[10]; 
        
//         channels[0] = new Channel("News Channel",  "TV/news.jpg", PATH + "sounds/eat.wav");
//         channels[1] = new Channel("Love me not Channel",  "TV/LoveMeNot.jpg", PATH + "TV/LoveMeNot_audio.wav");
//         channels[2] = new Channel("Movie Channel",  "TV/movie.jpg", PATH + "TV/movie_audio.wav");
//         channels[3] = new Channel("Finance Channel",  "TV/finance.jpg", PATH + "TV/finance_audio.wav");
//         channels[4] = new Channel("Gaming Channel",  "TV/gaming.jpg", PATH + "TV/gaming_audio.wav");
//         channels[5] = new Channel("Whopper Channel",  "TV/whopper.jpg", PATH + "TV/whopper_audio.wav");
//         channels[6] = new Channel("Cartoon Channel",  "TV/cartoon.jpg", PATH + "TV/cartoon_audio.wav");
//         channels[7] = new Channel("Peace Channel",  "TV/peace.jpg", PATH + "TV/whistle_audio.wav");
//         channels[8] = new Channel("Death Channel",  "TV/death.jpg", PATH + "TV/death_audio.wav");
//         channels[9] = new Channel("Life Channel",  "TV/life.jpg", PATH + "TV/life_audio.wav");

//         return channels;
//     }

//     private void increaseVolume() {
//         double newVolume = currentChannel.getVolume() + 0.5;
//         if (newVolume <= 10.0) {
//             currentChannel.setVolume(newVolume);
//             updateVolumeLabel(newVolume);
//         }
//     }

//     private void decreaseVolume() {
//         double newVolume = currentChannel.getVolume() - 0.5;
//         if (newVolume >= 0.0) {
//             currentChannel.setVolume(newVolume);
//             updateVolumeLabel(newVolume);
//         }
//     }

//     private void changeChannel(int channelNumber) {
//         if (currentChannel != null) {
//             currentChannel.stopMediaPlayer();
//         }
//         currentChannel = channels[channelNumber];
//         Image image = new Image(PATH + currentChannel.getImagePath());
//         imageView.setImage(image);
//         descriptionLabel.setText(currentChannel.getDescription());
//         currentChannel.startMediaPlayer();
//     }

//     private void updateVolumeLabel(double volume) {
//         volumeLabel.setText("Volume: " + Math.round(volume));
//     }

//     public static void main(String[] args){
//         launch(args);
//     }
// }



package unit04;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TVGui extends Application {

    private static final String PATH = "unit04-LyingScholar/media/";

    private Channel[] channels;
    private Channel currentChannel;
    private ImageView imageView;
    private Label descriptionLabel;
    private Button volumeUpButton; 
    private Button volumeDownButton;
    private Label volumeLabel;

    @Override
    public void start(Stage stage) throws Exception{

        BorderPane root = new BorderPane();
        imageView = new ImageView();
        descriptionLabel = new Label();
        volumeUpButton = new Button("+");
        volumeDownButton = new Button("-");
        volumeLabel = new Label("Volume: 5");
        channels = initializeChannels();
        currentChannel = channels[0];
        currentChannel.setVolume(5);

        HBox channelButtons = createChannelButtons();

        volumeUpButton.setOnAction(e -> increaseVolume());
        volumeDownButton.setOnAction(e -> decreaseVolume());

        root.setTop(new HBox(new Text("TV Set"))); 
        root.setCenter(new VBox(imageView, descriptionLabel));
        root.setBottom(new HBox(channelButtons, volumeDownButton, volumeLabel, volumeUpButton));


        Scene scene = new Scene(root, 1500, 1000);
        stage.setScene(scene);
        stage.show();
    }


    private HBox createChannelButtons() throws Exception {
        HBox channelButtons = new HBox(10);
        channels = initializeChannels();
        for (int i = 0; i < 10; i++) {
            Button channelButton = new Button("Channel " + i);
            int channelNumber = i;
            channelButton.setOnAction(e -> changeChannel(channelNumber));
            channelButtons.getChildren().add(channelButton);
        }
        return channelButtons;
    }


    private Channel[] initializeChannels() throws Exception {
        Channel[] channels = new Channel[10]; 
        channels[0] = new Channel("News Channel",  "TV/news.jpg", PATH + "TV/news_audio.wav");
        channels[1] = new Channel("Love me not Channel",  "TV/LoveMeNot.jpg", PATH + "TV/LoveMeNot_audio.wav");
        channels[2] = new Channel("Movie Channel",  "TV/movie.jpg", PATH + "TV/movie_audio.wav");
        channels[3] = new Channel("Finance Channel",  "TV/finance.jpg", PATH + "TV/finance_audio.wav");
        channels[4] = new Channel("Gaming Channel",  "TV/gaming.jpg", PATH + "TV/gaming_audio.wav");
        channels[5] = new Channel("Whopper Channel",  "TV/whopper.jpg", PATH + "TV/whopper_audio.wav");
        channels[6] = new Channel("Cartoon Channel",  "TV/cartoon.jpg", PATH + "TV/cartoon_audio.wav");
        channels[7] = new Channel("Peace Channel",  "TV/peace.jpg", PATH + "TV/whistle_audio.wav");
        channels[8] = new Channel("Death Channel",  "TV/death.jpg", PATH + "TV/death_audio.wav");
        channels[9] = new Channel("Life Channel",  "TV/life.jpg", PATH + "TV/life_audio.wav");
        // channels[0] = new Channel("News Channel", "news.jpg", PATH + "news_audio.mp3");
        // channels[1] = new Channel("Love me not Channel", "LoveMeNot.png",  PATH + "LoveMeNot_audio.m4a");
        // channels[2] = new Channel("Movie Channel", "movie.jpg",  PATH + "movie_audio.mp3");
        // channels[3] = new Channel("Finance Channel", "finance.jpg",  PATH + "finance_audio.mp3");
        // channels[4] = new Channel("Gaming Channel", "gaming.avif",  PATH + "gaming_audio.mp3");
        // channels[5] = new Channel("Whopper Channel", "whopper.jpg",  PATH + "whopper_audio.mp3");
        // channels[6] = new Channel("Cartoon Channel", "cartoon.jpg",  PATH + "cartoon_audio.mp3");
        // channels[7] = new Channel("Peace Channel", "peace.jpg",  PATH + "whistle_audio.mp3");
        // channels[8] = new Channel("Death Channel", "death.webp",  PATH + "death_audio.mp3");
        // channels[9] = new Channel("Life Channel", "life.jpg",  PATH + "life_audio.mp3");

        return channels;
    }

    private void increaseVolume() {
        double newVolume = currentChannel.getVolume() + 0.5;
        if (newVolume <= 10.0) {
            currentChannel.setVolume(newVolume); 
            updateVolumeLabel(newVolume);
        }
    }

    private void decreaseVolume() {
        double newVolume = currentChannel.getVolume() - 0.5;
        if (newVolume >= 0.0) {
            currentChannel.setVolume(newVolume);
            updateVolumeLabel(newVolume);
        }
    }
    private void changeChannel(int channelNumber) {
        currentChannel = channels[channelNumber];
        Image image = new Image( currentChannel.getImagePath());
        imageView.setImage(image);
        descriptionLabel.setText( currentChannel.getDescription());
        currentChannel.startMediaPlayer();

    }
    private void updateVolumeLabel(double volume) {
        volumeLabel.setText("Volume: " + (Math.floor(10*volume))/10);
    }

    public static void main(String[] args) {
        launch(args);
    }
}