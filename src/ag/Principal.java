package ag;

import pso.Nuvem;
import util.Time;

import java.util.Scanner;

public class Principal {
          static double peso[];
          static double valor[];
          static int limite;
          static int capacidade;


    public static void main(String[] args) {

           Scanner sc1 = new Scanner(System.in);
           System.out.print("Informe a quantidade de Itens: ");
           limite = sc1.nextInt();
           System.out.print("\n");

           peso = new double[limite];
           valor = new double[limite];

         for (int i = 0; i < limite; i++) {
             System.out.println("Informe o valor do objeto " + (i+1) + ": ");
             valor[i]=sc1.nextDouble();
            System.out.println("Informe o peso do objeto " + (i+1) + ": ");
             peso[i]=sc1.nextDouble();
        }

         System.out.println("Informe a capacidade de peso da mochila : ");
         capacidade=sc1.nextInt();


        Genetico Ag = new Genetico();
        Time tempo = new Time();
        Ag.Iniciar();
        System.out.println("\nTempo de execução: " +  tempo );
        Runtime rt = Runtime.getRuntime();
        System.out.println("Uso de memória  = " +(rt.totalMemory()-rt.freeMemory())/(1000*1000)+"M");

    }
}
