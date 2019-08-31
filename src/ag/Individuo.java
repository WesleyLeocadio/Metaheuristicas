package ag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*representação do nosso cromossomo será uma string de bits na qual a
posição i ser igual a 1 representa o fato de que o objeto de número i será colocado
dentro da mochila.

 */
public class Individuo implements Comparable<Individuo> {

    private Double aptidao;
    //Cromossomo

    private final Random random = new Random();

     private int[] individuo;
    //nosso cromossomo precisa do  valor e o peso de cada um dos GENES a serem carregados
    private double pesos[]=Principal.peso;
    private double valores[]=Principal.valor;
    //o limite de peso que nossa mochila pode carregar
    private double limitePeso=Principal.capacidade;

    public Individuo() {
         individuo = new int[pesos.length];
        do{
            this.setIndividuo(individuo);
        } while (!validar());
        avaliar();
    }


    public Individuo(int[] novoIndividuo){

        individuo = novoIndividuo;

        if(random.nextDouble() <= Genetico.TAXADEMUTACAO){
            int posAleatoria = random.nextInt(individuo.length);
            mutacao(posAleatoria);
        }
        avaliar();

    }

    public void avaliar() {
        aptidao = 0.0;
         for (int i = 0; i < individuo.length; i++) {
           if(individuo[i]==1)
               aptidao += valores[i];
       }         
    }
    
    public void setIndividuo(int[] individuo) {
        for (int i = 0; i < pesos.length; i++){
           individuo[i] = (Math.random() > 0.5)?1:0;
        }
    }

   public boolean validar(){
       int soma=0;
       for (int i = 0; i < individuo.length; i++) {
           if(individuo[i]==1)
               soma+=pesos[i];
       }
        return  soma < limitePeso;
    }
   
   private void mutacao(int posicao) {
        do {
           individuo[posicao] = (individuo[posicao] == 1)?0:1;
        } while (!validar());

    }

    public int[] getIndividuo() {
        return individuo;
    }
    
     public double getAptidao() {
        return aptidao;
    }

   @Override
    public int compareTo(Individuo i) {
        return this.aptidao.compareTo(i.aptidao);
    }
     @Override
    public String toString() {
        return "Cromossomo " + Arrays.toString(individuo) + " Aptidao: " + aptidao + "\n";
    }


    
    
   
    

}
