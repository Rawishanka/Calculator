package com.example.demo1;

import java.util.Stack;

public class Calculation {
    private double number1;
    private double number2;
    private String operator;
    private Stack<String> stack;
    public Calculation(Stack<String> stk){
        this.stack = stk;
    }
    public double returnValue(){
        this.number2 = Float.parseFloat( this.stack.pop());
        this.operator = this.stack.pop();
        this.number1 = Float.parseFloat(this.stack.pop());
        return switch (this.operator) {
            case "+" -> this.number1 + this.number2;
            case "-" -> this.number1 - this.number2;
            case "×" -> this.number1 * this.number2;
            case "÷" -> this.number1 / this.number2;
            case "%" -> this.number1 % this.number2;
            default -> 0;
        };
    }
}





