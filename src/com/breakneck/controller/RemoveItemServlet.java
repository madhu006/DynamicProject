package com.breakneck.controller;




import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RemoveItemServlet extends HttpServlet
{
    public void service(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException, ServletException
    {

// Get the index of the item to remove.
        int itemIndex = Integer.parseInt(request.getParameter("item"));

        HttpSession session = request.getSession();

// Get the cart.
        ShoppingCart cart =
            (ShoppingCart) session.getAttribute("ShoppingCart");

// If there is no shopping cart, create one.
        if (cart == null)
        {
            cart = new ShoppingCart();

            session.setAttribute("ShoppingCart", cart);
        }

        cart.removeItem(itemIndex);

// Now display the cart and allow the user to check out or order more items.
        response.sendRedirect(response.encodeRedirectURL(
            "/shoppingcart/ShowCartAfterRemove.jsp"));
    }
}