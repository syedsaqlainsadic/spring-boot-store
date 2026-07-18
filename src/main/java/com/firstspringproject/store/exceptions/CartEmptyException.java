package com.firstspringproject.store.exceptions;

public class CartEmptyException extends RuntimeException{
    public CartEmptyException(){
        super("Cart is Empty");
    }

}
