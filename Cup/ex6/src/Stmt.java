/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author kirandhakal25
 */
public class Stmt {
    
    //type = print, declare, define, ifthen, ifelse, assign, error
    private String type;
    
    //Used by : print, ifthen, define
    private Expr expr;
    
    //Used by : declare, define
    private String id;
    
    //Used by : declare, define
    private char id_type;

    //Used by define
    private Object id_value;
    
    //Used by error
    private String error_message;

    
    //Used by ifthen
    private ArrayList<Stmt> ifchild;

    
    private ArrayList<ElseBlock> elsechild;
    
    //Used by while
    private ArrayList<Stmt> whilechild;

    //Used to store prefix of the statement
    private String prefix;

    
    public String get_type(){
        return type;
    }
    
    public String get_id(){
        return id;
    }
    
    public String get_prefix(){
        return prefix;
    }
    
    public static Stmt print(Expr e) {
        Stmt a = new Stmt();
        a.type = "print";
        a.expr = e;
        a.prefix = "PRINT " + e.get_prefix() + ";";
        return a;
    }
    
    public static Stmt list(Expr e) {
        Stmt a = new Stmt();
        a.type = "list";
        a.expr = e;
        a.prefix = "List " + e.get_prefix() + ";";
        return a;
    }
    
    public static Stmt noprint(Expr e) {
        Stmt a = new Stmt();
        Expr b = new Expr("<<Access denied - Confidential Information>>");
        a.type = "print";
        a.expr = b;
        a.prefix = "NOPRINT : No prefix for this";
        return a;
    }
    
    public static Stmt noprint() {
        Stmt a = new Stmt();
        Expr b = new Expr("<<Access denied - Confidential Information>>");
        a.type = "print";
        a.expr = b;
        a.prefix = "NOPRINT : No prefix for this";
        return a;
    }

    public static Stmt declare_int(String id){
        Stmt a = new Stmt();
        System.out.println(Memory.memory.containsKey(id));
//        if(Memory.memory.containsKey(id)){
            a.type = "declare";
            a.id = id;
            a.id_type = 'i';
            a.prefix = "INT " + id + ";";
//        }
//        else{
//            a.type = "error";
//            a.error_message = "Error : " + id + " has already been declared";
//        }
        return a;
    }

    public static Stmt declare_float(String id){
        Stmt a = new Stmt();
        a.type = "declare";
        a.id = id;
        a.id_type = 'f';
        a.prefix = "FLOAT " + id + ";";
        return a;
    }

    public static Stmt declare_char(String id){
        Stmt a = new Stmt();
        a.type = "declare";
        a.id = id;
        a.id_type = 'c';
        a.prefix = "CHAR " + id + ";";
        return a;
    }

    public static Stmt declare_string(String id){
        Stmt a = new Stmt();
        a.type = "declare";
        a.id = id;
        a.id_type = 's';
        a.prefix = "STRING " + id + ";";
        return a;
    }
    
    public static Stmt declare_boolean(String id){
        Stmt a = new Stmt();
        a.type = "declare";
        a.id = id;
        a.id_type = 'b';
        a.prefix = "BOOLEAN " + id + ";";
        return a;
    }
    
    public static Stmt declare_kir(String id){
        Stmt a = new Stmt();
        a.type = "declare";
        a.id = id;
        a.id_type = 'k';
        a.prefix = "No prefix this time";
        return a;
    }
    
    public static Stmt define_int(String id, Expr e){
        Stmt a = new Stmt();
        a.type = "define";
        a.id = id;
        a.id_type = 'i';
        a.expr = e;
        a.prefix = "= INT " + id + " " + e.get_prefix() + ";";
        return a;
    }

    public static Stmt define_float(String id, Expr e){
        Stmt a = new Stmt();
        a.type = "define";
        a.id = id;
        a.id_type = 'f';
        a.expr = e;
        a.prefix = "= FLOAT " + id + " " + e.get_prefix() + ";";
        return a;
    }
    
    public static Stmt define_char(String id, Expr e){
        Stmt a = new Stmt();
        a.type = "define";
        a.id = id;
        a.id_type = 'c';
        a.expr = e;
        a.prefix = "= CHAR " + id + " " + e.get_prefix() + ";";        
        return a;
    }

