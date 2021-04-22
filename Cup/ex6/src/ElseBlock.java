/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
import java.util.ArrayList;

/**
 *
 * @author kirandhakal25
 */
public class ElseBlock {
    private Expr expr;
    private ArrayList<Stmt> stmt_list;
    private String prefix;
    
    public Expr get_expr(){
        return expr;
    }
    
    public ArrayList<Stmt> get_stmt_list(){
        return stmt_list;
    }
    
    public String get_prefix(){
            return prefix;
    }

    //This is used by elseif blocks
    ElseBlock(Expr e, ArrayList<Stmt> sl){
        expr = e;
        stmt_list = sl;
        
        //calculate prefix
        prefix = expr.get_prefix() + " { ";
        for (Stmt s : sl){
            prefix = prefix + "\n\t" + s.get_prefix();
        }
        prefix = prefix + "\n}";


        
    }

    //This is used by else block
    ElseBlock(ArrayList<Stmt> sl){
        stmt_list = sl;
        
        //calculate prefix
        prefix = "{ ";
        for (Stmt s : sl){
            prefix = prefix + "\n\t" + s.get_prefix();
        }
        prefix = prefix + "\n}";
        
    }
}
