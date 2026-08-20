/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package mypack.sbeans;

import jakarta.ejb.Stateless;

/**
 *
 * @author minhloan
 */
@Stateless
public class SumSB implements SumSBLocal {

    @Override
    public double sum(double a, double b) {
        return a+b;
    }

}
