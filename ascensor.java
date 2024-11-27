
import java.util.Scanner;

class ascensor {
    
    public static void main(String[] args) {
        final int PLANTA_INICIO_DIA = 0;
        final int PRIMERA_PLANTA = 0;
        final int TOTAL_PLANTAS = 10;



        do {
            int eleccionJugador;
            eleccionJugador = preguntarJugador(TOTAL_PLANTAS, PRIMERA_PLANTA);

            int planta = PLANTA_INICIO_DIA;
            do {
                if (eleccionJugador > planta) {
                    planta = subeAscensor(planta);
                }
                if (eleccionJugador < planta) {
                    planta = bajaAscensor(planta);
                }
                imprimirEnPantalla(planta, eleccionJugador, TOTAL_PLANTAS);
            } while (planta != eleccionJugador);
        } while (true);
    }

    private static int preguntarJugador(
            int totalPlantas,
            int primeraPlanta
    ) {
        int respuestaUsuario;
        final int VALOR_MAXIMO = totalPlantas;
        final int VALOR_MINIMO = primeraPlanta;

        do {
            Scanner entradaUsuario = new Scanner(System.in);
            System.out.print("¿Dónde quieres buscar? ");
            respuestaUsuario = entradaUsuario.nextInt();
        } while (respuestaUsuario < VALOR_MINIMO || respuestaUsuario > VALOR_MAXIMO);

        return respuestaUsuario;
    }

    private static int subeAscensor(int planta) {
        return planta++;
    }

    private static int bajaAscensor(int planta) {
        return planta--;
    }

    private static void imprimirEnPantalla(
            int planta,
            int plantaALaQueIr,
            int totalPlantas
    ) {
        imprimirAscensor(planta, plantaALaQueIr, totalPlantas);
        System.out.println("------------------------");
        System.out.println("En planta " + planta);
        String mensaje = "Detenido";
        if (planta > plantaALaQueIr) {
            mensaje = "Subiendo";
        } else if (planta < plantaALaQueIr) {
            mensaje = "Bajando";
        }
        System.out.println(mensaje);
    }

    private static void imprimirAscensor(int planta, int plantaALaQueIr, int totalPlantas) {
        final String elevador = "[ --- ]";
        final String elevadorSubiendo = "[^ 7 ^]";
        final String elevadorBajando = "[v ñ v]";
        final String canal = " |   | ";

        String mensaje;

        for (int i = 0; i < totalPlantas; i++) {
            mensaje = canal;
            if (i == planta) {
                mensaje = elevador;
                if (planta > plantaALaQueIr) {
                    mensaje = elevadorBajando;
                }
                if (planta < plantaALaQueIr) {
                    mensaje = elevadorSubiendo;
                }
            }
            System.out.println(mensaje);
        }

    }
}
