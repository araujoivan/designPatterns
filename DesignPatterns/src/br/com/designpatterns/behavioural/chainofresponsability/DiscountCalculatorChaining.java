/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.designpatterns.behavioural.chainofresponsability;

import br.com.designpatterns.behavioural.chainofresponsability.discount.Discount;
import br.com.designpatterns.behavioural.chainofresponsability.discount.MoreThanFiveHundreadValueDiscount;
import br.com.designpatterns.behavioural.chainofresponsability.discount.MoreThanTwoItemsDiscount;
import br.com.designpatterns.behavioural.chainofresponsability.discount.NoDiscount;
import br.com.designpatterns.behavioural.chainofresponsability.model.Budget;

/**
 *
 * @author eder
 */
public class DiscountCalculatorChaining {
    
    public double calculate(Budget budget) {
        
      final Discount forMoreThanTwoItems = new MoreThanTwoItemsDiscount();
      final Discount forMoreThanFiveHundreadValue = new MoreThanFiveHundreadValueDiscount();
      
      forMoreThanTwoItems.setNext(forMoreThanFiveHundreadValue);
      forMoreThanFiveHundreadValue.setNext(new NoDiscount());
      
      return forMoreThanTwoItems.getTotal(budget);
      
    }
    
}
