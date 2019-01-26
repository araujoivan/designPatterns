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
public class MoreThanFiveHundreadValueDiscount implements Discount {
    
    private Discount next;

    @Override
    public double getTotal(Budget budget) {
        
        if(budget.getValue() > 500) {
            return budget.getValue() * 0.05;
        } else {
            return next.getTotal(budget);
        }        
    }

    @Override
    public void setNext(Discount discount) {
        this.next = discount;
    }
 
}
