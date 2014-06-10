package com.breakneck.bean;




public class ShoppingCartException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 194590601134999667L;

	public ShoppingCartException()
    {
    }

    public ShoppingCartException(String message)
    {
        super(message);
    }
}