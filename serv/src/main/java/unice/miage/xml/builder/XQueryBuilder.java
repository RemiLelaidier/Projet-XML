package unice.miage.xml.builder;

import org.inria.fr.ns.cr.Crs;
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


}
