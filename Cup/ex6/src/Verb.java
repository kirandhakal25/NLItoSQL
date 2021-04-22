/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author kirandhakal25
 */
public class Verb {
//    Sql sql;         //SELECT, CREATE, UPDATE
    String type;        //select, create, update
    String verb;
    private String lexval;
    
    Verb(String v){
        System.out.println("I am inside Verb | " + v);
        verb = v;
        lexval = v;
        if (v.equals("List") || v.equals("Display") || v.equals("Present") || v.equals("Show") || v.equals("Find")){
            Sql.verb = "SELECT";
            type = "select";
        }
    }
    
    public String getLexval(){
        return lexval;
    }
    public void setLexval(String l){
        lexval = l;
    } 
}
