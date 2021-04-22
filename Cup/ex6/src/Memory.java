/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
import java.util.Hashtable;
import java.util.*;

/**
 *
 * @author kirandhakal25
 */
public class Memory {
    static Hashtable<String, TypeValue> memory = new Hashtable<String, TypeValue>();


    public static void main (String args[]){
        System.out.println("Hello");
        TypeValue tv = new TypeValue('i', 123);
        TypeValue tv2 = new TypeValue('c', 'c');
        memory.put("a", tv);
        memory.put("c", tv2);
//        System.out.println(memory.get("a"));
        dump();
    }
    
    public static TypeValue get_type_value(String id) {
        TypeValue tv = memory.get(id);
        return tv;
    }
                
            
    public static Object get_value(String id){
        TypeValue tv = memory.get(id);
        return tv.get_value();
    }
    
    public static void set_value(String id, Object val){
        //Check if the id exists in memory
        //if exists assign
        //else return identifier not declared error
    }
    
    public static void dump(){
        Enumeration names;
        String key;
        
        names = memory.keys();
        while(names.hasMoreElements()) {
            key = (String) names.nextElement();
            System.out.println("Key: " +key+ " & Type: " +
            memory.get(key).get_type() + " & Value: " + memory.get(key).get_value());
        }
    }
}


