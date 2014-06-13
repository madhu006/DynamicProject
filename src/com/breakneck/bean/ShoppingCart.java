package com.breakneck.bean;



import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.breakneck.bean.AddressBean;
import com.breakneck.bean.CustomerAddressBean;
import com.breakneck.bean.CustomerBean;
import com.breakneck.bean.CustomerOrderBean;
import com.breakneck.bean.CustomerPaymentBean;
import com.breakneck.bean.Item;
import com.breakneck.bean.ShoppingCartException;
import com.breakneck.service.AddressServiceImpl;
import com.breakneck.service.CustomerAddressServiceImpl;
import com.breakneck.service.CustomerOrderServiceImpl;
import com.breakneck.service.CustomerPaymentServiceImpl;
import com.breakneck.service.CustomerService;
@SessionAttributes("ShoppingCart")

@Component
@Service("shoppingCartService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class ShoppingCart implements java.io.Serializable
{
/**
	 * 
	 */
	
	 @Autowired
	  CustomerService customerService;
/*	 
	 @Autowired
	  AddressService addressService;
	 
	 @Autowired
	 CustomerPaymentService paymentService;
	 
	 @Autowired
	 CustomerAddressService customerAddressService;
	 
	 @Autowired
	 CustomerOrderService  orderService;
	 */
	 
	private static final long serialVersionUID = 1L;
	// The shopping cart items are stored in a Vector.
    @SuppressWarnings("rawtypes")
	protected Vector items;

    @SuppressWarnings("rawtypes")
	public ShoppingCart()
    {
        items = new Vector();
    }
    
    /** Returns a Vector containing the items in the cart. The Vector
     *  returned is a clone, so modifying the vector won't affect the
     *  contents of the cart.
     */
        @SuppressWarnings("rawtypes")
    	public Vector getItems()
        {
            return (Vector) items.clone();
        }
 // Warning! This order number is reset every time the server is
 // restarted. This technique of generating an order number is
 // just for demonstration.
     protected static int nextOrderNumber = 1;

 // Submit the order and return a confirmation number.
     @SuppressWarnings("rawtypes")
 	public String completeOrder(CustomerBean customer, AddressBean address, CustomerPaymentBean payment )
         throws ShoppingCartException
     {
 // You would normally insert the order into a database or send
 // it to an application server. For the sake of simplicity
 // this shopping cart just writes the order to a file.
         try
         {
             int orderNumber = 0;

 // Make sure no other threads can be generating an order number.
             synchronized (this)
             {
                 orderNumber = nextOrderNumber;
                 nextOrderNumber = nextOrderNumber + 1;
             }
             
          //   CustomerServiceImpl customerService = new CustomerServiceImpl();
             
             customerService.addCustomer(customer);
             
             AddressServiceImpl addressService = new AddressServiceImpl();
             
             addressService.addAddress(address);
             
             CustomerPaymentServiceImpl paymentService = new CustomerPaymentServiceImpl();
             payment.setCustomerId(customer.getCustomerId());
             paymentService.addPayment(payment);
             
             CustomerAddressBean customerAddress = new CustomerAddressBean();
             customerAddress.setCustomerId(customer.getCustomerId());
             customerAddress.setAddressId(address.getAddressId());
             customerAddress.setAddressTypeCode("HomeDelivery");
             Date dt = new Date();
             customerAddress.setDatefrom(dt.toString());
             customerAddress.setDateTo(dt.toString());
             CustomerAddressServiceImpl customerAddressService = new CustomerAddressServiceImpl();
             customerAddressService.addCustomerAddress(customerAddress);
             
             CustomerOrderBean customerOrder = new CustomerOrderBean();
             customerOrder.setCustomerId(customer.getCustomerId());
             customerOrder.setDateOrderPaid(dt.toString());
             customerOrder.setDateOrderPlaced(dt.toString());
             customerOrder.setPaymentMode(payment.getCustomerPaymentId());
             customerOrder.setOrderStatusCode("ACCEPTED");
             // TODO Populate with right value.
             customerOrder.setOtherOrderDetails("THANKS");
             
             //compute total cost 
             
         	Enumeration m = items.elements();
         	double totalCost =0;

         	   while (m.hasMoreElements())
                {
                    Item item = (Item) m.nextElement();
                    totalCost += item.getPrice();
                }

            
             customerOrder.setTotalCost(totalCost);
             CustomerOrderServiceImpl orderService = new CustomerOrderServiceImpl();
             orderService.addCustomerOrder(customerOrder);
             
             
         //    PrintWriter out = new PrintWriter(
         //        new FileOutputStream("order"+orderNumber));

 // Print the shipping info.
       //      out.println(shipping.name);
       //      out.println(shipping.address1);
      /*       if (shipping.address2 != null)
             {
                 out.println(shipping.address2);
             }
             out.print(shipping.city);
             if (shipping.state != null)
             {
                 out.print(", "+shipping.state);
             }
             if (shipping.postalCode != null)
             {
                 out.print(" "+shipping.postalCode);
             }
             out.println(" "+shipping.country);
             out.println(shipping.email);

 // Print the billing info.
             out.println(billing.nameOnCard);
             out.println(billing.creditCardType);
             out.println(billing.creditCardNumber);
             out.println(billing.creditCardExpiration);
 		*/
 // Print out the items.
             @SuppressWarnings("rawtypes")
 			Enumeration e = items.elements();
             while (e.hasMoreElements())
             {
                 Item item = (Item) e.nextElement();

            //     out.println(item.productCode+","+ item.orderQuantity);
                 
            //     out.println(item.productCode+","+
             //        item.quantity);
             }
         //    out.close();

 // Return a confirmation number (the order number as a string in this case).
             return ""+orderNumber;
         }
         catch (Exception exc)
         {
             throw new ShoppingCartException(
                 "Error saving order: "+exc.toString());
         }
     }
     

/*
    public void addItem(Item newItem)
    {
        items.addElement(newItem);
    }

    public void removeItem(int itemIndex)
    {
        items.removeElementAt(itemIndex);
    }
    */


    @SuppressWarnings("unchecked")
	public synchronized void addItem(Item newItem)
    {
        @SuppressWarnings("rawtypes")
		Enumeration e = items.elements();

// See if there is already an item like this in the cart.
        while (e.hasMoreElements())
        {
            Item currItem = (Item) e.nextElement();

            if (newItem.equals(currItem))
            {
// Update the order quantity on the existing item.
                currItem.orderQuantity = currItem.orderQuantity +
                    newItem.orderQuantity;
                return;
            }
        }

// Didn't find one like this one, so add this one to the cart.
        items.addElement(newItem);
    }

    public synchronized void removeItem(int itemIndex)
    {
        Item item = (Item) items.elementAt(itemIndex);

// Remove 1 instance of this item from the quantity (an instance
// is the number of items in the quantity, such as 1 car, 12 hot dogs).
        item.orderQuantity = item.orderQuantity - item.quantity;

// If the order quantity reaches 0, remove this item from the cart.
        if (item.orderQuantity <= 0)
        {
            items.removeElementAt(itemIndex);
        }
    }
    
  
}