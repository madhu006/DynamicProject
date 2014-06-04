package com.breakneck.bean;


import java.lang.String;
import java.lang.Integer;
import java.lang.Float;
import java.util.Hashtable;
import java.util.Enumeration;

import org.springframework.stereotype.Controller;


public class ShoppingCart {

  @SuppressWarnings("rawtypes")
protected Hashtable<String, String[]> items = new Hashtable<String, String[]>();

  public ShoppingCart() {

  }

  public void addItem(Integer itemId,
		    String desc,
		    Integer price,
		    int quantity) {

		    String[] item = {Integer.toString(itemId), desc, Integer.toString(price),
		    Integer.toString(quantity)};

		    if (items.containsKey(itemId)) {

		      String[] tmpItem = (String[])items.get(itemId);
		      int tmpQuant = Integer.parseInt(tmpItem[3]);
		      quantity += tmpQuant;
		      tmpItem[3] = Integer.toString(quantity);
		    }
		    else {

		      items.put(Integer.toString(itemId), item);
		    }
		  }
  
  
  
  /**
   * Add a new item to the shopping cart.
   *
   * attributes
   *    itemId - the unique key associated with the item
   *    desc - a text description of the item
   *    price - the unit price for this item
   *    quantity - number of this item to insert into the
   *      shopping cart
   *      
   *     
   */
  /*
  public void addItem(String itemId,
    String desc,
    float price,
    int quantity) {

    String[] item = {itemId, desc, Float.toString(price),
    Integer.toString(quantity)};

    if (items.containsKey(itemId)) {

      String[] tmpItem = (String[])items.get(itemId);
      int tmpQuant = Integer.parseInt(tmpItem[3]);
      quantity += tmpQuant;
      tmpItem[3] = Integer.toString(quantity);
    }
    else {

      items.put(itemId, item);
    }
  }
*/
  /**
   * Remove an item from the shopping cart.
   *
   * attributes
   *    itemId - the unique key associated with the item to be
   *      removed
   */
  public void removeItem(String itemId) {

    if (items.containsKey(itemId)) {

      items.remove(itemId);
    }
  }

  /**
   * Change the quantity of a specific item in the shopping cart.
   * The item must have previously been added to perform this
   * function.
   *
   * attributes
   *    itemId - unique key for the item to be updated
   *    quantity - the new quantity to be stored in the shopping
   *      cart
   */
  public void updateQuantity(String itemId, int quantity) {

    if (items.contains(itemId)) {

      String[] tmpItem = (String[])items.get(itemId);
      tmpItem[3] = Integer.toString(quantity);
    }
  }

  /**
   * Get an Enumeration to the list of items in the shopping cart.
   */
  public Enumeration<String[]> getEnumeration() {

   return items.elements();
  }

  /**
   * Get the total cost of all of the items currently in the
   * shopping cart.
   */
  
  public float getCost() {

	  Enumeration<String[]> enumElements = items.elements();
    String[] tmpItem;
    float totalCost = 0.00f;

    while (enumElements.hasMoreElements()) {

      tmpItem = (String[])enumElements.nextElement();
      totalCost += (Integer.parseInt(tmpItem[3]) *
        Float.parseFloat(tmpItem[2]));
    }
    return totalCost;
  }

  /**
   * Get the total number of items currently in the shopping cart.
   */
  
  public int getNumOfItems() {

	  Enumeration<String[]> totalItem = items.elements();
    String[] tmpItem;
    int numOfItems = 0;
    while (totalItem.hasMoreElements()) {

      tmpItem = (String[])totalItem.nextElement();
      numOfItems += Integer.parseInt(tmpItem[3]);
    }

    return numOfItems;
  }
  
}


	