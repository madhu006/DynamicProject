package com.breakneck.controller;





import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.breakneck.bean.Billing;
import com.breakneck.bean.Item;
import com.breakneck.bean.Shipping;
import com.breakneck.bean.ShoppingCart;
import com.breakneck.bean.ShoppingCartException;
@Controller
@SessionAttributes("ShoppingCart")
public class AddToShoppingCartController 
{
	   ModelAndView model = new ModelAndView();
	      ShoppingCart  shoppingCart = null;
	      
		
	
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
	    public ModelAndView checkOutServicePost( @RequestParam String name,  @RequestParam String address1,
	    		 @RequestParam String address2,  @RequestParam String city, @RequestParam String state,  @RequestParam String postalCode,  @RequestParam String country,  @RequestParam String email,
	    		 @RequestParam String nameOnCard,  @RequestParam String creditCardType, @RequestParam String creditCardNumber,  @RequestParam String creditCardExpiration)
	    {

	// First get the shipping values from the request.
	        Shipping shipping = new Shipping();

	        shipping.setName(name);
	        shipping.setAddress1(address1);
	        shipping.setAddress2(address2);
	        shipping.setCity(city);
	        shipping.setState(state);
	        shipping.setPostalCode(postalCode);
	        shipping.setCountry(country);
	        shipping.setEmail(email);

	// Next, get the billing values.
	        Billing billing = new Billing();

	        billing.setNameOnCard(nameOnCard);
	        billing.setCreditCardType(creditCardType);
	        billing.setCreditCardNumber(creditCardNumber);
	        billing.setCreditCardExpiration(creditCardExpiration);

	       
	        
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
	            String confirmation = shoppingCart.completeOrder(shipping, billing);

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
	 
}