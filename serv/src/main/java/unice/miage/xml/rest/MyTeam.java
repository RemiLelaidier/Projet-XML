package unice.miage.xml.rest;

import unice.miage.xml.builder.XQueryBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/teams")
public class MyTeam {

    @GET
    @Path("/list/open")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList getOpen(){
        XQueryBuilder xQueryBuilder = new XQueryBuilder();
        ArrayList result = xQueryBuilder.getTeamsOpen();
        return result;
    }

    @GET
    @Path("/list/close")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList getClose(){
        XQueryBuilder xQueryBuilder = new XQueryBuilder();
        ArrayList result = xQueryBuilder.getTeamsClose();
        return result;
    }
}
