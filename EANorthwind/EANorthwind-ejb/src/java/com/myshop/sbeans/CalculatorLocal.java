package com.myshop.sbeans;

import jakarta.ejb.Local;

/**
 *
 * @author minhloan
 */
@Local
public interface CalculatorLocal {

    double sum(double a, double b);
    
}
