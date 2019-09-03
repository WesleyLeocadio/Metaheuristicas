/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;

import java.util.ArrayList;

/**
 *
 * @author Weslley Leocádio
 */
public class Start {

    public static double pesos[];
    public static double valores[];
    public static int qtd;
    public static int capacidade;

    public static void main(String[] args) {

        /*
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



        Nuvem nuvemParticulas = new Nuvem(100);
        Time tempo = new Time();
        nuvemParticulas.executarPSO();

        System.out.println(nuvemParticulas.getMelhorSolucaoNuvem());

        System.out.println("\nTempo de execução: " +  tempo );

        Runtime rt = Runtime.getRuntime();
        System.out.println("Uso de memória  = " +(rt.totalMemory()-rt.freeMemory())/(1000*1000)+"M");
        */
    }

    public static ArrayList<String> retornarV(){
        ArrayList<String> resultados = new ArrayList<String>();
        for(int i = 0; i < valores.length; i++){
            resultados.add(String.valueOf(valores[i]));
        }
        //System.out.println(resultados);
        return resultados;
    }

    public static ArrayList<String> retornarP(){
        ArrayList<String> resultados = new ArrayList<String>();
        for(int i = 0; i < pesos.length; i++){
            resultados.add(String.valueOf(pesos[i]));
        }
        //System.out.println(resultados);
        return resultados;
    }

}
