/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;

import util.Time;

import java.util.Scanner;

/**
 *
 * @author Weslley Leocádio
 */
public class Start {

    static double pesos[];
    static double valores[];
    static int qtd;
    static int capacidade;

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        System.out.print("Informe a quantidade de Itens: ");
        qtd = sc1.nextInt();
        System.out.print("\n");

        pesos = new double[qtd];
        valores = new double[qtd];

        for (int i = 0; i < qtd; i++) {
            System.out.println("Informe o valor do objeto " + (i+1) + ": ");
            valores[i]=sc1.nextDouble();

            System.out.println("Informe o peso do objeto " + (i+1) + ": ");
            pesos[i]=sc1.nextDouble();

        }

        System.out.println("Informe a capacidade de peso da mochila : ");
        capacidade=sc1.nextInt();



        Nuvem nuvemParticulas = new Nuvem(qtd);
        Time tempo = new Time();
        nuvemParticulas.executarPSO();
        System.out.println("\nTempo de execução: " +  tempo );

        Runtime rt = Runtime.getRuntime();
        System.out.println("Uso de memória  = " +(rt.totalMemory()-rt.freeMemory())/(1000*1000)+"M");

    }
}
