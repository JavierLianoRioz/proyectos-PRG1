import java.util.Scanner;

class Escondite {
  public static void main(String[] args) {
    int esconditeNiño1 = 0,
        esconditeNiño2 = 0,
        esconditeNiño3 = 0;

    final int INTENTOS_MAXIMOS = 12;

    int intentoActual = 1;
    esconditeNiño1 = esconderse();
    esconditeNiño2 = esconderse();
    esconditeNiño3 = esconderse();
    do {
      int guess = preguntarUsuario();
      intentoActual++;
      esconditeNiño1 = buscarNiño(esconditeNiño1, guess);
      esconditeNiño2 = buscarNiño(esconditeNiño2, guess);
      esconditeNiño3 = buscarNiño(esconditeNiño3, guess);
      contarHistoria(esconditeNiño1, esconditeNiño2, esconditeNiño3, intentoActual, INTENTOS_MAXIMOS);
    } while (intentoActual < INTENTOS_MAXIMOS && !isNiñosEncontrados(esconditeNiño1, esconditeNiño2, esconditeNiño3));

  }

  static int esconderse() {
    final int NUMERO_ESCONDITES = 6;
    final int MINIMO = 1;
    return (int) ((Math.random() * NUMERO_ESCONDITES - MINIMO + 1) + MINIMO);
  }

  static int buscarNiño(int esconditeNiño, int guess) {
    final double PROBABILIDAD_OCULTARSE = 0.1;
    return guess == esconditeNiño && Math.random() >= PROBABILIDAD_OCULTARSE ? 0 : esconditeNiño;
  }

  static void contarHistoria(
      int esconditeNiño1,
      int esconditeNiño2,
      int esconditeNiño3,
      int intentoActual,
      int intentosMaximos) {
    if (isNiñosEncontrados(esconditeNiño1, esconditeNiño2, esconditeNiño3)) {
      System.out.println("Has encontrado a todos los niños");
    } else {
      if (esconditeNiño1 == 0)
        System.out.println("Niño 1 encontrado");
      if (esconditeNiño2 == 0)
        System.out.println("Niño 2 encontrado");
      if (esconditeNiño3 == 0)
        System.out.println("Niño 3 encontrado");
    }
    if (intentoActual >= intentosMaximos)
      System.out.println("Muchos intentos");

  }

  static boolean isNiñosEncontrados(
      int esconditeNiño1,
      int esconditeNiño2,
      int esconditeNiño3) {
    return esconditeNiño1 + esconditeNiño2 + esconditeNiño3 == 0;
  }

  static int preguntarUsuario() {
    int respuesta;
    respuesta = new Scanner(System.in).nextInt();
    if (isRespuestaIncorrecta(respuesta))
      respuesta = preguntarUsuario();
    return respuesta;
  }

  static boolean isRespuestaIncorrecta(int respuesta) {
    final int VALOR_MAXIMO = 6, VALOR_MINIMO = 1;
    return respuesta > VALOR_MAXIMO || respuesta < VALOR_MINIMO;
  }
}
