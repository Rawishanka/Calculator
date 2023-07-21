package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class HelloController {
    private boolean minus;
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
        this.minus = false;

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
        this.numericalButtonPressed("1");

    }
    @FXML
    protected void button2Pressed(){
        this.numericalButtonPressed("2");
    }

    @FXML
    protected void button3Pressed(){
        this.numericalButtonPressed("3");
    }

    @FXML
    protected void button4Pressed(){
        this.numericalButtonPressed("4");
    }

    @FXML
    protected void button5Pressed(){
        this.numericalButtonPressed("5");
    }

    @FXML
    protected void button6Pressed(){
        this.numericalButtonPressed("6");
    }

    @FXML
    protected void button7Pressed(){
        this.numericalButtonPressed("7");
    }

    @FXML
    protected void button8Pressed(){
        this.numericalButtonPressed("8");
    }
    @FXML
    protected void button9Pressed(){
        this.numericalButtonPressed("9");
    }

    @FXML
    protected void button0Pressed(){
        this.numericalButtonPressed("0");
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
        this.evaluate("=");
    }

    @FXML
    protected void buttonMultiplyPressed(){
        this.evaluate("×");
    }

    @FXML
    protected void buttonModuloPressed(){
        this.evaluate("%");
    }

    @FXML
    protected void buttonDividePressed(){
        this.evaluate("÷");
    }

    @FXML
    protected void buttonPlusOrMinusPressed(){
        if(!this.minus){
            if(this.number.length() == 0){
                this.number = "-0"+ this.number;
            }else{
                this.number = "-"+ this.number;
            }
            this.minus = true;
        }else{
            this.number = this.number.substring(1,this.number.length());
            this.minus = false;
        }
        this.mainLabel.setText(this.number);
    }

    @FXML
    protected void buttonErasePressed(){
        if (this.number.length() == 0){
            this.mainLabel.setText("0");
            this.minus = false;
        }else{
            String subString = this.number.substring(0,this.number.length()-1);
            if(subString.length() == 0){
                this.mainLabel.setText("0");
                this.number = "";
                this.minus = false;
            }else{
                this.number = subString;
                this.mainLabel.setText(this.number);
            }
        }
    }

    @FXML
    protected void buttonResetPressed(){
        this.mainLabel.setText("0");
        this.showEquation.setText("0");
        this.stk.clear();
        this.number = "";
        this.minus = false;
    }

    @FXML
    protected void buttonDecimalPressed(){
        if(this.number.length() == 0){
            this.number = "0.";
        }else{
            if(this.number.contains(".")){

            }else{
                this.number += ".";
            }
        }
        this.mainLabel.setText(this.number);
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
        this.minus = false;
        if(this.stk.isEmpty() && this.number.length() == 0){
            if(Objects.equals(operator, "=")){
                this.showEquation.setText("0 "+operator);
            }else{
                this.stk.push("0");
                this.stk.push(operator);
                this.showEquation.setText("0 "+operator);
                this.mainLabel.setText("0");
            }


        } else if (this.number.length() != 0 && this.stk.isEmpty()) {
            this.showEquation.setText(this.number+ " "+ operator);
            this.stk.push(this.number);
            if(!Objects.equals(operator, "=")){
                this.stk.push(operator);
            }
            this.number = "";

        }else if(this.number.length() == 0){
            if(!Objects.equals(operator, "=") && this.stk.size() != 1){
                this.stk.pop();
                String temp = this.stk.pop();
                this.stk.push(temp);
                this.stk.push(operator);
                this.showEquation.setText(temp + " "+operator);
            }else if(Objects.equals(operator, "=") && this.stk.size() != 1){
                this.stk.pop();
                String temp = this.stk.pop();
                this.stk.push(temp);
                this.showEquation.setText(temp + " "+operator);
            }else if(!Objects.equals(operator, "=") && this.stk.size() == 1){
                String temp = this.stk.pop();
                this.stk.push(temp);
                this.stk.push(operator);
                this.showEquation.setText(temp + " "+operator);
            }else{
                String temp = this.stk.pop();
                this.stk.push(temp);
                this.showEquation.setText(temp + " "+operator);
            }

        }else{
            if(this.stk.size() == 1){
                this.stk.pop();
                this.stk.push(this.number);
                if(!Objects.equals(operator, "=")){
                    this.stk.push(operator);
                }
                this.showEquation.setText(this.number+" "+operator);
                this.number = "";
            }else{
                this.stk.push(this.number);
                try{
                    this.value = this.answer.returnValue();
                    this.stk.clear();
                    this.stk.push(String.valueOf(value));
                    if(!Objects.equals(operator, "=")){
                        this.stk.push(operator);
                    }
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
    public void numericalButtonPressed(String button){
        if(this.number.length() == 1 && this.number.equals("0") || this.number.equals("-0")){
            if(this.minus){
                this.number = "-"+button;
            }else{
                this.number = button;
            }
        }else{
            this.number += button;
        }
        this.mainLabel.setText(this.number);
    }

}