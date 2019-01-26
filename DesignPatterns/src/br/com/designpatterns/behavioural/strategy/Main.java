/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.designpatterns.behavioural.strategy;

import br.com.designpatterns.behavioural.strategy.model.Budget;
import br.com.designpatterns.behavioural.strategy.tax.ICMSTax;
import br.com.designpatterns.behavioural.strategy.tax.ISSTax;
import br.com.designpatterns.behavioural.strategy.tax.Tax;

/**
 *
 * @author eder
 */
public class Main {
    
    public static void main(String[] args) {
        
        final Budget myBudget = new Budget(500.0);
        
        final Tax icms = new ICMSTax();
        final Tax iss  = new ISSTax();
        
        TaxCalculator calculator = new TaxCalculator();
        
        // passing a calculation strategy and a budget as parameter
        System.out.println(calculator.performCalculation(myBudget, icms));
        System.out.println(calculator.performCalculation(myBudget, iss));
 
        
    }
           
}
