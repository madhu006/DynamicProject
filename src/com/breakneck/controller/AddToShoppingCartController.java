package com.breakneck.controller;





import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.breakneck.bean.AddressBean;
import com.breakneck.bean.CustomerBean;
import com.breakneck.bean.CustomerPaymentBean;
import com.breakneck.bean.Item;
import com.breakneck.bean.ShoppingCart;
import com.breakneck.bean.ShoppingCartException;
import com.breakneck.service.CustomerService;

@Controller
@SessionAttributes("ShoppingCart")
public class AddToShoppingCartController 
{
	   ModelAndView model = new ModelAndView();
	      ShoppingCart  shoppingCart = null;
	   
	      @Autowired
	      CustomerService customerService;
		
	
	 @RequestMapping(value = "/addToCart", method = RequestMethod.POST) 		
    public void service(int productId, String name, int quantity,int price)

    {

// First get the item values from the request.
        String productCode =String.valueOf(productId);
        String description = name;
        int itemQuantity = quantity;
        int itemPrice = price;
    //    ModelAndView modelAndView = new ModelAndView();
		
      
// Now create an item to add to the cart.
        Item item = new Item(productCode, description, itemPrice, itemQuantity);
                
        
      //  Get the cart.
        boolean cart = model.getModel().containsKey("ShoppingCart");

// If there is no shopping cart, create one.
        if (!cart)
        {
            shoppingCart = new ShoppingCart();
            model.addObject("ShoppingCart", shoppingCart);

        }

        shoppingCart.addItem(item);
    }
	 
	 @RequestMapping(value = "/Checkout", method = RequestMethod.GET)
	   public ModelAndView checkOutServiceGet() {
			 model.addObject("message",  "Body Template Spring MVC Framework!");
			
		  return model;
		
	    }
	 
	 @RequestMapping(value = "/CheckoutSave", method = RequestMethod.POST) 			   
	    public ModelAndView checkOutServicePost( @RequestParam String firstname, @RequestParam String middlename,  @RequestParam String lastname,   @RequestParam String line1,  @RequestParam String line2,  @RequestParam String line3, 
	    		   @RequestParam String city, @RequestParam String state,  @RequestParam String postalCode,  @RequestParam String country,  @RequestParam String email, @RequestParam String phone,  @RequestParam String landmark, 
	    		 @RequestParam String nameOnCard,  @RequestParam String creditCardType, @RequestParam String creditCardNumber,  @RequestParam String datefrom, @RequestParam String dateto)
	    {
		 
		 CustomerBean customer = new CustomerBean();
		 
		 customer.setFirstName(firstname);
		 customer.setMiddleName(middlename);
		 customer.setLastName(lastname);
		 customer.setEmail(email);
		 customer.setPhone(phone);
		 // TODO populate othercustomerdetails with right value
		 customer.setOtherCustomerDetails(landmark);
		 
		 AddressBean address = new AddressBean();
		 address.setLineOne(line1);
		 address.setLineTwo(line2);
		 address.setLineThree(line3);
		 address.setCity(city);
		 address.setState(state);
		 address.setCountry(country);
		 address.setZip(postalCode);
		 address.setOtherAddressDetails(landmark);
		 
		 CustomerPaymentBean payment = new CustomerPaymentBean();
		 payment.setNameOnCard(nameOnCard);
		 payment.setCardType(creditCardType);
		 payment.setCardNumber(creditCardNumber);
		 payment.setDateFrom(datefrom);
		 payment.setDateTo(dateto);

		 // TODO populate othercustomerdetails with right value
		 payment.setOtherDetails(landmark);
		
	// First get the shipping values from the request.
		 /*
	        Shipping shipping = new Shipping();

	        shipping.setName(name);
	        shipping.setAddress1(address1);
	        shipping.setAddress2(address2);
	        shipping.setCity(city);
	        shipping.setState(state);
	        shipping.setPostalCode(postalCode);
	        shipping.setCountry(country);
	        shipping.setEmail(email);
	        */
/*
	// Next, get the billing values.
	        Billing billing = new Billing();

	        billing.setNameOnCard(nameOnCard);
	        billing.setCreditCardType(creditCardType);
	        billing.setCreditCardNumber(creditCardNumber);
	        billing.setCreditCardExpiration(creditCardExpiration);

	       */
	        
	        //  Get the cart.
	        boolean cart = model.getModel().containsKey("ShoppingCart");

	// If there is no shopping cart, create one.
	        if (!cart)
	        {
	            shoppingCart = new ShoppingCart();
	            model.addObject("ShoppingCart", shoppingCart);

	        }


	
	        try
	        {
	            String confirmation = shoppingCart.completeOrder(customer,address, payment);

	         // Now display the cart and allow the user to check out or order more items.
	       	           
	            return new ModelAndView("redirect:/ShowConfirmation.html");

	       
	        }
	        catch (ShoppingCartException exc)
	        {
	        	/*
	            PrintWriter out = result.getWriter();

	            out.println("<html><body><h1>Error</h1>");
	            out.println("The following error occurred while "+
	                "processing your order:");
	            out.println("<pre>");
	            out.println(exc.getMessage());
	            out.println("</pre>");
	            out.println("</body></html>");
	            return;
	            */
	        }
			return model;
	        
	    } 
	 @RequestMapping(value = "/ShowConfirmation", method = RequestMethod.GET)
	   public ModelAndView confirmationPage() {
		  Map<String, Object> model = new HashMap<String ,Object>();			
		 return new ModelAndView("ShowConfirmation", model);
		 	
		
	    }
	 @RequestMapping(value = "/removeItem", method = RequestMethod.GET) 		  
	  public ModelAndView removeItemFromCart(@RequestParam("item") String item) {

		// Get the index of the item to remove.
	        int itemIndex = Integer.parseInt(item);

		   //  Get the cart.
	        boolean cart = model.getModel().containsKey("ShoppingCart");

	// If there is no shopping cart, create one.
	        if (!cart)
	        {
	            shoppingCart = new com.breakneck.bean.ShoppingCart();
	            model.addObject("ShoppingCart", shoppingCart);

	        }	    

	        shoppingCart.removeItem(itemIndex);
	        return new ModelAndView("redirect:/Checkout.html");

	        
	          }
	 

}