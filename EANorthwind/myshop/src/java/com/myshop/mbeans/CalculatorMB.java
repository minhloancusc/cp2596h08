/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.myshop.mbeans;

import com.myshop.sbeans.CalculatorLocal;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author minhloan
 */
@Named(value = "calculatorMB")
@SessionScoped
public class CalculatorMB implements Serializable {

    @jakarta.ejb.EJB
    private CalculatorLocal calculator;
    private double pa;
    private double pb;
    private double result = 0.0;
    
    public CalculatorMB() {
    }
    
    public String sum2num(){
        result = calculator.sum(pa, pb);
        return "calculator";
    }

    public double getPa() {
        return pa;
    }

    public void setPa(double pa) {
        this.pa = pa;
    }

    public double getPb() {
        return pb;
    }

    public void setPb(double pb) {
        this.pb = pb;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    
}
