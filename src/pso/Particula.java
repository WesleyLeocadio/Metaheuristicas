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
public class Particula implements Comparable<Particula>{

    private final int[] posicaoAtual;
    private double valorPosicaoAtual;

    private final int[] melhorPosicao;
    private Double valorMelhorPosicao;

    private final double[] velocidade;

    private double pesos[] = Start.pesos;
    private double valores[] = Start.valores;
    private double limitePeso = Start.capacidade;

    public Particula() {

        posicaoAtual = new int[pesos.length];
        melhorPosicao = new int[pesos.length];
        velocidade = new double[pesos.length];

        valorMelhorPosicao = new Double(0);

        do {
            this.inicializarPosicao();
        } while (!validar());
        avaliar();

        inicializarVelocidade();

    }

    //Inicia particula em posicao aleatoria
    private void inicializarPosicao() {
        for (int i = 0; i < posicaoAtual.length; i++) {
            if (Math.random() < 0.5) {
                posicaoAtual[i] = 0;
            } else {
                posicaoAtual[i] = 1;
            }
        }
    }

    public boolean validar() {
        int soma = 0;
        for (int i = 0; i < posicaoAtual.length; i++) {
            if (posicaoAtual[i] == 1) {
                soma += pesos[i];
            }
        }
        return soma <= limitePeso;
    }

    public void avaliar() {
        valorPosicaoAtual = 0.0;
        for (int i = 0; i < posicaoAtual.length; i++) {
            //.out.println("pronto");
            if (posicaoAtual[i] == 1) {
                valorPosicaoAtual += valores[i];
            }
        }
        
    }

    private void inicializarVelocidade() {
        for (int i = 0; i < velocidade.length; i++) {
            velocidade[i] = 1;
        }
    }

    //Verifica se o valor da posicao atual eh melhor que o valor da melhor solucao ja encontrada
    //Se for, substitui
    public void avaliarSolucao() {
        if (valorPosicaoAtual > valorMelhorPosicao) {
            valorMelhorPosicao = valorPosicaoAtual;
            System.arraycopy(posicaoAtual, 0, melhorPosicao, 0, posicaoAtual.length);
        }
    }

    public void atualizarVelocidade() {
        for (int i = 0; i < velocidade.length; i++) {
            velocidade[i] = 0.5 * velocidade[i]
                    + 2.05 * Math.random() * (melhorPosicao[i] - posicaoAtual[i])
                    + 2.05 * Math.random() * (Nuvem.melhorPosicaoNuvem[i] - posicaoAtual[i]);

            if (true) {
                //limita a velocidade entre [-VMAX;VMAX]
                if (velocidade[i] > 6) {
                    velocidade[i] = 6;
                } else if (velocidade[i] < -6) {
                    velocidade[i] = -6;
                }
            }
        }
    }

    public void atualizarPosicao() {
        double s;
        for (int i = 0; i < posicaoAtual.length; i++) {
            //funcao sigmoid sobre a velocidade
            s = (1 / (1 + Math.exp(-velocidade[i])));

            if (Math.random() < s) {
                posicaoAtual[i] = 1;
            } else {
                posicaoAtual[i] = 0;
            }
        }
    }

    public double getValorPosicaoAtual() {
        return valorPosicaoAtual;
    }

    public double getValorMelhorPosicao() {
        return valorMelhorPosicao;
    }

    public int[] getMelhorPosicao() {
        return melhorPosicao;
    }
    //Retorna uma lista com os atributos que deverao ser removidos
    public ArrayList<Integer> getAtributos() {
        ArrayList<Integer> atributos = new ArrayList<>();
        for (int i = 0; i < posicaoAtual.length; i++) {
            if (posicaoAtual[i] == 0) {
                atributos.add(i + 1); //[1;qtdAtributos]
            }
        }
        return atributos;
    }

   //Compara as particulas pela melhor solucao que cada uma tem
    @Override
    public int compareTo(Particula o) {
        if (valorMelhorPosicao != o.getValorMelhorPosicao()) {
            return valorMelhorPosicao.compareTo(o.getValorMelhorPosicao());
        } else {
            Integer thistam = this.getAtributos().size();
            Integer anothertam = o.getAtributos().size();
            return thistam.compareTo(anothertam);
        }
    }


  
}
