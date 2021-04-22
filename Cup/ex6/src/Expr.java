/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
import java.lang.Math;

/**
 *
 * @author kirandhakal25
 */
public class Expr {
    private int ivalue;
    private float fvalue;
    private String svalue;
    private char cvalue;
    private boolean bvalue;
    private String evalue;
    private String identifier;
    private Expr left_operand;
    private Expr right_operand;
    private int operator;
    private String operator_symbol;
    //type is assigned i,f,s,c,b,v,e for integer, float, string, char, boolean, variable/identifier and error respectively
    private char type;
    private boolean is_id;
    private String prefix;
    
    Expr(int a){
        ivalue = a;
        type = 'i';
        bvalue = false;
        prefix = "" + a;
    }
    
    Expr(float a){
        fvalue = a;
        type = 'f';
        bvalue = false;
        prefix = "" + a;
    }
    
    Expr(String a){
        svalue = a;
        type = 's';
        bvalue = false;
        prefix = "\"" + a + "\"";        
    }
    
    Expr(char a){
        cvalue = a;
        type = 'c';
        bvalue = false;
        prefix = "'" + a + "'";        
    }
    
    Expr(boolean a){
        bvalue = a;
        type = 'b';
        prefix = "" + a;        
    }
    
    //This constructor is for an identifier
    //The placeholder is to differentiate this constructor from the one for string literal
    Expr(String placeholder, String id){
        identifier = id;
        is_id = true;
        prefix = "" + id;        
    }

    Expr(Expr e1, Expr e2, int op) {
        left_operand = e1;
        right_operand = e2;
        operator = op;
        switch(operator){
            case sym.PLUS:
                operator_symbol = "+";
                break;
            case sym.MINUS:
                operator_symbol = "-";
                break;
            case sym.TIMES:
                operator_symbol = "*";
                break;
            case sym.DIVIDE:
                operator_symbol = "/";
                break;
            case sym.MOD:
                operator_symbol = "%";
                break;
            case sym.EXP:
                operator_symbol = "^";
                break;
            case sym.AND:
                operator_symbol = "AND";
                break;
            case sym.OR:
                operator_symbol = "OR";
                break;
            case sym.LT:
                operator_symbol = "<";
                break;
            case sym.GT:
                operator_symbol = ">";
                break;
            case sym.LTE:
                operator_symbol = "<=";
                break;
            case sym.GTE:
                operator_symbol = ">=";
                break;
            case sym.EQUAL:
                operator_symbol = "==";
                break;
            case sym.NOTEQUAL:
                operator_symbol = "!=";
                break;
            case sym.EQ:
                operator_symbol = "=";
                break;
                
        }
        prefix = operator_symbol + " " + left_operand.get_prefix() + " " + right_operand.get_prefix();
    }
    
    public char get_type(){
        return type;
    }
    
    public String get_value(){
        if (type == 'i') {
            return "" + ivalue;
        }
        else if (type == 'f') {
            return "" + fvalue;
        }
        else if (type == 's') {
            return svalue;
        }
        else if (type == 'c') {
            return "" + cvalue;
        }
        else if (type == 'b') {
            return "" + bvalue;
        }
        else {
            return "" + evalue;
        }        
    }
    
    public String get_prefix(){
        return prefix;
    }
    
    public void evaluate(){
        //if the expression does not have right operand and left operand and is a variable
        //just lookup the values according to the respective types
        if (left_operand == null && right_operand == null){
            if (is_id == true){
                TypeValue tv = Memory.get_type_value(identifier);
                if (tv.get_type() == 'i') {
                    type = 'i';
                    ivalue = Integer.parseInt("" + tv.get_value());
                }

                else if (tv.get_type() == 'f') {
                    type = 'f';
                    fvalue = Float.parseFloat("" + tv.get_value());
                }
                
                else if (tv.get_type() == 'c') {
                    type = 'c';
                    cvalue = ("" + tv.get_value()).charAt(0);

                }
                else if (tv.get_type() == 's') {
                    type = 's';
                    svalue = (String)tv.get_value();

                }
                else if (tv.get_type() == 'b') {
                    type = 'b';
                    bvalue = Boolean.parseBoolean("" + tv.get_value());

                }
            }
        }
        else{
            left_operand.evaluate();
            right_operand.evaluate();
            prefix = operator_symbol + " " + left_operand.get_prefix() + " " + right_operand.get_prefix();
        }
        
        if (operator == sym.PLUS){
                if(left_operand.get_type() == 'i' && right_operand.get_type() == 'i') {
                    type = 'i';
                    ivalue = Integer.parseInt(left_operand.get_value()) + Integer.parseInt(right_operand.get_value());
                }
                else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f') {
                    type = 'f';
                    fvalue = Float.parseFloat(left_operand.get_value()) + Float.parseFloat(right_operand.get_value());
                }
                else if ((left_operand.get_type() == 's' || left_operand.get_type() == 'c') && (right_operand.get_type() == 's' || right_operand.get_type() == 'c')) {
                    type = 's';
                    svalue = left_operand.get_value() + right_operand.get_value();
                }

                else if (left_operand.get_type() == 'e') {
                    type = 'e';
                    evalue = left_operand.get_value();
                }

                else if (right_operand.get_type() == 'e'){
                    type = 'e';
                    evalue = right_operand.get_value();
                }
                
                else {
                    type = 'e';
                    evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
                }
        } 
        
