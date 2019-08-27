package ag;

import java.util.ArrayList;

/*representação do nosso cromossomo será uma string de bits na qual a
posição i ser igual a 1 representa o fato de que o objeto de número i será colocado
dentro da mochila.

 */
public class Individuo {
    //Cromossomo
    private ArrayList<String> aptidao = new ArrayList();
    //nosso cromossomo precisa do  valor e o peso de cada um dos GENES a serem carregados
    private double pesos[];
    private double valores[];
    //o limite de peso que nossa mochila pode carregar
    private double limitePeso;

    public Individuo() {
    }

    public Individuo(double pesos[], double valores[],
            double limitePeso) {
        this();
        this.pesos = new double[pesos.length];
        this.valores = new double[valores.length];
        
        for (int i = 0; i < pesos.length; i++) {
            this.pesos[i] = pesos[i];
            this.valores[i] = valores[i];
        }
        this.limitePeso = limitePeso;
        /* inicializar nosso cromossomo simplesmente fazendo um loop que
        se repete N vezes (onde N é o tamanho do vetor de
        valores passado como parâmetro) e em cada iteração
        escolhe um ou zero, aleatoriamente*/
        for (int i = 1; i <= pesos.length; i++) {
            if (Math.random() < 0.5) {
                aptidao.add("0");
            } else {
                aptidao.add("1");
            }
        }
    }

    public ArrayList<String> getAptidao() {
        return aptidao;
    }

     private void avaliar() {
     
    }


    
    
   
    

}
