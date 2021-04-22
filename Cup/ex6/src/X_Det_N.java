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
public class X_Det_N {
    private String sql;
    private String type;            //values = column, table
    
//    X_Det_N(Det d, String noun){
//        if (noun == "details"){
//            sql = "* ";
//            type = "column";
//        }
//        else{
//            sql = "FROM "+ noun;
//            type = "table";
//        }
//    }
//    
    public String get_sql(){
        return sql;
    }
}
