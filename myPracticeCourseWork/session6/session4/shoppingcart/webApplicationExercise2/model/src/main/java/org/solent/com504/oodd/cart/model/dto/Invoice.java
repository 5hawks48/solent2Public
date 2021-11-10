/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.solent.com504.oodd.cart.model.dto;

import org.solent.com504.oodd.cart.model.dto.ShoppingItem;
import org.solent.com504.oodd.cart.model.service.ShoppingCart;

/**
 *
 * @author Steven
 */
public class Invoice {
    private ShoppingCart shoppingCart;
    
    public void setCart(ShoppingCart cart) {
        this.shoppingCart = cart;
    }
    
    public String invoiceMessage(){
        String total = Double.toString(this.shoppingCart.getTotal());
        
        return ("Total: " + total);
    }
}
