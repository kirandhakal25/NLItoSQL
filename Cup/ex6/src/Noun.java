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
public class Noun {
    private String type;        //table, attribute, count
    String noun;
    Sql sql;
    private String lexval;

    //For table, attribute
    Noun(String key, String val){
        type = key;         //table, attribute, count, average, maximum, minimum
        noun = val;
        lexval = val;
        sql = new Sql();
        System.out.println("I am inside Noun | " + type + ":" + val );

        if (key.equals("table")){
//            sql.relation = val;
//            type = "table";
        }
        else if (key.equals("attribute")){
//            type = "attribute";
        }
    }
    
    //For number e.g. Find the number of students
    Noun(String val){
        lexval = val;
        System.out.println("Hello from Noun.java constructor for number/count");

        if (val.equals("number")){
            type = "count";
        }
        if (val.equals("sum")){
            type = "sum";
        }
    }
    
    public String getLexval(){
        return lexval;
    }
    public void setLexval(String l){
        lexval = l;
    }
    public String getType(){
        return type;
    }
    public void setType(String t){
        type = t;
    }

}