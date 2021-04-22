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
public class TypeValue {
    private char type;
    private Object value;

    TypeValue(char t, Object v){
        type = t;
        value = v;
    }
    
    public char get_type(){
        return type;
    }
    
    public void set_type(char c){
        type = c;
    }
    
    public Object get_value(){
        return value;
    }
    
    public void set_value(Object v){
        value = v;
    }
}
