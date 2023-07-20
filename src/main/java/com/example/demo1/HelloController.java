package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Stack;

public class HelloController {
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
        this.stk.push("0");
        this.visible = false;
        this.number = "0";
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
        System.out.println("button plus");
    }

    @FXML
    protected void buttonResetPressed(){
        this.mainLabel.setText("0");
        this.showEquation.setText("0");
        this.stk.clear();
        this.number = "0";
    }

    @FXML
    protected void buttonDecimalPressed(){
        System.out.println("button plus");
    }

    @FXML
    protected void buttonPercentagePressed(){
        System.out.println("button plus");
    }

    public void evaluate(String o){

        System.out.println(this.stk);
        System.out.println(this.stk.peek());
        if(this.operators.contains(this.stk.peek())){
            this.stk.push(this.number);
            System.out.println("hello");
            this.stk.pop();
            this.stk.push(o);
        } else if (this.stk.size() == 1) {
            this.stk.push(this.number);
            System.out.println("bye");
            this.stk.push(o);
            this.showEquation.setText(this.number+o);
            this.number = "0";
        }else {
            this.stk.push(this.number);
            System.out.println("end");
            String temp = String.valueOf(this.answer.returnValue());
            this.showEquation.setText(String.valueOf(temp+o));
            this.stk.clear();
            this.stk.push(temp);
            this.stk.push(o);
            this.number ="0";
        }
        System.out.println(this.stk);


    }
}