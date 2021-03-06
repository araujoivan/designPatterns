/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.designpatterns.behavioural.strategy.tax;

import br.com.designpatterns.behavioural.strategy.model.Budget;

/**
 *
 * @author eder
 */
public class ICMSTax implements Tax {
    
    @Override
    public double performCalculation(Budget budget) {
        
        return budget.getValue() * 0.1;
    }
    
}
