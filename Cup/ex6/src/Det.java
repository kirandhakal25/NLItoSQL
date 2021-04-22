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
public class Det {
    private String lexval;
    
    Det(String d){
        lexval = d;
    }
    
    public String getLexval(){
        return lexval;
    }
    public void setLexval(String d){
        lexval = d;
    }
}
