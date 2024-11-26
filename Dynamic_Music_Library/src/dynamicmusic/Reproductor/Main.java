package dynamicmusic.Reproductor;

public class Main {
    public static void main(String[] args) {
        try {
            // Inicializa el reproductor con tres archivos de audio
            Reproductor reproductor = new Reproductor("Dynamic_Music_Library\\bin\\assets\\Cantina Band 60.wav", "Dynamic_Music_Library\\bin\\assets\\P5Victory.wav", "Dynamic_Music_Library\\bin\\assets\\Tron.wav");

            // Vertical Layering
            System.out.println("Activando capas...");
            reproductor.verticalLayering(true, false, false); // Activa track1 y track3
            Thread.sleep(5000);

            System.out.println("Deteniendo todas las pistas...");
            reproductor.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}