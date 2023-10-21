package br.com.poo.sistemabancario.viewscontroller;

import br.com.poo.sistemabancario.controladores.ControladorDeCena;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.IOException;

public class ControladorTelaVideos {

    public static final String FXML_PATH = "tela-videos.fxml";

    @FXML
    private MediaView painelVideo;
    private String videoURL = getClass().getResource("/assets/video_example.mp4").toExternalForm();

    @FXML
    public void initialize(){
        System.out.println("Inicializando vídeo");
        Media media = new Media(videoURL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        painelVideo.setMediaPlayer(mediaPlayer);
    }

    @FXML
    protected void play(){
        painelVideo.getMediaPlayer().play();
    }

    @FXML
    protected void pause(){
        painelVideo.getMediaPlayer().pause();
    }

    @FXML
    protected void stop(){
        painelVideo.getMediaPlayer().stop();
    }

    @FXML
    protected void voltar() throws IOException {
        ControladorDeCena.trocarCena(ControladorTelaPrincipalAdmin.FXML_PATH);
    }
}
