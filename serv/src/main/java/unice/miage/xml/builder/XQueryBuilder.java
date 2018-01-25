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
        ArrayList result = this.database.iterate(query, "Crs");
        return result;
    }
    
    /**
     * Get all informations for centers
     * @param id
     * @return
     */
    public ArrayList getCenterInfo(String id) {
    	String query = "for $x in doc('" + this.crsFile + "')//crs/cr "
    			+ "where $x/numnatstructrep = '" + id
    			+ "' return $x";
        System.out.println(query);
        ArrayList result = this.database.iterate(query, "Cr");
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

    public ArrayList getTeamsClose() {
        return null;
    }

    public ArrayList getTeamsOpen() {
        return null;
    }
}
