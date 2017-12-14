package unice.miage.xml.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.inria.fr.ns.cr.Crs;
import unice.miage.xml.builder.XQueryBuilder;
import unice.miage.xml.model.Center;

import java.util.ArrayList;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/centers")
public class MyCenter {

    /**
     * Return all researchs centers
     *
     * @return JSON
     */
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList getCenterList() {
        XQueryBuilder xQueryBuilder = new XQueryBuilder();
        ArrayList result = xQueryBuilder.getAllCenters();
        return result;
    }

    /**
     * Return all infos about a center
     *
     * TODO : Replace logic
     *
     * @return JSON
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCenterInfo(){
        return "Salut";
    }
}
