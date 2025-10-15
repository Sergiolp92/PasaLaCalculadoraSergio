import java.util.Scanner;

public class Main {
    public static final int VALOR_MAXIMO = 99;

    public static final int VALOR_MINIMO = 10;
    private static int numeroObjetivo;
    private static int numeroJugador;
    private static int numeroAnterior;


    public static void main(String[] args) {
        int turnoActual = 0;



        System.out.println("------------------------------------------------------------------------");
        System.out.println("Bienvenidos al juego de <Pasa la Calculadora>, las reglas del juego son las siguientes: Un jugador establecerá el objetivo del juego," +
                "una vez establecido el objetivo, los jugadores iran introduciendo y sumando numeros del 1 al 9" +
                " de tal manera que el numero introducido esté en la misma fila y columna que el anterior y sea diferente a éste." +
                "Gana el jugador que mas se acerque al numero objetivo sin pasarse o igualarlo" +
                "Buena Suerte!!");

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Bienvenido, introduce el numero objetivo, entre el 10 y el 99");
        numeroObjetivo = pedirNumeroObjetivo();
        turnoActual = siguienteTurno(turnoActual);
        System.out.println("------------- turno" + " " + turnoActual + " " + "---------------");
        System.out.println("Comienza la partida, el objetivo del juego es el número" + " " + numeroObjetivo);
        System.out.println("Jugador nº1 introduce un número del 1 al 9");
        numeroJugador = pedirNumeroJugador();
        numeroAnterior = numeroJugador;

        System.out.println("jugador nº 2 introduce un número del 1 al 9");
        numeroJugador = pedirNumeroJugador();
        boolean valido = false;
        int total = numeroJugador + numeroAnterior;
        while (!valido){
             valido = comprobarNumeroJugador(numeroJugador , numeroAnterior);
             if(!valido){
                 System.out.println("Introduce un número en la misma fila y columna");
                 numeroJugador = pedirNumeroJugador();
             }
        }
        System.out.println("El total es" + " " + total);
        turnoActual = siguienteTurno(turnoActual);
        System.out.println("------------- turno" + " " + turnoActual + " " + "---------------");




    }

    private static int siguienteTurno(int turnoactual) {
        turnoactual++;
        return turnoactual;
    }

    private static boolean comprobarNumeroJugador(int numeroJugador, int numeroAnterior) {


        if (numeroJugador == 1) {
            if (numeroAnterior == 4 || numeroAnterior == 7 || numeroAnterior == 2 || numeroAnterior == 3){

                return true;
            }
        }
        if (numeroJugador == 2) {
            if (numeroAnterior == 1 || numeroAnterior == 3 || numeroAnterior == 5 || numeroAnterior == 8) {
                return true;
            }
        }
        if (numeroJugador == 3) {
            if (numeroAnterior == 1 || numeroAnterior == 2 || numeroAnterior == 6 || numeroAnterior == 9) {

            }
        }
        if (numeroJugador == 4) {
            if (numeroAnterior == 1 || numeroAnterior == 5 || numeroAnterior == 6 || numeroAnterior == 7) {
                return true;
            }
        }
        if (numeroJugador == 5) {
            if (numeroAnterior == 2 || numeroAnterior == 4 || numeroAnterior == 6 || numeroAnterior == 8) {
                return true;
            }
        }
        if (numeroJugador == 6) {
            if (numeroAnterior == 4 || numeroAnterior == 5 || numeroAnterior == 3 || numeroAnterior == 9) {
                return true;
            }
        }
        if (numeroJugador == 7) {
            if (numeroAnterior == 1 || numeroAnterior == 4 || numeroAnterior == 8 || numeroAnterior == 9) {
                return true;
            }
        }
        if (numeroJugador == 8) {
            if (numeroAnterior == 2 || numeroAnterior == 5 || numeroAnterior == 7 || numeroAnterior == 9) {
                return true;
            }
        }
        if (numeroJugador == 9) {
            if (numeroAnterior == 3 || numeroAnterior == 6 || numeroAnterior == 7 || numeroAnterior == 8) {
                return true;
            }

        }
        return false;

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