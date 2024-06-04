package t3.logica_interfaz;

import javax.sound.sampled.*;
import java.io.File;

public interface Sonidos {
    static Clip cargarSonido(String ruta) {
        Clip clip = null;
        try {
            File archivoSonido = new File(ruta);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(archivoSonido);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (Exception e) {
            System.out.println("No se puede cargar el archivo: " + e.getMessage());
        }

        return clip;
    }

    static void reproducirSonido(Clip clip, Runnable onCompletion) {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    onCompletion.run();
                }
            });
        }
    }
}