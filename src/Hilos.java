
import java.applet.AudioClip;
        
public class Hilos extends Thread {
    
    @Override
    public void run(){
        
        AudioClip sonido;
        sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Imagenes/Cancion.wav"));
        sonido.play();
        
    }
    
}
