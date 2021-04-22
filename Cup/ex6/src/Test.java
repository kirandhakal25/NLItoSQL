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
public class Test {
    public static void main(String args[]){
        TypeValue tv = new TypeValue('i', 123);
        TypeValue tv2 = new TypeValue('i', 234);
        Memory.memory.put("c", tv);
        Memory.memory.put("d", tv2);
        Memory.memory.get("c");
        Memory.dump();        
    }
}