        else if (operator == sym.MINUS){
                if(left_operand.get_type() == 'i' && right_operand.get_type() == 'i') {
                    type = 'i';
                    ivalue = Integer.parseInt(left_operand.get_value()) - Integer.parseInt(right_operand.get_value());
                }
                
                else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f') {
                    type = 'f';
                    fvalue = Float.parseFloat(left_operand.get_value()) - Float.parseFloat(right_operand.get_value());
                }
                
                else if (left_operand.get_type() == 'e') {
                    type = 'e';
                    evalue = left_operand.get_value();
                }

                else if (right_operand.get_type() == 'e'){
                    type = 'e';
                    evalue = right_operand.get_value();
                }

                else {
                    type = 'e';
                    evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
                }                
        }
        
        else if (operator == sym.TIMES){
                if(left_operand.get_type() == 'i' && right_operand.get_type() == 'i') {
                    type = 'i';
                    ivalue = Integer.parseInt(left_operand.get_value()) * Integer.parseInt(right_operand.get_value());
                }
                else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f') {
                    type = 'f';
                    fvalue = Float.parseFloat(left_operand.get_value()) * Float.parseFloat(right_operand.get_value());
                }
                else if(left_operand.get_type() == 's' && right_operand.get_type() == 'i') {
                    type = 's';
                    String temp = left_operand.get_value();
                    int i = Integer.parseInt(right_operand.get_value());
                    for (int j = 0; j<i-1; j++){
                        temp = temp + temp;
                    }
                    svalue = temp;
                    if (i == 0) {
                        svalue = "";
                    }
                }
                
                else if (left_operand.get_type() == 'e') {
                    type = 'e';
                    evalue = left_operand.get_value();
                }

                else if (right_operand.get_type() == 'e'){
                    type = 'e';
                    evalue = right_operand.get_value();
                }

                else {
                    type = 'e';
                    evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
                }                
        }
        
        else if (operator == sym.DIVIDE){
                if(left_operand.get_type() == 'i' && right_operand.get_type() == 'i') {
                    type = 'i';
                    ivalue = Integer.parseInt(left_operand.get_value()) / Integer.parseInt(right_operand.get_value());
                }
                else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f') {
                    type = 'f';
                    fvalue = Float.parseFloat(left_operand.get_value()) / Float.parseFloat(right_operand.get_value());
                }        
                
                else if (left_operand.get_type() == 'e') {
                    type = 'e';
                    evalue = left_operand.get_value();
                }

                else if (right_operand.get_type() == 'e'){
                    type = 'e';
                    evalue = right_operand.get_value();
                }
                
                else {
                    type = 'e';
                    evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
                }
        }
        
        else if (operator == sym.MOD){
                if(left_operand.get_type() == 'i' && right_operand.get_type() == 'i') {
                    type = 'i';
                    ivalue = Integer.parseInt(left_operand.get_value()) % Integer.parseInt(right_operand.get_value());
                }
                else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f') {
                    type = 'f';
                    fvalue = Float.parseFloat(left_operand.get_value()) % Float.parseFloat(right_operand.get_value());
                }
                
                else if (left_operand.get_type() == 'e') {
                    type = 'e';
                    evalue = left_operand.get_value();
                }

                else if (right_operand.get_type() == 'e'){
                    type = 'e';
                    evalue = right_operand.get_value();
                }

                else {
                    type = 'e';
                    evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
                }
        }
        
        else if (operator == sym.EXP){
                if(left_operand.get_type() == 'i' && right_operand.get_type() == 'i') {
                    type = 'i';
                    ivalue = (int)Math.pow((double)Integer.parseInt(left_operand.get_value()),(double)Integer.parseInt(right_operand.get_value()));
                }
                
                else if(left_operand.get_type() == 'f' && right_operand.get_type() == 'f') {
                    type = 'f';
                    fvalue = (float)Math.pow((double)Float.parseFloat(left_operand.get_value()),(float)Float.parseFloat(right_operand.get_value()));
                }
                
                else if (left_operand.get_type() == 'e') {
                    type = 'e';
                    evalue = left_operand.get_value();
                }

                else if (right_operand.get_type() == 'e'){
                    type = 'e';
                    evalue = right_operand.get_value();
                }

                else {
                    type = 'e';
                    evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
                }

        }
        
        else if (operator == sym.AND){
            if(left_operand.get_type() == 'b' && right_operand.get_type() == 'b') {
                type = 'b';
                bvalue = Boolean.parseBoolean(left_operand.get_value()) && Boolean.parseBoolean(right_operand.get_value());
            }

            else if (left_operand.get_type() == 'e') {
                type = 'e';
                evalue = left_operand.get_value();
            }
            
            else if (right_operand.get_type() == 'e'){
                type = 'e';
                evalue = right_operand.get_value();
            }
            
            else {
                type = 'e';
                evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
            }
        }
        
        else if (operator == sym.OR){
            if(left_operand.get_type() == 'b' && right_operand.get_type() == 'b') {
                type = 'b';
                bvalue = Boolean.parseBoolean(left_operand.get_value()) || Boolean.parseBoolean(right_operand.get_value());
            }            

            else if (left_operand.get_type() == 'e') {
                type = 'e';
                evalue = left_operand.get_value();
            }
            
            else if (right_operand.get_type() == 'e'){
                type = 'e';
                evalue = right_operand.get_value();
            }

            else {
                type = 'e';
                evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
            }

        }
        
        else if (operator == sym.LT) {
            if (left_operand.get_type() == 'i' && right_operand.get_type() == 'i' && (Integer.parseInt(left_operand.get_value()) < Integer.parseInt(right_operand.get_value()))) {
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'i' && right_operand.get_type() == 'i' && (Integer.parseInt(left_operand.get_value()) >= Integer.parseInt(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f' && (Float.parseFloat(left_operand.get_value()) < Float.parseFloat(right_operand.get_value()))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f' && (Float.parseFloat(left_operand.get_value()) >= Float.parseFloat(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
                
            else if (left_operand.get_type() == 'c' && right_operand.get_type() == 'c' && (left_operand.get_value().charAt(0) < right_operand.get_value().charAt(0))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'c' && right_operand.get_type() == 'c' && (left_operand.get_value().charAt(0) >= right_operand.get_value().charAt(0))){
                bvalue = false;
                type = 'b';
            }

            else if (left_operand.get_type() == 'e') {
                type = 'e';
                evalue = left_operand.get_value();
            }
            
            else if (right_operand.get_type() == 'e'){
                type = 'e';
                evalue = right_operand.get_value();
            }

            else {
                type = 'e';
                evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
            }
        }
        
        else if (operator == sym.GT) {
            if (left_operand.get_type() == 'i' && right_operand.get_type() == 'i' && (Integer.parseInt(left_operand.get_value()) > Integer.parseInt(right_operand.get_value()))) {
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'i' && right_operand.get_type() == 'i' && (Integer.parseInt(left_operand.get_value()) <= Integer.parseInt(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f' && (Float.parseFloat(left_operand.get_value()) > Float.parseFloat(right_operand.get_value()))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f' && (Float.parseFloat(left_operand.get_value()) <= Float.parseFloat(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
                
            else if (left_operand.get_type() == 'c' && right_operand.get_type() == 'c' && (left_operand.get_value().charAt(0) > right_operand.get_value().charAt(0))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'c' && right_operand.get_type() == 'c' && (left_operand.get_value().charAt(0) <= right_operand.get_value().charAt(0))){
                bvalue = false;
                type = 'b';
            }

            else if (left_operand.get_type() == 'e') {
                type = 'e';
                evalue = left_operand.get_value();
            }
            
            else if (right_operand.get_type() == 'e'){
                type = 'e';
                evalue = right_operand.get_value();
            }
            
            else {
                type = 'e';
                evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
            }
        }

        else if (operator == sym.LTE) {
            if (left_operand.get_type() == 'i' && right_operand.get_type() == 'i' && (Integer.parseInt(left_operand.get_value()) <= Integer.parseInt(right_operand.get_value()))) {
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'i' && right_operand.get_type() == 'i' && (Integer.parseInt(left_operand.get_value()) > Integer.parseInt(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f' && (Float.parseFloat(left_operand.get_value()) <= Float.parseFloat(right_operand.get_value()))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f' && (Float.parseFloat(left_operand.get_value()) > Float.parseFloat(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
                
            else if (left_operand.get_type() == 'c' && right_operand.get_type() == 'c' && (left_operand.get_value().charAt(0) <= right_operand.get_value().charAt(0))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'c' && right_operand.get_type() == 'c' && (left_operand.get_value().charAt(0) > right_operand.get_value().charAt(0))){
                bvalue = false;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'e') {
                type = 'e';
                evalue = left_operand.get_value();
            }
            
            else if (right_operand.get_type() == 'e'){
                type = 'e';
                evalue = right_operand.get_value();
            }

            else {
                type = 'e';
                evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
            }
        }
        
        else if (operator == sym.GTE) {
            if (left_operand.get_type() == 'i' && right_operand.get_type() == 'i' && (Integer.parseInt(left_operand.get_value()) >= Integer.parseInt(right_operand.get_value()))) {
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'i' && right_operand.get_type() == 'i' && (Integer.parseInt(left_operand.get_value()) < Integer.parseInt(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f' && (Float.parseFloat(left_operand.get_value()) >= Float.parseFloat(right_operand.get_value()))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f' && (Float.parseFloat(left_operand.get_value()) < Float.parseFloat(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
                
            else if (left_operand.get_type() == 'c' && right_operand.get_type() == 'c' && (left_operand.get_value().charAt(0) >= right_operand.get_value().charAt(0))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'c' && right_operand.get_type() == 'c' && (left_operand.get_value().charAt(0) < right_operand.get_value().charAt(0))){
                bvalue = false;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'e') {
                type = 'e';
                evalue = left_operand.get_value();
            }
            
            else if (right_operand.get_type() == 'e'){
                type = 'e';
                evalue = right_operand.get_value();
            }
            
            else {
                type = 'e';
                evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
            }
        }
        
        else if (operator == sym.EQUAL) {
            if (left_operand.get_type() == 'i' && right_operand.get_type() == 'i' && (Integer.parseInt(left_operand.get_value()) == Integer.parseInt(right_operand.get_value()))) {
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'i' && right_operand.get_type() == 'i' && (Integer.parseInt(left_operand.get_value()) != Integer.parseInt(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f' && (Float.parseFloat(left_operand.get_value()) == Float.parseFloat(right_operand.get_value()))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f' && (Float.parseFloat(left_operand.get_value()) != Float.parseFloat(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
                
            else if (left_operand.get_type() == 'c' && right_operand.get_type() == 'c' && (left_operand.get_value().charAt(0) == right_operand.get_value().charAt(0))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'c' && right_operand.get_type() == 'c' && (left_operand.get_value().charAt(0) != right_operand.get_value().charAt(0))){
                bvalue = false;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 's' && right_operand.get_type() == 's' && (left_operand.get_value().equals(right_operand.get_value()))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 's' && right_operand.get_type() == 's' && (left_operand.get_value().equals(right_operand.get_value())) == false){
                bvalue = false;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'b' && right_operand.get_type() == 'b' && (left_operand.get_value().equals(right_operand.get_value())) == true){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'b' && right_operand.get_type() == 'b' && (left_operand.get_value().equals(right_operand.get_value())) == false){
                bvalue = false;
                type = 'b';
            }

            
            else if (left_operand.get_type() == 'e') {
                type = 'e';
                evalue = left_operand.get_value();
            }
            
            else if (right_operand.get_type() == 'e'){
                type = 'e';
                evalue = right_operand.get_value();
            }            
            
            else {
                type = 'e';
                evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
            }
        }

        else if (operator == sym.NOTEQUAL) {
            if (left_operand.get_type() == 'i' && right_operand.get_type() == 'i' && (Integer.parseInt(left_operand.get_value()) != Integer.parseInt(right_operand.get_value()))) {
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'i' && right_operand.get_type() == 'i' && (Integer.parseInt(left_operand.get_value()) == Integer.parseInt(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f' && (Float.parseFloat(left_operand.get_value()) != Float.parseFloat(right_operand.get_value()))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'f' && right_operand.get_type() == 'f' && (Float.parseFloat(left_operand.get_value()) == Float.parseFloat(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
                
            else if (left_operand.get_type() == 'c' && right_operand.get_type() == 'c' && (left_operand.get_value().charAt(0) != right_operand.get_value().charAt(0))){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'c' && right_operand.get_type() == 'c' && (left_operand.get_value().charAt(0) == right_operand.get_value().charAt(0))){
                bvalue = false;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 's' && right_operand.get_type() == 's' && (left_operand.get_value().equals(right_operand.get_value())) == false){
                bvalue = true;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 's' && right_operand.get_type() == 's' && (left_operand.get_value().equals(right_operand.get_value()))){
                bvalue = false;
                type = 'b';
            }
            
            else if (left_operand.get_type() == 'e') {
                type = 'e';
                evalue = left_operand.get_value();
            }
            
            else if (right_operand.get_type() == 'e'){
                type = 'e';
                evalue = right_operand.get_value();
            }
            
            else {
                type = 'e';
                evalue = "Type Mismatch Error between " + left_operand.get_type() + " type and " + right_operand.get_type() + " type";
            }
        }        
                        
    }
    
}