    public static Stmt define_string(String id, Expr e){
        Stmt a = new Stmt();
        a.type = "define";
        a.id = id;
        a.id_type = 's';
        a.expr = e;
        a.prefix = "= STRING " + id + " " + e.get_prefix() + ";";
        return a;
    }

    public static Stmt define_boolean(String id, Expr e){
        Stmt a = new Stmt();
        a.type = "define";
        a.id = id;
        a.id_type = 'b';
        a.expr = e;
        a.prefix = "= BOOLEAN " + id + " " + e.get_prefix() + ";";
        return a;
    }
    
    public static Stmt ifthen(Expr e, ArrayList<Stmt> sl){
        Stmt a = new Stmt();
        a.type = "ifthen";
        a.expr = e;
        a.ifchild = sl;
        
        //calculate prefix
        a.prefix = "IF " + e.get_prefix() + " {";
        for (Stmt s : sl){
            a.prefix = a.prefix + "\n\t" + s.get_prefix();
        }
        a.prefix = a.prefix + "\n };";
        
        return a;
    }
    
    public static Stmt ifelse(Expr e, ArrayList<Stmt> sl, ArrayList<ElseBlock> ebl){
        Stmt a = new Stmt();
        a.type = "ifelse";
        a.expr = e;
        a.ifchild = sl;
        a.elsechild = ebl;
        
        //calculate prefix
        a.prefix = "IF " + e.get_prefix() + " { ";
        for (Stmt s : sl){
            a.prefix = a.prefix + "\n\t" + s.get_prefix();
        }
        a.prefix = a.prefix + "\n}";
        
        //add prefix from the elseif blocks and/or else block
        for (ElseBlock eb : ebl){
            a.prefix = a.prefix + eb.get_prefix();
        }
        a.prefix = a.prefix + ";";
        
        return a;
    }

    public static Stmt assign(String i, Expr e){
        Stmt a = new Stmt();
        a.type = "assign";
        a.expr = e;
        a.id = i;
        a.prefix = "= " + i + " " + e.get_prefix() + ";";
        return a;
    }
    
    public static Stmt while_s(Expr e, ArrayList<Stmt> sl){
        Stmt a = new Stmt();
        a.type = "while";
        a.expr = e;
        a.whilechild = sl;
        
        //calculate prefix
        a.prefix = "WHILE " + e.get_prefix() + " { ";
        for (Stmt s : sl){
            a.prefix = a.prefix + "\n\t" + s.get_prefix();
        }
        a.prefix = a.prefix + "\n}";
        
        return a;
    }
    
    public static Stmt dowhile_s(Expr e, ArrayList<Stmt> sl){
        Stmt a = new Stmt();
        a.type = "dowhile";
        a.expr = e;
        a.whilechild = sl;
        a.prefix = "DO WHILE " + e.get_prefix() + " { ";
        for (Stmt s : sl){
            a.prefix = a.prefix + "\n\t" + s.get_prefix();
        }
        a.prefix = a.prefix + "\n}";

        return a;
    }


    public void execute_prefix(javax.swing.JTextArea jTextAreaPrefix){
        jTextAreaPrefix.setText(jTextAreaPrefix.getText() + prefix + "\n");
    }
    
