/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.designpatterns.behavioural.chainofresponsability.discount;

/**
 *
 * @author eder
 */
public class OtherTest {

    
    public static void main(String[] args) {
        
        
        Resposta resposta = new RespostaEmCsv(new RespostaEmPorcento(new RespostaEmXml(new RespostaSemFormato())));
        
        Conta conta = new Conta("John", 400);
        
        resposta.responde(new Requisicao(Formato.CSV), conta);
        
        
    }
    
}

class Conta {

    private String titular;
    private double saldo;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

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

    public Formato getFormato() {
        return formato;
    }
}

abstract class Resposta {
    
    protected Resposta outraResposta;
    
    public Resposta( Resposta outraResposta) {
        this.outraResposta = outraResposta;
    }

    abstract void responde(Requisicao req, Conta conta);
}

class RespostaEmXml extends Resposta {

    public RespostaEmXml(Resposta outraResposta) {
        super(outraResposta);
    }

    @Override
    public void responde(Requisicao req, Conta conta) {
        if (req.getFormato() == Formato.XML) {
            System.out.println("<conta><titular>" + conta.getTitular() + "</titular><saldo>" + conta.getSaldo() + "</saldo></conta>");
        } else {
            outraResposta.responde(req, conta);
        }
    }
}

class RespostaEmCsv extends Resposta {

    public RespostaEmCsv(Resposta outraResposta) {
        super(outraResposta);
    }

    @Override
    public void responde(Requisicao req, Conta conta) {
        if (req.getFormato() == Formato.CSV) {
            System.out.println(conta.getTitular() + "," + conta.getSaldo());
        } else {
            outraResposta.responde(req, conta);
        }
    }
}

class RespostaEmPorcento extends Resposta {

    public RespostaEmPorcento(Resposta outraResposta) {
        super(outraResposta);
    }

    @Override
    public void responde(Requisicao req, Conta conta) {
        if (req.getFormato() == Formato.PORCENTO) {
            System.out.println(conta.getTitular() + "%" + conta.getSaldo());
        } else {
            outraResposta.responde(req, conta);
        }
    }

}

class RespostaSemFormato extends Resposta {
    
    public RespostaSemFormato() {
        super(null);
    }

    public RespostaSemFormato(Resposta outraResposta) {
        super(outraResposta);
    }

    @Override
    public void responde(Requisicao req, Conta conta) {
         System.out.println(conta.getTitular() + " " + conta.getSaldo());
    }

}
