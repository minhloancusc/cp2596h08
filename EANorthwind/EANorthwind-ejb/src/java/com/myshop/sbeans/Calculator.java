package com.myshop.sbeans;

import jakarta.ejb.Stateless;

/**
 *
 * @author minhloan
 */
@Stateless
public class Calculator implements CalculatorLocal {

    @Override
    public double sum(double a, double b) {
        return a+b;
    }

}
