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
public class Adjective {
    private String lexval;
    
    Adjective(String a){
        lexval = a;
    }
    
    public String getLexval(){
        return lexval;
    }
    public void setLexval(String a){
        lexval = a;
    }
    
}
