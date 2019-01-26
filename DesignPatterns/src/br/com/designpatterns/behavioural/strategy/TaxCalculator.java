/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.designpatterns.behavioural.strategy;

import br.com.designpatterns.behavioural.strategy.model.Budget;
import br.com.designpatterns.behavioural.strategy.tax.Tax;

/**
 *
 * @author eder
 */
public class TaxCalculator {
    
    public double performCalculation(Budget budget, Tax taxType) {
       
        return taxType.performCalculation(budget);
    }
    
}
