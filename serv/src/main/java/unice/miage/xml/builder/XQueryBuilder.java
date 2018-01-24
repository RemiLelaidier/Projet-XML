package unice.miage.xml.builder;

import org.inria.fr.ns.cr.Crs;
import org.inria.fr.ns.sr.UrlTeam;

import unice.miage.xml.database.Database;

import java.util.ArrayList;

public class XQueryBuilder {
    private final String xmlDir = "src/main/resources/XML/";
    private final String crsFile = xmlDir + "crs.xml";
    private final String srsFile = xmlDir + "srs.xml";

    private Database database;

    public XQueryBuilder(){
        this.database = new Database();
    }

    /**
     * Get all Research Centers
     * @return 
     */
    public ArrayList getAllCenters(){
        String query = "for $x in doc('" + this.crsFile + "')//crs " +
                "return $x";
        ArrayList result = this.database.iterate(query, "org.inria.fr.ns.cr.Crs");
        return result;
    }
    
    /**
     * Get all informations for centers
     * @param id
     * @return
     */
    public ArrayList<Crs> getCenterInfo(String id) {
    	String query = "declare $search nvarchar(max)"
    			+ "set $search = " + id 
    			+ "for $x in doc('" + this.crsFile + "')//crs " 
    			+ "where ($x/siid = $search)" 
    			+ "return $x";
      System.out.println(id);
    	 ArrayList result = this.database.iterate(query, "org.inria.fr.ns.cr.Crs");
         return result; 
    }
    
    /**
     * Get all opened team
     * @return
     */
    public ArrayList<UrlTeam> geturlTeamOpen() {
    	String query =	 "for $x in doc('" + this.srsFile + "')//srs " 
    					+ "where (current-date() < $date_fermeture)" 
    					+ "return $x";
    	 ArrayList result = this.database.iterate(query, "org.inria.fr.ns.cr.Crs");
         return result; 
    	
    }
    
    /**
     * Get all closed team
     * @return
     */
    public ArrayList<UrlTeam> geturlTeamClose() {
    	String query =	 "for $x in doc('" + this.srsFile + "')//srs " 
    					+ "where (current-date() > $date_fermeture)" 
    					+ "return $x";
    	 ArrayList result = this.database.iterate(query, "org.inria.fr.ns.sr.Srs");
         return result; 
    	
    }
}
