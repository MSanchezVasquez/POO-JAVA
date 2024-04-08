/*- Enunciado:

Nos piden hacer un programa orientado a objetos sobre un cine (solo de una sala) tiene un conjunto de 
asientos (8 filas por 9 columnas, por ejemplo).
Del cine nos interesa conocer la película que se está reproduciendo y el precio de la entrada en el cine. 
De las películas nos interesa saber el título, duración, edad mínima y director.
Del espectador, nos interesa saber su nombre, edad y el dinero que tiene.
Los asientos son etiquetados por una letra (columna) y un número (fila), la fila 1 empieza al final de la 
matriz como se muestra en la tabla. También deberemos saber si está ocupado o no el asiento.
8 A 8 B 8 C 8 D 8 E 8 F 8 G 8 H 8 I
7 A 7 B 7 C 7 D 7 E 7 F 7 G 7 H 7 I
6 A 6 B 6 C 6 D 6 E 6 F 6 G 6 H 6 I
5 A 5 B 5 C 5 D 5 E 5 F 5 G 5 H 5 I
4 A 4 B 4 C 4 D 4 E 4 F 4 G 4 H 4 I
3 A 3 B 3 C 3 D 3 E 3 F 3 G 3 H 3 I
2 A 2 B 2 C 2 D 2 E 2 F 2 G 2 H 2 I
1 A 1 B 1 C 1 D 1 E 1 F 1 G 1 H 1 I

Realizaremos una pequeña simulación, en el que generaremos muchos espectadores y los sentaremos 
aleatoriamente (no podemos donde ya este ocupado). 
En esta versión sentaremos a los espectadores de uno en uno.
Solo se podrá sentar si tienen el suficiente dinero, hay espacio libre y tiene edad para ver la película, 
en caso de que el asiento este ocupado le buscamos uno libre.
Los datos del espectador y la película pueden ser totalmente aleatorios.*/
package Ejercicio04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Creo la pelicula
        Pelicula pelicula = new Pelicula("Mi vida", 90, 16, "DDR");
        
        // Pido datos (esto no se mostro en el video por falta de tiempo)
        // No valida nada al respecto de tamaños (siguiente version)
        Scanner sn = new Scanner(System.in);
        
        System.out.println("Introduce el numero de filas");
        int filas=sn.nextInt();
        
        System.out.println("Intrdouce el numero de columnas");
        int columnas=sn.nextInt();
        
        System.out.println("Introduce el precio de la entrada de cine");
        double precio=sn.nextDouble();
        
        //Creo el cine, necesito la pelicula para ello
        Cine cine = new Cine(filas, columnas, precio, pelicula);

        //Numero de espectadores que seran creados
        System.out.println("Introduce el numero de espectadores a crear");
        int numEspectadores = sn.nextInt();

        //Variables y objetos usados
        Espectador e;
        int fila;
        char letra;

        System.out.println("Espectadores generados: ");
        //Termino cuando no queden espectadores o no haya mas sitio en el cine
        for (int i = 0; i < numEspectadores && cine.haySitio(); i++) {

            //Generamos un espectador
            e = new Espectador(
                    Metodos.nombres[Metodos.generaNumeroEnteroAleatorio(0, Metodos.nombres.length - 1)], //Nombre al azar
                    Metodos.generaNumeroEnteroAleatorio(10, 30), //Generamos una edad entre 10 y 30
                    Metodos.generaNumeroEnteroAleatorio(1, 10)); //Generamos el dinero entre 1 y 10 euros

            //Mostramos la informacion del espectador
            System.out.println(e);
            
            //Generamos una fila y letra
            //Si esta libre continua sino busca de nuevo
            do {

                fila = Metodos.generaNumeroEnteroAleatorio(0, cine.getFilas() - 1);
                letra = (char) Metodos.generaNumeroEnteroAleatorio('A', 'A' + (cine.getColumnas()-1));

            } while (cine.haySitioButaca(fila, letra));

            //Si el espectador cumple con las condiciones
            if (cine.sePuedeSentar(e)) {
                e.pagar(cine.getPrecio()); //El espectador paga el precio de la entrada
                cine.sentar(fila, letra, e); //El espectador se sienta
            }

        }

        System.out.println("");
        cine.mostrar(); //Mostramos la información del cine, tambien se puede usar un toString
        
        System.out.println("Fin");

    }

}