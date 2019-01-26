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
public class MoreThanTwoItemsDiscount implements Discount {
    
    private Discount next;

    @Override
    public double getTotal(Budget budget) {
        
        if(budget.getItems().size() > 2) {
            return budget.getValue() * 0.02;
        } else {
            return next.getTotal(budget);
        }        
    }

    @Override
    public void setNext(Discount discount) {
        this.next = discount;
    }
 
}
