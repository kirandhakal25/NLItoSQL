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
public class Preposition {
    private String lexval;
    
    Preposition(String s){
        System.out.println("I am inside Preposition | " + s);
        lexval = s;
    }
    
    public String getLexval(){
        return lexval;
    }
    public void setLexval(String l){
        lexval = l;
    }
}
