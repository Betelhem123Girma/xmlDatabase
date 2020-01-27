/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ixj.xquery;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Node;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nux.xom.xquery.XQueryUtil;

/**
 *
 * @author cibervn
 */
public class FilterCDUsingXQuery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Document document = new Builder().build(new File("student_list.xml"));
            
            String query = "//STUDENT[GRADE > 3]/NAME";
            Nodes nodesResults = XQueryUtil.xquery(document, query);
            
            for (int i = 0; i < nodesResults.size(); i++) {
                Node node = nodesResults.get(i);
                System.out.println(node.getValue());
            }
        } catch (ParsingException | IOException ex) {
            Logger.getLogger(FilterCDUsingXQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
