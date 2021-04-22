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
public class NP {
    private String tablename;           //tablename is recognized by the grammar rules
    private String sqll;
    Sql sql;
    String type;                //column, table, count, average, minimum, maximum
    private Noun noun;
    private NP np;
    private Adjective adjective;
    String table;
    String attributes;

    //For NP with only nouns that are tablenames or attributenames
    NP(Noun n){
        System.out.println("I am inside NP | " + n.getLexval());
        noun = n;
        type = n.getType();
        sql = n.sql;
    }
    
    //For NP with Det Noun
    NP(Det d, Noun n){
        System.out.println("I am inside NP which is Det Noun | " + d.getLexval() + " "+ n.getLexval() );
        System.out.println(n.getType());
        noun = n;
        type = n.getType();
        System.out.println("I am exiting this constructor");
    }
    
    //For NP with Det NP
    NP(Det d, NP n){
        np = n;
        System.out.println("I am inside NP which is Det NP");
        System.out.println(np.getNoun());
        noun = np.getNoun();
        type = np.getNoun().getType();
        adjective = np.getAdjective();
    }

    //For NP with Adjective Noun
    NP(Adjective a, Noun n){
        noun = n;
        type = n.getType();
        adjective = a;
    }
    
    
    //For NP_mixed that links a NP with a PP
    NP(NP np, PP pp){
        System.out.println("I am inside NP_mixed | " + np + " " + pp);
        System.out.println(np.type);
        type = np.type;
        noun = np.getNoun();
    }
    
    //All constructors below this are old implementations that are not relevant anymore
    //Just keeping them so that I may come across them again    
    NP(String adj, String noun){
        if (noun.equals("details")){
            type = "column";
            sqll = "*";
        }
        else{
            type = "table";
            sqll = " * FROM " + noun;
        }
    }
    
    NP(String adj, String det, String noun){
        if (noun.equals("details")){
            type = "column";
            sqll = "*";
        }
        else{
            type = "table";
            sqll = " * FROM " + noun;
        }
    }
    
    public String getSql(){
        return sqll;
    }
    public Noun getNoun(){
        return noun;
    }
    public void setNoun(Noun n){
        noun = n;
    }
    public Adjective getAdjective(){
        return adjective;
    }
    public void setAdjective(Adjective a){
        adjective = a;
    }
}
