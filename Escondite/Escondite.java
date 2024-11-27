import java.util.Scanner;

class Escondite {
  public static void main(String[] args) {
    int esconditeNiño1 = 0,
        esconditeNiño2 = 0,
        esconditeNiño3 = 0;

    final int INTENTOS_MAXIMOS = 12;

    final double PROBABILIDAD_OCULTARSE = 0.1;

    int intentoActual = 1;
    boolean niñosEncontrados;
    esconditeNiño1 = (int) ((Math.random() * 6 - 1 + 1) + 1);
    esconditeNiño2 = (int) ((Math.random() * 6 - 1 + 1) + 1);
    esconditeNiño3 = (int) ((Math.random() * 6 - 1 + 1) + 1);
    do {
      int guess = new Scanner(System.in).nextInt();
      intentoActual++;
      esconditeNiño1 = guess == esconditeNiño1 && Math.random() >= PROBABILIDAD_OCULTARSE ? 0 : esconditeNiño1;
      esconditeNiño2 = guess == esconditeNiño2 && Math.random() >= PROBABILIDAD_OCULTARSE ? 0 : esconditeNiño2;
      esconditeNiño3 = guess == esconditeNiño3 && Math.random() >= PROBABILIDAD_OCULTARSE ? 0 : esconditeNiño3;
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

}

