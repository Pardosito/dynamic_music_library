package dynamicmusic.Reproductor;

import java.util.Scanner;

public class Control {
    private final Reproductor reproductor = new Reproductor();

    public Control(Reproductor reproductor) {
        this.reproductor = reproductor;
    }

    public void iniciarControl() {
        Scanner scanner = new Scanner(System.in);
        String response = "";

        while (!response.equals("Q")) {
            System.out.println("Opciones:");
            System.out.println("P = Play, S = Stop, R = Reset, L = Loop, Q = Quit");
            System.out.print("Elige una opción: ");
            response = scanner.next().toUpperCase();

            switch (response) {
                case "P":
                    reproductor.play();
                    break;
                case "S":
                    reproductor.stop();
                    break;
                case "R":
                    reproductor.reset();
                    break;
                case "L":
                    reproductor.loop();
                    System.out.println("Bucle activado. Usa 'S' para detener.");
                    break;
                case "Q":
                    reproductor.close();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        System.out.println("Saliendo del programa...");
        scanner.close();
    }
}