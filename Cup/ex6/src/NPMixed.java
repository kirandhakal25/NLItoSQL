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
public class NPMixed{
    private NP np;
    private PP pp;
    
    NPMixed(NP n, PP p){
        np = n;
        pp = p;
        System.out.println("I am inside NPMixed");
        System.out.println(np.getNoun().getLexval());
        System.out.println(np.getNoun().getType());

        //if the head noun of the phrase is number and is followed by 'of tablename', for instance number of students
        if (np.getNoun().getLexval().equals("number")){
            System.out.println("Hello from NPMixed inside number");
            if (pp.getPreposition().getLexval().equals("of")){
                //if pp -> prep NPMixed
                if(pp.getNPMixed() != null){
                    if (pp.getNPMixed().getNP().getNoun().getType().equals("table")){
                        Sql.select.add("COUNT(*)");
                        Sql.from = pp.getNPMixed().getNP().getNoun().getLexval();
                        if (PreSql.group_by != null){
                            Sql.group_by = PreSql.group_by;
                        }
                    }
                }
                //if pp -> prep NP
                else if(pp.getNP() != null){
                    if (pp.getNP().getNoun().getType().equals("table")){
                        Sql.select.add("COUNT(*)");
                        Sql.from = pp.getNP().getNoun().getLexval();
                    }
                }
            }
        }

        //if the head noun of the phrase is an attribute which is preceeded by average, maximum or minimum
        else if (np.getNoun().getType().equals("attribute") && np.getAdjective() != null){
            System.out.println("Hello from NPMixed constructor inside attribute");
            System.out.println(np.getAdjective().getLexval());
            // if pp -> prep NPMixed
            if(pp.getNPMixed() != null){
                // confirm that the table name exists
                if (pp.getNPMixed().getNP().getNoun().getType().equals("table")){
                    if (np.getAdjective().getLexval().equals("average")){
                        Sql.select.add("AVG(" + np.getNoun().getLexval() + ")");
                        Sql.from = pp.getNPMixed().getNP().getNoun().getLexval();
                    }
                    else if (np.getAdjective().getLexval().equals("minimum")){
                        Sql.select.add("MIN(" + np.getNoun().getLexval() + ")");
                        Sql.from = pp.getNPMixed().getNP().getNoun().getLexval();
                    }
                    else if (np.getAdjective().getLexval().equals("maximum")){
                        Sql.select.add("MAX(" + np.getNoun().getLexval() + ")");
                        Sql.from = pp.getNPMixed().getNP().getNoun().getLexval();

                    }
                    System.out.println("Hello from NPMixed constructor inside average");
                    if (PreSql.group_by != null){
                        Sql.group_by = PreSql.group_by;
                    }
                }
            }
            // if pp -> prep NP
            else if(pp.getNP() != null){
                // confirm that the table name exists
                if (pp.getNP().getNoun().getType().equals("table")){
                    if (np.getAdjective().getLexval().equals("average")){
                        Sql.select.add("AVG(" + np.getNoun().getLexval() + ")");
                        Sql.from = pp.getNP().getNoun().getLexval();
                    }
                    else if(np.getAdjective().getLexval().equals("minimum")){
                        Sql.select.add("MIN(" + np.getNoun().getLexval() + ")");
                        Sql.from = pp.getNP().getNoun().getLexval();
                    }
                    else if(np.getAdjective().getLexval().equals("maximum")){
                        Sql.select.add("MAX(" + np.getNoun().getLexval() + ")");
                        Sql.from = pp.getNP().getNoun().getLexval();
                    }
                    if (PreSql.group_by != null){
                        Sql.group_by = PreSql.group_by;
                    }
                }
            }
        }
        
        //if the head noun of the phrase is sum, e.g. sum of lecture_hours of courses
        else if(np.getNoun().getLexval().equals("sum")){
            //if pp -> prepositoin np_mixed
            if(pp.getNPMixed() != null){
                //if preposition is of and is followed by attribute name, e.g. sum of lecture_hours
                if(pp.getPreposition().getLexval().equals("of") && pp.getNPMixed().getNP().getNoun().getType().equals("attribute")){
                    String lexval = pp.getNPMixed().getNP().getNoun().getLexval();
                    Sql.select.add("SUM(" + lexval + ")");
                    System.out.println("Hi I am ln or ellen or allen or whatever from NPMixed.java");

                    //if the second preposition after the sum is also of and is followed by table_name, 
                    //e.g. sum of lecture_hours of courses
                    if(pp.getNPMixed().getPP().getPreposition().getLexval().equals("of")){
                        //if pp.np_mixed.pp -> preposition np_mixed
                        if(pp.getNPMixed().getPP().getNPMixed().getNP().getNoun().getType().equals("table")){
                            Sql.from = pp.getNPMixed().getPP().getNPMixed().getNP().getNoun().getLexval();
                        }
                        //if pp.np_mixed.pp -> preposition np
                        else if(pp.getNPMixed().getPP().getNP().getNoun().getType().equals("table")){
                            Sql.from = pp.getNP().getNoun().getLexval();
                        }
                    }
                }
            }
            //if pp -> preposition np
            else if(pp.getNP() != null){
                //if preposition is of and is followed by attribute name, e.g. sum of lecture_hours
                if(pp.getPreposition().getLexval().equals("of") && pp.getNP().getNoun().getType().equals("attribute")){
                    String lexval = pp.getNP().getNoun().getLexval();
                    Sql.select.add("SUM(" + lexval + ")");
                }
            }
        }
    }
    
    public NP getNP(){
        return np;
    }
    public void setNP(NP n){
        np = n;
    }
    public PP getPP(){
        return pp;
    }
    public void setPP(PP p){
        pp = p;
    }
}
