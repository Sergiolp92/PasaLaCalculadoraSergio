import java.util.Scanner;

public class Main {
    public static final int VALOR_MAXIMO = 99;

    public static final int VALOR_MINIMO = 10;
    private static int numeroObjetivo;
    private static int numeroJugador;

    private static int contador;


    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Bienvenidos al juego de <Pasa la Calculadora>, las reglas del juego son las siguientes: Un jugador establecerá el objetivo del juego," +
                "una vez establecido el objetivo, los jugadores iran introduciendo y sumando numeros del 1 al 9" +
                " de tal manera que el numero introducido esté en la misma fila y columna que el anterior y sea diferente a éste." +
                "Gana el jugador que mas se acerque al numero objetivo sin pasarse o igualarlo" +
                "Buena Suerte!!");

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Bienvenido, introduce el numero objetivo, entre el 10 y el 99");
        numeroObjetivo = pedirNumeroObjetivo();

        System.out.println("Comienza la partida, el objetivo del juego es el número" + " " + numeroObjetivo);
        System.out.println("Jugador nº1 introduce un número del 1 al 9");
        numeroJugador = pedirNumeroJugador();
        System.out.println("jugador nº 2 introduce un número del 1 al 9");




    }

    private static int comprobarNumeroJugador(int numeroJugador, int numeroJugadorComprobado) {
        Scanner sc = new Scanner(System.in);


        if (Main.numeroJugador == 1) {
            while (Main.numeroJugador != 4 && Main.numeroJugador != 7 && Main.numeroJugador != 2 && Main.numeroJugador != 3) ;
            System.out.println("nº no válido, por favor introduce un nº en la misma fila columna, y que no sea igual al anterior");
            Main.numeroJugador = sc.nextInt();
        }
        if (Main.numeroJugador == 2) {
            while (Main.numeroJugador != 1 && Main.numeroJugador != 3 && Main.numeroJugador != 5 && Main.numeroJugador != 8) ;
            System.out.println("nº no válido, por favor introduce un nº en la misma fila columna, y que no sea igual al anterior");
            Main.numeroJugador = sc.nextInt();
        }
        if (Main.numeroJugador == 3) {
            while (Main.numeroJugador != 1 && Main.numeroJugador != 2 && Main.numeroJugador != 6 && Main.numeroJugador != 9) ;
            System.out.println("nº no válido, por favor introduce un nº en la misma fila columna, y que no sea igual al anterior");
            Main.numeroJugador = sc.nextInt();
        }
        if (Main.numeroJugador == 4) {
            while (Main.numeroJugador != 1 && Main.numeroJugador != 5 && Main.numeroJugador != 6 && Main.numeroJugador != 7) ;
            System.out.println("nº no válido, por favor introduce un nº en la misma fila columna, y que no sea igual al anterior");
            Main.numeroJugador = sc.nextInt();
        }
        if (Main.numeroJugador == 5) {
            while (Main.numeroJugador != 2 && Main.numeroJugador != 4 && Main.numeroJugador != 6 && Main.numeroJugador != 8) ;
            System.out.println("nº no válido, por favor introduce un nº en la misma fila columna, y que no sea igual al anterior");
            Main.numeroJugador = sc.nextInt();
        }
        if (Main.numeroJugador == 6) {
            while (Main.numeroJugador != 4 && Main.numeroJugador != 5 && Main.numeroJugador != 3 && Main.numeroJugador != 9) ;
            System.out.println("nº no válido, por favor introduce un nº en la misma fila columna, y que no sea igual al anterior");
            Main.numeroJugador = sc.nextInt();
        }
        if (Main.numeroJugador == 7) {
            while (Main.numeroJugador != 1 && Main.numeroJugador != 4 && Main.numeroJugador != 8 && Main.numeroJugador != 9) ;
            System.out.println("nº no válido, por favor introduce un nº en la misma fila columna, y que no sea igual al anterior");
            Main.numeroJugador = sc.nextInt();
        }
        if (Main.numeroJugador == 8) {
            while (Main.numeroJugador != 2 && Main.numeroJugador != 5 && Main.numeroJugador != 7 && Main.numeroJugador != 9) ;
            System.out.println("nº no válido, por favor introduce un nº en la misma fila columna, y que no sea igual al anterior");
            Main.numeroJugador = sc.nextInt();
        }
        if (Main.numeroJugador == 9) {
            while (Main.numeroJugador != 3 && Main.numeroJugador != 6 && Main.numeroJugador != 7 && Main.numeroJugador != 8) ;
            System.out.println("nº no válido, por favor introduce un nº en la misma fila columna, y que no sea igual al anterior");
            Main.numeroJugador = sc.nextInt();
        }
        if (Main.numeroJugador == 0) {
            System.out.println("nº no válido, por favor introduce un nº entre 1 y 9");
            Main.numeroJugador = sc.nextInt();
        }
        if (Main.numeroJugador < 0 || Main.numeroJugador >= 10) {
            System.out.println("nº no válido, por favor introduce un nº entre 1 y 9");
            Main.numeroJugador = sc.nextInt();
        }
        return numeroJugadorComprobado;

    }


    /**
     * En esta función se recoge el siguiente número entero y luego comprueba si este está entre el numero 1 y 9. De no ser así devuelve un mensaje
     *
     * @return numero valido jugador.
     */
    private static int pedirNumeroJugador() {
        Scanner sc = new Scanner(System.in);
        numeroJugador = sc.nextInt();

        while (numeroJugador < 1 || numeroJugador > 9) {
            System.out.println("escribe un numero válido entre 1 y 9");
            numeroJugador = sc.nextInt();
        }

        return numeroJugador;

    }

    /**
     * En esta función se recoge el siguiente número entero. Si es -1, genera un numero random entre 10 y 99, y mientras esté fuera de ese rango devuelve un error.
     *
     * @return Numero objetivo o numero final del juego
     */
    public static int pedirNumeroObjetivo() {
        Scanner sc = new Scanner(System.in);
        numeroObjetivo = sc.nextInt();

        if (numeroObjetivo == -1) {
            numeroObjetivo = (int) (Math.random() * (VALOR_MAXIMO - VALOR_MINIMO + 1)) + VALOR_MINIMO;

        }

        while (numeroObjetivo < VALOR_MINIMO || numeroObjetivo > VALOR_MAXIMO) {
            System.out.println("Número erroneo");
            numeroObjetivo = sc.nextInt();
        }

        return numeroObjetivo;
    }

}