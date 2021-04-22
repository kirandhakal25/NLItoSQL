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
public class VP {
    private String tablename;
    private String columns;
    private Verb verb;
    private NP noun_phrase;
    private NPMixed noun_phrase_mixed;

    
    VP(Verb v, NPMixed np){
        verb = v;
        noun_phrase_mixed = np;
    }
    VP(Verb v, NP np){
//        VP vp = new VP();
        if (v.getLexval().equals("Find")){
            Sql.table = np.getNoun().getLexval();
            System.out.println("Hello before null pointer exception");
            Sql.select.add("*");
            System.out.println(np.getNoun().getLexval());
            System.out.println("The table is "+Sql.table);
        }
        
        verb = v;
        noun_phrase = np;
//        System.out.println(sql);
//        return vp;
    }
    public void execute(javax.swing.JTextArea jTextAreaOutput){
        jTextAreaOutput.setText(jTextAreaOutput.getText() + Sql.sql + "\n");
    }
    
    public Verb getVerb(){
        return verb;
    }
    
    public NP getNP(){
        return noun_phrase;
    }
}
