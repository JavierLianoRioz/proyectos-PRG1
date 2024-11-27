import java.util.Scanner;

class Escondite {
  public static void main(String[] args) {
    int esconditeNiño1 = 0,
        esconditeNiño2 = 0,
        esconditeNiño3 = 0;

    final int INTENTOS_MAXIMOS = 12;

    int intentoActual = 1;
    boolean niñosEncontrados;
    esconditeNiño1 = esconderse();
    esconditeNiño2 = esconderse();
    esconditeNiño3 = esconderse();
    do {
      int guess = new Scanner(System.in).nextInt();
      intentoActual++;
      esconditeNiño1 = buscarNiño(esconditeNiño1, guess);
      esconditeNiño2 = buscarNiño(esconditeNiño2, guess);
      esconditeNiño3 = buscarNiño(esconditeNiño3, guess);
      niñosEncontrados = esconditeNiño1 + esconditeNiño2 + esconditeNiño3 == 0;
      if (esconditeNiño1 == 0)
        System.out.println("Niño 1 encontrado");
      if (esconditeNiño2 == 0)
        System.out.println("Niño 2 encontrado");
      if (esconditeNiño3 == 0)
        System.out.println("Niño 3 encontrado");
    } while (intentoActual <= INTENTOS_MAXIMOS && !niñosEncontrados);
    if (niñosEncontrados)
      System.out.println("Has encontrado a todos los niños");
    else

      System.out.println("Demasiados intentos");
  }

  static int esconderse() {
    final int NUMERO_ESCONDITES = 6;
    final int MINIMO = 1;
    return (int) ((Math.random() * NUMERO_ESCONDITES - MINIMO + 1) + MINIMO);
  }

  static int buscarNiño(int esconditeNiño, int guess) {
    final double PROBABILIDAD_OCULTARSE = 0.1;
    return guess == esconditeNiño && Math.random() >= PROBABILIDAD_OCULTARSE ? 1 : esconditeNiño;
  }
}
