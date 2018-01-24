package unice.miage.xml.rest;

import unice.miage.xml.builder.XQueryBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.inria.fr.ns.sr.UrlTeam;

import unice.miage.xml.builder.XQueryBuilder;

import java.util.ArrayList;

@Path("/teams")
public class MyTeam {

    @GET
    @Path("/list/open")
    @Produces(MediaType.APPLICATION_JSON)
<<<<<<< HEAD
    public ArrayList<UrlTeam> geturlTeamOpen(){
        XQueryBuilder xQueryBuilder = new XQueryBuilder(); 
        ArrayList<UrlTeam> result = xQueryBuilder.geturlTeamOpen();
=======
    public ArrayList getOpen(){
        XQueryBuilder xQueryBuilder = new XQueryBuilder();
        ArrayList result = xQueryBuilder.getTeamsOpen();
>>>>>>> b7ad806f50877ad41fb0e97d05824ed76932f0fd
        return result;
    }

    @GET
    @Path("/list/close")
    @Produces(MediaType.APPLICATION_JSON)
<<<<<<< HEAD
    public ArrayList<UrlTeam> geturlTeamClose(){
        XQueryBuilder xQueryBuilder = new XQueryBuilder(); 
        ArrayList<UrlTeam> result = xQueryBuilder.geturlTeamOpen();
=======
    public ArrayList getClose(){
        XQueryBuilder xQueryBuilder = new XQueryBuilder();
        ArrayList result = xQueryBuilder.getTeamsClose();
>>>>>>> b7ad806f50877ad41fb0e97d05824ed76932f0fd
        return result;
    }
}
