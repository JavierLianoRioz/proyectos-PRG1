
import java.util.Scanner;

public class escondite {

    public static void main(String[] args) {
        String mensaje = "";

        int posicionNiño1 = 0;
        int posicionNiño2 = 0;
        int posicionNiño3 = 0;

        final double PROBABILIDAD_DE_QUE_SE_OCULTE = 0.1;
        final int NUMERO_ESCONDITES = 6;
        boolean esconditeValido;
        posicionNiño1 = esconderse(NUMERO_ESCONDITES, posicionNiño2, posicionNiño3);
        do {
            posicionNiño2 = esconderse(NUMERO_ESCONDITES, posicionNiño1, posicionNiño3);
            esconditeValido = posicionNiño1 != posicionNiño2;
        } while (!esconditeValido);
        do {
            posicionNiño3 = esconderse(NUMERO_ESCONDITES, posicionNiño1, posicionNiño2);
            esconditeValido = posicionNiño1 != posicionNiño3 && posicionNiño2 != posicionNiño3;
        } while (!esconditeValido);

        boolean encuentraATodos;
        boolean niño1Encontrado = false;
        boolean niño2Encontrado = false;
        boolean niño3Encontrado = false;

        int intento = 0;
        int MAXIMO_DE_INTENTOS = 12;
        boolean pierdePorIntentos;
        imprimirPreJuego();
        do {
            if (sePoneAlgunoNervioso()) {
                imprimePosiciónNiño(posicionNiño1, posicionNiño2, posicionNiño3);
            }
            int buscaEn;
            buscaEn = buscar(NUMERO_ESCONDITES);
            imprimirDondeHaBuscado(buscaEn);
            intento++;
            if (buscaEn == posicionNiño1 && !niño1Encontrado) {
                if (!ocultarse(PROBABILIDAD_DE_QUE_SE_OCULTE)) {
                    niño1Encontrado = true;
                    mensaje += "Niño 1 encontrado";
                }
            }
            if (buscaEn == posicionNiño2 && !niño2Encontrado) {
                if (!ocultarse(PROBABILIDAD_DE_QUE_SE_OCULTE)) {
                    niño2Encontrado = true;
                    mensaje += "Niño 2 encontrado";
                }
            }
            if (buscaEn == posicionNiño3 || !niño3Encontrado) {
                if (!ocultarse(PROBABILIDAD_DE_QUE_SE_OCULTE)) {
                    niño3Encontrado = true;
                    mensaje += "Niño 3 encontrado";
                }
            }
            System.out.println(mensaje);
            encuentraATodos
                    = niño1Encontrado
                    && niño2Encontrado
                    && niño3Encontrado;
            pierdePorIntentos = intento >= MAXIMO_DE_INTENTOS;

            if (intento == 7) {
                if (quierenMoverse() && !niño1Encontrado) {
                    posicionNiño1 = cambiaSitio(posicionNiño1);
                }
                if (quierenMoverse() && !niño2Encontrado) {
                    posicionNiño2 = cambiaSitio(posicionNiño2);
                }
                if (quierenMoverse() && !niño3Encontrado) {
                    posicionNiño3 = cambiaSitio(posicionNiño3);
                }
            }
        } while (!encuentraATodos && !pierdePorIntentos);
        mensaje = "Ganaste";
        if (pierdePorIntentos) {
            mensaje = "Muchos intentos fallidos :c";
        }
        System.out.println(mensaje);

    }

    private static int esconderse(
            int numeroEscondites,
            int posicionNiño1,
            int posicionNiño2
    ) {
        final int NUMERO_MINIMO = 1;
        int seEscondeEn;

        seEscondeEn = (int) ((Math.random() * numeroEscondites - NUMERO_MINIMO + 1) + NUMERO_MINIMO);

        if (esconditeVacio(seEscondeEn, posicionNiño1, posicionNiño2)) seEscondeEn = esconderse(numeroEscondites, posicionNiño1, posicionNiño2);
        
        return seEscondeEn;
    }

    private static int buscar(int numeroEscondites) {
        int respuestaUsuario;
        final int VALOR_MAXIMO = numeroEscondites;
        final int VALOR_MINIMO = 1;

        do {
            respuestaUsuario = preguntarUsuario();
        } while (respuestaUsuario < VALOR_MINIMO || respuestaUsuario > VALOR_MAXIMO);

        return respuestaUsuario;
    }

    private static int preguntarUsuario() {
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.print("¿Dónde quieres buscar? ");
        return entradaUsuario.nextInt();
    }

    private static boolean ocultarse(double probabilidadDeQueSeOculte) {
        return Math.random() <= probabilidadDeQueSeOculte;
    }

    private static void imprimirPreJuego() {
        System.out.println("¡Los niños se han escondido!");
        System.out.println("1-Árbol 2-Banco 3-Arbusto 4-Columpio 5-Caseta 6-Tobogan");
    }

    private static void imprimirDondeHaBuscado(int buscaEn) {
        String mensaje = "";
        if (buscaEn == 1) {
            mensaje = "Árbol";
        } else if (buscaEn == 2) {
            mensaje = "Banco";
        } else if (buscaEn == 3) {
            mensaje = "Arbusto";
        } else if (buscaEn == 4) {
            mensaje = "Columpio";
        } else if (buscaEn == 5) {
            mensaje = "Caseta";
        } else if (buscaEn == 6) {
            mensaje = "Tobogán";
        }
        System.out.println("Has mirado en " + mensaje);
    }

    private static boolean sePoneAlgunoNervioso() {
        double PROBABILIDAD_SE_PONE_NERVIOSO = 0.05;
        return Math.random() <= PROBABILIDAD_SE_PONE_NERVIOSO;
    }

    private static void imprimePosiciónNiño(
            int posicionNiño1,
            int posicionNiño2,
            int posicionNiño3) {
        String mensaje = "";
        int niñoElegido = elegirNiño();
        if (niñoElegido == 1) {
            mensaje = "" + posicionNiño1;
        }
        if (niñoElegido == 2) {
            mensaje = "" + posicionNiño2;
        }
        if (niñoElegido == 3) {
            mensaje = "" + posicionNiño3;
        }
        System.out.println("Shh! El niño" + niñoElegido + " está en el escondite " + mensaje);
    }

    private static int elegirNiño() {
        int NIÑOS_MAXIMOS = 3;
        int NIÑOS_MINIMOS = 1;
        return (int) ((Math.random() * NIÑOS_MAXIMOS - NIÑOS_MINIMOS + 1) + NIÑOS_MINIMOS);
    }

    private static int cambiaSitio(int posicionNiño) {
        return esconderse(posicionNiño);
    }

    private static boolean quierenMoverse() {
        double probabilidadDeQueQuieranMoverse = 0.3;
        return Math.random() <= probabilidadDeQueQuieranMoverse;
    }

    private static boolean esconditeVacio(int seEscondeEn, int posicionNiño1, int posicionNiño2) {
        return (posicionNiño1 == seEscondeEn || posicionNiño2 == seEscondeEn);
    }
}
