package com.bham.pij.assignments.calculator;

import java.util.ArrayList;

public class Calculator {
    public float result;
    public float memory;
    ArrayList<Float> history = new ArrayList<>();
    public void printHistroy(){
        System.out.println("History :" + history.size());
        for (Float his : history) {
            System.out.println(his+" ");
        }
    }
    public Calculator(){
        this.result = 0;
    }
    public float getCurrentValue(){
        return  this.result;
    }
    public float getMemory(){
        return this.memory;
    }
    public void setMemoryValue(float memval){
        this.memory = memval;
    }
    public void clearMemory(){
        this.memory = 0;
    }
    public float getHistoryValue(int index){
        return this.history.get(index);
    }
    public  float applyOp(char op, float b, float a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    public float evaluate(String expression){

        String[] tokens;
        if(expression.length()>4){
             tokens = expression.split("\\(|\\)");
        }
        else {
             tokens = expression.split("\\s");
        }
        if(tokens.length == 3){
            System.out.println("How you doing");
            return excersie1(expression);
        }
        else if(tokens.length == 2)
            return  excersie2(expression);
        else if(tokens.length == 4){
            float a = excersie1(tokens[1]);
            float b = excersie1(tokens[3]);
            return  excersie1(a+" "+tokens[2]+" "+b);
        }
        else {
            Stack values = new Stack();
            Stack operation = new Stack();
            tokens = expression.split("\\s");
            values.push(tokens[0]);

            try{
                for(int i = 1; i< tokens.length ; i+=2){
                    while (!operation.isEmpty() && hasPrecedence(tokens[i].toCharArray()[0], operation.peek().toString().toCharArray()[0]))
                        values.push(applyOp(operation.pop().toString().toCharArray()[0],
                                Float.parseFloat(values.pop().toString()),
                                Float.parseFloat(values.pop().toString())));

                    operation.push(tokens[i]);
                    values.push(tokens[i+1]);
                }
                while(!operation.isEmpty())
                values.push(applyOp(operation.pop().toString().toCharArray()[0],
                        Float.parseFloat(values.pop().toString()),
                        Float.parseFloat(values.pop().toString())));

                this.memory = Float.parseFloat(values.pop().toString());
                return  this.memory;
            }
            catch (Exception e){
                System.out.println("Invalid Input");
                return Float.MIN_VALUE;
            }
        }

    }



    public  float excersie2(String expression){
        try{
            String[] tokens = expression.split("\\s");
            if(tokens[0].equals("+")){
                this.memory += Float.parseFloat(tokens[1]);
                history.add(this.memory);
                return this.memory;
            }
            else if (tokens[0].equals("-")){
                this.memory -= Float.parseFloat(tokens[1]);
                history.add(this.memory);
                return this.memory;
            }
            else if (tokens[0].equals("*")){
                this.memory *= Float.parseFloat(tokens[1]);
                history.add(this.memory);
                return this.memory;
            }else if (tokens[0].equals("/")){
                this.memory /= Float.parseFloat(tokens[1]);
                history.add(this.memory);
                return this.memory;
            }else{
                throw  new Exception();
            }
        }
        catch (Exception e){
            return  Float.MIN_VALUE;
        }
    }
    public float excersie1(String expression){
        try {
            String[] tokens = expression.split("\\s");
            float a = Float.parseFloat(tokens[0]);
            float b = Float.parseFloat(tokens[2]);
            if(tokens[1].equals("+")){
                this.result = a + b;
                this.memory = result;
                history.add(this.memory);
                return this.memory;
            }
            else if (tokens[1].equals("-")){
                this.result = a - b;
                this.memory = result;
                history.add(this.memory);
                return this.memory;
            }
            else if (tokens[1].equals("*")){
                this.result = a * b;
                this.memory = result;
                history.add(this.memory);
                return this.memory;
            }else if (tokens[1].equals("/")){
                this.result = a / b;
                this.memory = result;
                history.add(this.memory);
                return this.memory;
            }else{
                throw  new Exception();
            }
        }
        catch (Exception e) {
            System.out.println("Invalid Input" + e);
            return Float.MAX_VALUE;
        }
    }
}
