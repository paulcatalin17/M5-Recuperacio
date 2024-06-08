/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Joc del Tres en Ratlla
 *
 * @author Paul Catalin
 * @version 04.06.2024
 */
public class TicTacToe {

    /**
     * Mètode principal del joc.
     * @param args
     */
    public static void main(String[] args) {
        int[][] tauler = new int[3][3];
        imprimirTauler(tauler);
        iniciJoc(tauler);
        System.out.println("");
        System.out.println("");
        imprimirTauler(tauler);
        while(true) {
            tirJugador(tauler);
            imprimirTauler(tauler);
            tirContrincant(tauler);
            imprimirTauler(tauler);
        }

    }

    /**
     * Inicialitza el tauler a "-3" (buit).
     * @param taulerJoc
     */
    public static void iniciJoc(int[][] taulerJoc) {
        for(int i = 0; i < taulerJoc.length; i++) {
            for(int j = 0; j < taulerJoc.length; j++) {
                taulerJoc[i][j] = -3;
            }
        }
    }

    /**
     * Imprimeix el tauler del joc.
     * @param taulerJoc
     */
    public static void imprimirTauler(int[][] taulerJoc) {
        System.out.println("  1 2 3 ");
        for(int i = 0; i < taulerJoc.length; i++) {
            System.out.print("| ");
            for(int j = 0; j < taulerJoc.length; j++) {
                System.out.print(crossOrCircle(taulerJoc[i][j]) + " ");
            }
            System.out.print("| "+(i+1));
            System.out.println("");
        }
    }

    /**
     * Converteix valors del tauler a caràcters.
     * @param i
     * @return '_' per buit, 'O' per contrincant, 'X' per jugador
     */
    public static char crossOrCircle(int i){
        if(i==-3) return '_';
        return (i==0)?'O':'X';
    }

    /**
     * Converteix posició bidimensional a unidimensional.
     * @param x
     * @param y
     * @return posició unidimensional
     */
    private static int bidimensionalToUnidimensional(int x, int y){
        return (y-1)*3 + x;
    }

    /**
     * Tir del contrincant (aleatori).
     * @param taulerJoc
     */
    public static void tirContrincant(int[][] taulerJoc){
        System.out.println("");
        System.out.println("TIR CONTRINCANT");

        int random_x;
        int random_y;

        Random rand = new Random();

        do {
            random_x = rand.nextInt(3);
            random_y = rand.nextInt(3);
        } while(taulerJoc[random_x][random_y] != -3);

        taulerJoc[random_x][random_y]=0; // 0 = 'O', és a dir, la màquina
    }

    /**
     * Tir del jugador (input de l'usuari).
     * @param taulerJoc
     */
    public static void tirJugador(int[][] taulerJoc){
        System.out.println("");
        System.out.println("TIR JUGADOR");

        Scanner sc = new Scanner(System.in);
        System.out.print("[X] Entra la columna (1-3): ");
        int x = sc.nextInt();
        System.out.print("[Y] Entra la fila (1-3): ");
        int y = sc.nextInt();

        taulerJoc[y-1][x-1]=1; // 1 = 'X', és a dir, el jugador
    }

    /**
     * Determina el guanyador.
     * @param taulerJoc
     * @return "-1" ningú, "0" contrincant, "1" jugador
     */
    public static int determinarGuanyador(int[][] taulerJoc){
        // TODO: Implementar la lògica per determinar el guanyador.
        throw new UnsupportedOperationException();
    }
}
