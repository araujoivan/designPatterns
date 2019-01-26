/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.designpatterns.behavioural.chainofresponsability;

import br.com.designpatterns.behavioural.chainofresponsability.model.Budget;
import br.com.designpatterns.behavioural.chainofresponsability.model.Item;

/**
 *
 * @author eder
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        final Item tv        = new Item("TV", 500);
        final Item videoGame = new Item("Video Game", 100);
        
        final Budget budget = new Budget();
        
        budget.addItem(tv);
        budget.addItem(videoGame);
        
        System.out.println(new DiscountCalculatorChaining().calculate(budget));

    }
    
}
