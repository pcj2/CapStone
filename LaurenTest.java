/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.test.app;

//STEP 1. Import required packages

/**
 *
 * @author Lauren
 */

public class LaurenTest{
    public static void main(String[] args) {
        Populator testPop = new Populator();
        testPop.start();
        System.out.println("Row one stuff");
        System.out.println("Version name: " + testPop.arrayList.get(0).getVersionName());
    }
    
}
