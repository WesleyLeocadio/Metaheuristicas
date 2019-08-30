package ag;

import java.util.Scanner;

public class Principal {
          static double peso[]=new double[5];
          static double valor[]=new double[5];
          static double limite;


    public static void main(String[] args) {
           Scanner sc1 = new Scanner(System.in); 
           System.out.println("informe o limete:");
           limite=sc1.nextDouble();
         for (int i = 0; i < limite; i++) {
             System.out.println("Informe o valor do objeto: ");
             valor[i]=sc1.nextDouble();
                System.out.println("Informe o peso do objeto: ");
             peso[i]=sc1.nextDouble();
        }
        Genetico Ag = new Genetico();
        Ag.Iniciar();
    }
}
