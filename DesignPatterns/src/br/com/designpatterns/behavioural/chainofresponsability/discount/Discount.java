/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.designpatterns.behavioural.chainofresponsability.discount;

import br.com.designpatterns.behavioural.chainofresponsability.model.Budget;

/**
 *
 * @author eder
 */
public interface Discount {
     
    public default double getTotal(Budget budget){ return 0; };
    
    public default void setNext(Discount discount){};
    
}
/*

interface Resposta {
      void responde(Requisicao req, Conta conta);
      void setProxima(Resposta resposta);
    }

enum Formato {
      XML,
      CSV,
      PORCENTO
    }

    class Requisicao {
      private Formato formato;
      public Requisicao(Formato formato) {
        this.formato = formato;
      }

      // getter para o Formato
    }

*/