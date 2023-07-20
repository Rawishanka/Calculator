package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Stack;

public class HelloController {
    private double value;
    private Calculation answer;
    private final Stack<String> stk;
    private final ArrayList<String> operators;
    private String number;
    private Boolean visible;
    @FXML
    private VBox slideBar;
    @FXML
    private Label welcomeText;
    @FXML
    private Label showEquation;
    @FXML
    private Label mainLabel;
    @FXML
    private Circle myCircle;
    private double x ;
    private double y;
    public HelloController() {
        this.stk = new Stack<String>();
        this.visible = false;
        this.number = "";
        this.operators = new ArrayList<String>();
        this.operators.add("+");
        this.operators.add( "-");
        this.operators.add("×");
        this.operators.add("÷");
        this.operators.add("/");
        this.answer = new Calculation(stk);

    }
    @FXML
    protected void oenHelloButtonClick() {
        slideBar.setVisible(!visible);
        visible = !visible;
    }
    @FXML
    protected void lkrToUSD() {
        welcomeText.setText("Lkr To USD");
        slideBar.setVisible(!visible);
        visible = !visible;
    }
    @FXML
    protected void volume() {
        welcomeText.setText("Volume converter");
        slideBar.setVisible(!visible);
        visible = !visible;
    }
    @FXML
    protected void scientificCal() {
        welcomeText.setText("Scientific");
        slideBar.setVisible(!visible);
        visible = !visible;
    }
    @FXML
    protected void lengthConverter() {
        welcomeText.setText("Length Converter");
        slideBar.setVisible(!visible);
        visible = !visible;
    }

    @FXML
    protected void button1Pressed(){
        if(this.number.length() == 1 && this.number.equals("0")){
            this.number = "1";
        }else{
            this.number += "1";
        }
        this.mainLabel.setText(this.number);

    }
    @FXML
    protected void button2Pressed(){
        if(this.number.length() == 1 && this.number.equals("0")){
            this.number = "2";
        }else{
            this.number += "2";
        }
        this.mainLabel.setText(this.number);
    }

    @FXML
    protected void button3Pressed(){
        if(this.number.length() == 1 && this.number.equals("0")){
            this.number = "3";
        }else{
            this.number += "3";
        }
        this.mainLabel.setText(this.number);
    }

    @FXML
    protected void button4Pressed(){
        if(this.number.length() == 1 && this.number.equals("0")){
            this.number = "4";
        }else{
            this.number += "4";
        }
        this.mainLabel.setText(this.number);
    }

    @FXML
    protected void button5Pressed(){
        if(this.number.length() == 1 && this.number.equals("0")){
            this.number = "5";
        }else{
            this.number += "5";
        }
        this.mainLabel.setText(this.number);
    }

    @FXML
    protected void button6Pressed(){
        if(this.number.length() == 1 && this.number.equals("0")){
            this.number = "6";
        }else{
            this.number += "6";
        }
        this.mainLabel.setText(this.number);
    }

    @FXML
    protected void button7Pressed(){
        if(this.number.length() == 1 && this.number.equals("0")){
            this.number = "7";
        }else{
            this.number += "7";
        }
        this.mainLabel.setText(this.number);
    }

    @FXML
    protected void button8Pressed(){
        if(this.number.length() == 1 && this.number.equals("0")){
            this.number = "8";
        }else{
            this.number += "8";
        }
        this.mainLabel.setText(this.number);
    }
    @FXML
    protected void button9Pressed(){
        if(this.number.length() == 1 && this.number.equals("0")){
            this.number = "9";
        }else{
            this.number += "9";
        }
        this.mainLabel.setText(this.number);
    }

    @FXML
    protected void button0Pressed(){
        if(this.number.length() == 1 && this.number.equals("0")){
            this.number = "0";
        }else{
            this.number += "0";
        }
        this.mainLabel.setText(this.number);
    }

    @FXML
    protected void buttonPlusPressed(){
        this.evaluate("+");
    }

    @FXML
    protected void buttonMinusPressed(){
        this.evaluate("-");
    }

    @FXML
    protected void buttonEqualPressed(){
        System.out.println("button plus");
    }

    @FXML
    protected void buttonMultiplyPressed(){
        this.evaluate("×");
    }

    @FXML
    protected void buttonDividePressed(){
        this.evaluate("÷");
    }

    @FXML
    protected void buttonPlusOrMinusPressed(){
        System.out.println("button plus");
    }

    @FXML
    protected void buttonErasePressed(){
        if (this.number.length() != 0){
            this.number = this.number.replace(this.number.substring(this.number.length()-1), "");
            if (this.number.length() == 0){
                this.mainLabel.setText("0");
            }else{
                this.mainLabel.setText(this.number);
            }
        }else{
            this.number = "";
        }
    }

    @FXML
    protected void buttonResetPressed(){
        this.mainLabel.setText("0");
        this.showEquation.setText("0");
        this.stk.clear();
        this.number = "";
    }

    @FXML
    protected void buttonDecimalPressed(){
        System.out.println("button plus");
    }

    @FXML
    protected void buttonPercentagePressed(){
        System.out.println("button plus");
    }

    @FXML
    protected void eraseCurrentValue(){
        this.number = "";
        this.mainLabel.setText("0");
    }

    public void evaluate(String operator){
        if(this.stk.isEmpty() && this.number.length() == 0){
            this.stk.push("0");
            this.stk.push(operator);
            this.showEquation.setText("0 "+operator);
            this.mainLabel.setText("0");

        } else if (this.number.length() != 0 && this.stk.isEmpty()) {
            this.showEquation.setText(this.number+ " "+ operator);
            this.stk.push(this.number);
            this.stk.push(operator);
            this.number = "";
        }else if(this.number.length() == 0){
            this.stk.pop();
            String temp = this.stk.pop();
            this.stk.push(temp);
            this.stk.push(operator);
            this.showEquation.setText(temp + " "+operator);
        }else{
            this.stk.push(this.number);
            try{
                this.value = this.answer.returnValue();
                this.stk.clear();
                this.stk.push(String.valueOf(value));
                this.stk.push(operator);
                this.number = "";
                this.showEquation.setText(String.valueOf(value)+" "+operator);
                this.mainLabel.setText(String.valueOf(value));
            }catch (ArithmeticException e){
                this.showEquation.setText(String.valueOf(this.value)+" "+operator);
                this.mainLabel.setText("Can't divide by zero");
                this.buttonResetPressed();
            }



        }
    }

}