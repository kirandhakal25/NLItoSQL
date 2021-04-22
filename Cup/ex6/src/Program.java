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
public class Program {
    private Sentence sentence;
    private String select;
    private String group_by;
    
    
    Program(Sentence s){
        sentence = s;
        
        //Convert the ArrayList to String separated with comma and if the result is empty string make it *
        select = String.join(",", Sql.select);
        if (select.equals("")){
            select = "*";
        }        
        Sql.sql = Sql.verb + " " + select + "\nFROM " + Sql.from;
        group_by = String.join(",", Sql.group_by);
        if (!group_by.equals("")){
            Sql.sql = Sql.sql + "\nGROUP BY " + group_by;
        }
        
        System.out.println("Hello from Program.java");
        System.out.println("SELECT");
        System.out.println(Sql.select);
        System.out.print("FROM ");
        System.out.println(Sql.from);
        System.out.print("GROUP BY ");
        System.out.println(Sql.group_by);
    }
    
    public void execute(javax.swing.JTextArea jTextAreaOutput){
        jTextAreaOutput.setText(Sql.sql + "\n");
    }
    
    public Sentence getSentence(){
        return sentence;
    }
}
