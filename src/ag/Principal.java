package ag;

import pso.Nuvem;
import util.Time;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
          public static double peso[];
          public static double valor[];
          public static int limite;
          public static int capacidade;

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

    public static double[] getPeso() {

        return peso;
    }

    public static double[] getValor()
    {
        return valor;
    }

    public static ArrayList<String> retornarValores(){
        ArrayList<String> resultados = new ArrayList<String>();
        for(int i = 0; i < valor.length; i++){
            resultados.add(String.valueOf(valor[i]));
        }
        //System.out.println(resultados);
        return resultados;
    }

    public static ArrayList<String> retornarPesos(){
        ArrayList<String> resultados = new ArrayList<String>();
        for(int i = 0; i < peso.length; i++){
            resultados.add(String.valueOf(peso[i]));
        }
        //System.out.println(resultados);
        return resultados;
    }

    public static int getCapacidade() {
        return capacidade;
    }

    public static int getLimite() {
        return limite;
    }
}
