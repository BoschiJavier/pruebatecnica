package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Carga de datos:

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese nombre del torneo");
        String nombreTorneo = teclado.nextLine();
        System.out.println("Ingrese nombre del jugador 1:");
        String nombreJugador1 = teclado.nextLine();
        System.out.println("Ingrese nombre del jugador 2:");
        String nombreJugador2 = teclado.nextLine();
        System.out.println("Ingrese cantidad de sets, 3 o 5");
        int cantidadDeSet = teclado.nextInt();
        System.out.println("Ingrese probabilidad de que gane jugador 1: " + nombreJugador1);
        int probabilidadJugador1 = teclado.nextInt();

        //Inicio de variables

        int puntosJugador1 = 0;
        int juegosJugador1 = 0;
        int setJugador1 = 0;
        int puntosJugador2 = 0;
        int juegosJugador2 = 0;
        int setJugador2 = 0;
        int tbpuntosJugador1 = 0;
        int tbpuntosJugador2 = 0;
        boolean saqueJugador1 = false;
        boolean saqueJugador2 = false;
        String revancha;
        String stringJuegosEnPartidoJug1 = nombreJugador1 + " ";
        String stringJuegosEnPartidoJug2 = nombreJugador2 + " ";

        //sumo espacios para que se vea mejor en la consola los puntos
        int diferenciaDeCaracteres = Math.abs(stringJuegosEnPartidoJug1.length() - stringJuegosEnPartidoJug2.length());
        if (stringJuegosEnPartidoJug1.length() > stringJuegosEnPartidoJug2.length()) {
            for (int i = 0; i < diferenciaDeCaracteres; i++) {
                stringJuegosEnPartidoJug2 += " ";
            }
        } else {
            for (int i = 0; i < diferenciaDeCaracteres; i++) {
                stringJuegosEnPartidoJug1 += " ";
            }
        }


        do {
            for (int i = 0; i < cantidadDeSet; i++) {

                //Recorrido de Set
                while ((juegosJugador1 < 6 && juegosJugador2 < 6) || Math.abs(juegosJugador1 - juegosJugador2) < 2) {

                    System.out.println("NUEVO GAME");

                    //Saque por game
                    if (!saqueJugador1 && !saqueJugador2) {
                        if (Math.random() < 0.5) {
                            saqueJugador1 = true;
                            System.out.println("Saca " + nombreJugador1);
                        } else {
                            saqueJugador2 = true;
                            System.out.println("Saca " + nombreJugador2);
                        }
                    } else if (saqueJugador1) {
                        saqueJugador1 = false;
                        saqueJugador2 = true;
                        System.out.println("Saca " + nombreJugador2);

                    } else {
                        saqueJugador1 = true;
                        saqueJugador2 = false;
                        System.out.println("Saca " + nombreJugador1);
                    }


                    //Recorrido game
                    while ((puntosJugador1 < 4 && puntosJugador2 < 4) || Math.abs(puntosJugador1 - puntosJugador2) < 2) {

                        if (puntosJugador1 >= 3 && puntosJugador2 >= 3) {

                            if (puntosJugador1 > puntosJugador2) {
                                System.out.println(nombreJugador1 + ": Ad ");
                                System.out.println(nombreJugador2 + ": 40 ");
                            } else if (puntosJugador1 < puntosJugador2) {
                                System.out.println(nombreJugador1 + ": 40 ");
                                System.out.println(nombreJugador2 + ": Ad ");
                            } else {
                                System.out.println(nombreJugador1 + ": 40 ");
                                System.out.println(nombreJugador2 + ": 40 ");
                            }

                        } else {
                            if (puntosJugador1 <= 2) {
                                System.out.println(nombreJugador1 + ": " + 15 * puntosJugador1);
                            } else if (puntosJugador1 == 3) {
                                System.out.println(nombreJugador1 + ": 40 ");
                            }
                            if (puntosJugador2 <= 2) {
                                System.out.println(nombreJugador2 + ": " + 15 * puntosJugador2);
                            } else if (puntosJugador2 == 3) {
                                System.out.println(nombreJugador2 + ": 40 ");

                            }
                        }
                        //Pongo al ultimo para que si ya termina el partido salga del while me diga los puntos y listo (Borrar)

                        double punto = (Math.random() * 100);

                        if (0 < punto && punto < probabilidadJugador1) {
                            puntosJugador1 += 1;
                            System.out.println("Punto para " + nombreJugador1);
                            System.out.println("---------");
                        } else {
                            puntosJugador2 += 1;
                            System.out.println("Punto para " + nombreJugador2);
                            System.out.println("---------");
                        }
                    }

                    //if para ver quien ganó el juego y sumar punto de juego
                    if (puntosJugador1 > puntosJugador2) {
                        System.out.println("Juego para " + nombreJugador1);
                        System.out.println("-------------------");
                        juegosJugador1 += 1;

                    } else {
                        System.out.println("Juego para " + nombreJugador2);
                        System.out.println("-------------------");
                        juegosJugador2 += 1;
                    }

                    //Si el juego va a tie break:

                    if (juegosJugador1 == 6 && juegosJugador2 == 6) {
                        System.out.println("Tie-break");
                        saqueJugador2 = false;
                        saqueJugador1 = false;

                        //Tie-break
                        while ((tbpuntosJugador1 < 7 && tbpuntosJugador2 < 7) || Math.abs(tbpuntosJugador1 - tbpuntosJugador2) < 2) {

                            //Saque en tie-break
                            if (!saqueJugador1 && !saqueJugador2) {
                                if (Math.random() < 0.5) {
                                    saqueJugador1 = true;
                                    System.out.println("Saca " + nombreJugador1);
                                } else {
                                    saqueJugador2 = true;
                                    System.out.println("Saca " + nombreJugador2);
                                }
                            } else {
                                if ((tbpuntosJugador1 + tbpuntosJugador2) % 2 == 0) {
                                    if (saqueJugador1) {

                                        saqueJugador1 = false;
                                        saqueJugador2 = true;
                                        System.out.println("Saca " + nombreJugador2);

                                    } else {
                                        saqueJugador1 = true;
                                        saqueJugador2 = false;
                                        System.out.println("Saca " + nombreJugador1);
                                    }
                                }
                            }
                            double puntoTieBreak = (Math.random() * 100);
                            if (0 < puntoTieBreak && puntoTieBreak < probabilidadJugador1) {
                                tbpuntosJugador1 += 1;
                                System.out.println("Punto para " + nombreJugador1);
                            } else {
                                tbpuntosJugador2 += 1;
                                System.out.println("Punto para " + nombreJugador2);
                            }
                            System.out.println("Puntos tie-break " + nombreJugador1 + ": " + tbpuntosJugador1);
                            System.out.println("Puntos tie-break " + nombreJugador2 + ": " + tbpuntosJugador2);
                            System.out.println("-------------------");
                        }

                        if (tbpuntosJugador1 > tbpuntosJugador2) {
                            System.out.println("set para " + nombreJugador1);
                            System.out.println("-------------------");
                            juegosJugador1 += 1;
                            setJugador1 += 1;

                        } else {
                            System.out.println("set para " + nombreJugador2);
                            System.out.println("-------------------");
                            juegosJugador2 += 1;
                            setJugador2 += 1;
                        }


                        break;
                    }
                    //reinicio a cero puntos para nuevo game
                    puntosJugador1 = 0;
                    puntosJugador2 = 0;

                }

                if (juegosJugador1 >= 6 && juegosJugador2 >= 6) {
                    System.out.println(nombreJugador1 + " " + juegosJugador1 + " puntos tie-break:" + tbpuntosJugador1);
                    System.out.println(nombreJugador2 + " " + juegosJugador2 + " puntos tie-break:" + tbpuntosJugador2);
                    System.out.println("-------------------");
                    stringJuegosEnPartidoJug1 += juegosJugador1 + "(" + tbpuntosJugador1 + ")" + " ";
                    stringJuegosEnPartidoJug2 += juegosJugador2 + "(" + tbpuntosJugador2 + ")" + " ";

                    //reinicio a cero puntos tie-break para nuevo game
                    tbpuntosJugador1 = 0;
                    tbpuntosJugador2 = 0;

                } else {
                    if (juegosJugador1 > juegosJugador2) {
                        System.out.println("Set para " + nombreJugador1);
                        System.out.println("-------------------");
                        setJugador1 += 1;
                    } else {
                        System.out.println("Set para " + nombreJugador2);
                        System.out.println("------------------");
                        setJugador2 += 1;
                    }
                    stringJuegosEnPartidoJug1 += juegosJugador1 + " ";
                    stringJuegosEnPartidoJug2 += juegosJugador2 + " ";
                }

                System.out.println(stringJuegosEnPartidoJug1);
                System.out.println(stringJuegosEnPartidoJug2);
                juegosJugador1 = 0;
                juegosJugador2 = 0;
                saqueJugador1 = false;
                saqueJugador2 = false;

                //Corta el juego si ya ganó uno de los jugadores
                switch (cantidadDeSet) {
                    case 3:
                        if (setJugador1 == 2 || setJugador2 == 2) {
                            i = 3;
                        }
                        break;
                    case 5:
                        if (setJugador1 == 3 || setJugador2 == 3) {
                            i = 5;
                        }
                        break;
                }
            }

            if (setJugador1 > setJugador2) {
                System.out.println("Ganador del Torneo " + nombreTorneo + ": " + nombreJugador1);
            } else {
                System.out.println("Ganador del Torneo " + nombreTorneo + ": " + nombreJugador2);
            }

            //Revancha
            String respuestaARevancha;

            do {
                System.out.println("Desea jugar una revancha? Escriba si o no");
                Scanner teclado2 = new Scanner(System.in);
                respuestaARevancha = teclado2.nextLine().toUpperCase();

            } while (!(respuestaARevancha.equals("NO") || respuestaARevancha.equals("SI")));
            revancha = respuestaARevancha;
            setJugador1 = 0;
            setJugador2 = 0;

            //Vuelvo a cero variable que guarda los puntos que imprimo
            stringJuegosEnPartidoJug1 = nombreJugador1 + " ";
            stringJuegosEnPartidoJug2 = nombreJugador2 + " ";

            //sumo espacios para que se vea mejor en la consola los puntos
            diferenciaDeCaracteres = Math.abs(stringJuegosEnPartidoJug1.length() - stringJuegosEnPartidoJug2.length());
            if (stringJuegosEnPartidoJug1.length() > stringJuegosEnPartidoJug2.length()) {
                for (int i = 0; i < diferenciaDeCaracteres; i++) {
                    stringJuegosEnPartidoJug2 += " ";
                }
            } else {
                for (int i = 0; i < diferenciaDeCaracteres; i++) {
                    stringJuegosEnPartidoJug1 += " ";
                }
            }

        } while (revancha.equals("SI"));


    }

}
