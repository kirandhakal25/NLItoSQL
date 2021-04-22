/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author kirandhakal25
 */
public class PP {
    String prep;
    String np_type;
    String noun;
    private Preposition preposition;
    private NP noun_phrase;
    private NPMixed noun_phrase_mixed;
    
    PP(Preposition p, NPMixed np){
        preposition = p;
        noun_phrase_mixed = np;
    }
    
    PP(Preposition p, NP np){
        System.out.println("I am inside PP | " + p.getLexval() + " " + np.getNoun().getLexval());
        preposition = p;
        np_type = np.type;
        noun = np.getNoun().getLexval();
        noun_phrase = np;
        
        
        // if the preposition is by, add a new element in sql.group_by;
        if (p.getLexval().equals("by")){
            if (noun_phrase != null){
                PreSql.group_by.add(noun_phrase.getNoun().getLexval());
            }
            else if (noun_phrase_mixed != null){
                PreSql.group_by.add(noun_phrase_mixed.getNP().getNoun().getLexval());
            }
//            Sql.group_by = noun;
//            String[] group_by_arr = sql.group_by;
//            ArrayList<String> list = new ArrayList<String>(Arrays.asList(group_by_arr));
//            list.add(noun);
//            sql.group_by = list.toArray(group_by_arr);
        }
        if (p.getLexval().equals("of")){
            System.out.println("Hello from PP inside the if condition of p-------------");
            if (np.type.equals("table")){
//                Sql.table = np.getNoun().getLexval();
//                System.out.println(np.getNoun().getLexval());
//                PreSql.func_candidate = "*";
//                System.out.println("I am printing the func_canditate from *");
            }
        }
    }
    public Preposition getPreposition(){
        return preposition;
    }
    public NP getNP(){
        return noun_phrase;
    }
    public NPMixed getNPMixed(){
        return noun_phrase_mixed;
    }
}