    public void execute(javax.swing.JTextArea jTextAreaOutput, javax.swing.JTextArea jTextAreaPrefix) {
        try {
            if (type == "print") {
                expr.evaluate();
                jTextAreaOutput.setText(jTextAreaOutput.getText() + (expr.get_value()) + "\n");            
            }
            else if (type == "list") {
                expr.evaluate();
                jTextAreaOutput.setText(jTextAreaOutput.getText() + "SELECT * FROM " + (expr.get_value()) + "\n");
            }

            else if (type == "error") {
                System.out.println("Hello from Stmt execute() type == error");
                jTextAreaOutput.setText(error_message);
            }

            else if (type == "declare"){
                if (!Memory.memory.containsKey(id)){
                    if (id_type == 'i'){
                            TypeValue tv = new TypeValue('i',0);
                            Memory.memory.put(id, tv);
                    }

                    if (id_type == 'f'){
                            TypeValue tv = new TypeValue('f',(float)0.0);
                            Memory.memory.put(id, tv);
                    }

                    else if (id_type == 'c'){
                            TypeValue tv = new TypeValue('c',' ');
                            Memory.memory.put(id, tv);
                    }

                    else if (id_type == 's'){
                            TypeValue tv = new TypeValue('s'," ");
                            Memory.memory.put(id, tv);
                    }

                    else if (id_type == 'b'){
                            TypeValue tv = new TypeValue('b',false);
                            Memory.memory.put(id, tv);
                    }
                    
                    else if (id_type == 'k'){
                            TypeValue tv = new TypeValue('k', null);
                            Memory.memory.put(id, tv);
                    }
                        
                }
                else {
                    throw new Error("Syntax Error: Duplicate Declaration: " + id + " has already been declared");
                }

            }
            

            else if (type == "define"){
                if (!Memory.memory.containsKey(id)){
                    expr.evaluate();
                    if (id_type == expr.get_type()){
                        id_value = (Object)expr.get_value();
                        TypeValue tv = new TypeValue(id_type, id_value);
                        Memory.memory.put(id, tv);
                    }
                    else{
                        throw new Error("Type Mismatch Error between " + id_type + " and " +  expr.get_type() + " types" );
                    }
                }
                else{
                    System.out.println("");
                    throw new Error("Syntax Error: Duplicate Declaration: " + id + " has already been declared");                
                }
            }

            else if (type == "assign"){
                    expr.evaluate();                
                    //Checking if the variable exists in memory
                    if(Memory.memory.containsKey(id)){
                        TypeValue id_from_memory = Memory.memory.get(id);
                        //Checking if the existing variable type matches the assigned expression type
                        if (expr.get_type() == id_from_memory.get_type()){

                            //code to assign
                            TypeValue tv = Memory.get_type_value(id);
                            expr.evaluate();
                            Object val = (Object)expr.get_value();
                            char typ = (char)expr.get_type();
                            TypeValue new_tv = new TypeValue(typ, val);

                            Memory.memory.put(id, new_tv);
                        }

                        else {
                            throw new Error("Type Mismatch Error between " + Memory.memory.get(id).get_type() + " and " +  expr.get_type() + " types" );
                        }
                    }
                    else{
                        throw new Error("Syntax Error: Variable " + id + " has not been declared");
                    }                
            }

            else if (type == "ifthen"){
                    expr.evaluate();
                    if (expr.get_type() == 'b'){
                        //if the expr of the ifstatement is true
                        if (expr.get_value().equals("true")){
                            for(Stmt s : ifchild){
                                s.execute(jTextAreaOutput, jTextAreaPrefix);
                            }
                        }
                    }
                    else{
                        throw new Error("Syntax Error: Expression in if statement is not b type");
                    }
            }

            else if (type == "ifelse"){
                    expr.evaluate();
                    if(expr.get_value().equals("true")){
                        for(Stmt s: ifchild){
                            s.execute(jTextAreaOutput, jTextAreaPrefix);
                        }
                    }

                    else{
                        // if else_flag is false then we will not execute remaining elseif and else blocks
                        boolean else_flag = true;
                        for (ElseBlock eb: elsechild){

                            // if eb is elseif block as it has an expression
                            if(eb.get_expr() != null){
                                eb.get_expr().evaluate();
                                Expr e = eb.get_expr();
                                if (e.get_value().equals("true") && else_flag == true){
                                    ArrayList<Stmt> sl = eb.get_stmt_list();
                                    for (Stmt s: sl){
                                            s.execute(jTextAreaOutput, jTextAreaPrefix);
                                    }
                                    else_flag = false;
                                }
                            }

                            // if eb is else block as it does not have an expression
                            // and also none of the elseif statements have been executed
                            else if (else_flag == true){
                                ArrayList<Stmt> sl = eb.get_stmt_list();
                                for (Stmt s: sl){
                                    s.execute(jTextAreaOutput, jTextAreaPrefix);
                                }
                            }
                        }

                    }
            }

            else if (type == "while") {
                expr.evaluate();
                while(Boolean.parseBoolean(expr.get_value())){
                    for(Stmt s : whilechild){
                        s.execute(jTextAreaOutput, jTextAreaPrefix);
                    }
                    expr.evaluate();
                }
            }

            else if (type == "dowhile") {
                expr.evaluate();
                do {
                    for(Stmt s : whilechild){
                        s.execute(jTextAreaOutput, jTextAreaPrefix);
                    }
                    expr.evaluate();
                }
                while (Boolean.parseBoolean(expr.get_value()));
            }
        
        }
        catch (Error e){
            jTextAreaOutput.setText(e.getMessage());
            jTextAreaPrefix.setText("");
        }
    }
}
