import java.util.Scanner;

public class Main {
    public static final int VALOR_MAXIMO = 99;

    public static final int VALOR_MINIMO = 10;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static int numeroObjetivo;
    private static int numeroJugador;
    private static int numeroAnterior;


    public static void main(String[] args) {

        boolean seguirJugando = true;

        while(seguirJugando){

            int turnoActual = 0;
            int total = 0;
            System.out.println("------------------------------------------------------------------------");
            System.out.println( "Bienvenidos al juego de <Pasa la Calculadora>, las reglas del juego son las siguientes:\n"
                    + "Un jugador establecerá el objetivo del juego,\n"
                    + "de tal manera que el número introducido esté en la misma fila y columna que el anterior y sea diferente a éste.\n\n"
                    + "Gana el jugador que más se acerque al número objetivo sin pasarse o igualarlo.\n\n"
                    + "¡Buena Suerte!"
            );

            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Bienvenido, introduce el numero objetivo, entre el 10 y el 99");
            numeroObjetivo = pedirNumeroObjetivo();
            turnoActual = siguienteTurno(turnoActual);
            System.out.println("------------- turno" + " " + turnoActual + " " + "---------------");
            System.out.println("Comienza la partida, el objetivo del juego es el número" + " " + numeroObjetivo);
            System.out.println("Jugador" + " " + turnoJugador(turnoActual) + " " + " introduce un número del 1 al 9");
            numeroJugador = pedirNumeroJugadorEnRango(MIN_RANGE, MAX_RANGE);
            total = total + numeroJugador;
            numeroAnterior = numeroJugador;

            turnoActual = siguienteTurno(turnoActual);
            System.out.println("------------- turno" + " " + turnoActual + " " + "---------------");

            while (!esGameOver(total, numeroObjetivo)) {
                System.out.println("Jugador" + " " + turnoJugador(turnoActual) + " " + " introduce un número del 1 al 9");
                numeroJugador = obtenerNValido();
                System.out.println("Número escogido:" + numeroJugador);
                total = numeroJugador + total;
                numeroAnterior = numeroJugador;

                System.out.println("El total es:" + " " + total);
                turnoActual = siguienteTurno(turnoActual);
                System.out.println("------------- turno" + " " + turnoActual + " " + "---------------");
                System.out.println("El objetivo es:" + " " + numeroObjetivo);
            }
            System.out.println("Jugador" + " " + turnoJugador(turnoActual - 1) + " " + "has perdido." );

            //acabamos la partida y le eprregeuntamos al usuario si quiere jugar otra
            System.out.println("Nueva partida? si/no");
            Scanner sc = new Scanner(System.in);
            String respuesta = sc.next();


            if (respuesta.equals("no")){
               seguirJugando = false;


            }


        }

        System.out.println("Gracias por jugar");





    }



    private static String turnoJugador(int turnoActual){

        if(turnoActual % 2 == 0){
            return "2";
        }else{
            return "1";
        }
    }



    private static boolean esGameOver(int total, int numeroObjetivo) {
        return total >=numeroObjetivo;
    }

    private static int obtenerNValido() {
        int numeroJugador = -1;
        boolean valido = false;
        while (!valido) {
            numeroJugador = pedirNumeroJugadorEnRango(MIN_RANGE, MAX_RANGE);
            valido = comprobarNumeroJugador(numeroJugador, numeroAnterior);
            if (!valido) {
                System.out.println("Introduce un número en la misma fila y columna");
            }
        }
        return numeroJugador;
    }

    private static int siguienteTurno(int turnoactual) {
        turnoactual++;
        return turnoactual;
    }

    private static boolean comprobarNumeroJugador(int numeroJugador, int numeroAnterior) {


        if (numeroJugador == 1) {
            if (numeroAnterior == 4 || numeroAnterior == 7 || numeroAnterior == 2 || numeroAnterior == 3) {

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
                return true;
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
            return numeroAnterior == 3 || numeroAnterior == 6 || numeroAnterior == 7 || numeroAnterior == 8;

        }
        return false;

    }


    /**
     * En esta función se recoge el siguiente número entero y luego comprueba si este está entre el numero 1 y 9.
     *
     * @return numeroJugador
     .
     */
    private static int pedirNumeroJugadorEnRango(int rangoInferior, int rangoSuperior) {
        Scanner sc = new Scanner(System.in);
        numeroJugador = sc.nextInt();

        while (numeroJugador < rangoInferior || numeroJugador > rangoSuperior) {
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