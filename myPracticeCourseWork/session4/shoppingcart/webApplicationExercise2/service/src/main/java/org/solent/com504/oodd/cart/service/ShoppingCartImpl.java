/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.oodd.cart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.solent.com504.oodd.cart.model.service.ShoppingCart;
import org.solent.com504.oodd.cart.model.dto.ShoppingItem;

/**
 *
 * @author cgallen
 */
public class ShoppingCartImpl implements ShoppingCart {

    private HashMap<String, ShoppingItem> itemMap = new HashMap<String, ShoppingItem>();

    @Override
    public List<ShoppingItem> getShoppingCartItems() {
        List<ShoppingItem> itemlist = new ArrayList();
        for (String itemUUID : itemMap.keySet()) {
            ShoppingItem shoppingCartItem = itemMap.get(itemUUID);
            itemlist.add(shoppingCartItem);
        }
        return itemlist;
    }

    @Override
    public void addItemToCart(ShoppingItem shoppingItem) {
        boolean itemExists = false;
        for (String itemUUID : itemMap.keySet()) {
            ShoppingItem shoppingCartItem = itemMap.get(itemUUID);
            if (shoppingCartItem.getName().equals(shoppingItem.getName())){ // If item is already in cart.
                Integer q = shoppingCartItem.getQuantity();
                shoppingCartItem.setQuantity(q+1); // increment quantity by 1.
                itemExists = true;
                break;
            }
        }
        if (!itemExists){ // First item of that type.
            shoppingItem.setQuantity(1);
            itemMap.put(shoppingItem.getUuid(), shoppingItem);
        }
    }

    @Override
    public void removeItemFromCart(String itemUuid) {
        itemMap.remove(itemUuid);
    }

    
    @Override
    public double getTotal() {
        double total = 0;
        for (ShoppingItem item: itemMap.values()) {
            total += item.getQuantity() * item.getPrice();
        }
        return total;
    }
    
    
    /**
    @Override
    public double getTotal() {
        double total = 0;

        for (String itemUUID : itemMap.keySet()) {
            ShoppingItem shoppingCartItem = itemMap.get(itemUUID);
            total += shoppingCartItem.getQuantity() * shoppingCartItem.getPrice();
        }

        return total;

    }
    */
}
