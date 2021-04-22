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
public class Sentence {
    private VP vp;
    
    Sentence(VP v){
        vp = v;
    }
    
    public VP getVP(){
        return vp;
    }
    public void setVP(VP v){
        vp = v;
    }
}
