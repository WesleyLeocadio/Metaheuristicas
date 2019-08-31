package ag;

import java.util.Scanner;

public class Principal {
          static double peso[];
          static double valor[];
          static int limite;
          static int capacidade;


    public static void main(String[] args) {

           Scanner sc1 = new Scanner(System.in);
           System.out.println("informe a quantidade de itens: ");
           limite=sc1.nextInt();
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
        Ag.Iniciar();
    }
}
