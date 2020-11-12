package com.bham.pij.assignments.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] arzgs) throws Exception {
        String input;
        Scanner sacnner = new Scanner(System.in);
        Calculator cal = new Calculator();
        while (true){
            System.out.println("Enter expression(type quite):");
            input = sacnner.nextLine();
            if(input.equals("mr")){
                System.out.println("Memory: " + cal.getMemory());
            }
            else if(input.equals("c")){
                cal.clearMemory();
                System.out.println("Updated Memory: " + cal.getMemory());
            }
            else if(input.equals("h")){
                cal.printHistroy();
            }
            else if(input.equals("quit")){
                break;
            }
            else{
                System.out.println(cal.evaluate(input));
            }
        }
    }
}
