/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.designpatterns.behavioural.chainofresponsability.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author eder
 */
public class Budget {
    
    private List<Item> items = new ArrayList();

    public double getValue() {
        return items.stream().mapToDouble(item -> item.getValue()).sum();
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
