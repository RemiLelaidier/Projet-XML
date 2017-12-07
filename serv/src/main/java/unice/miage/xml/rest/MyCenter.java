package unice.miage.xml.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import unice.miage.xml.model.Center;

import java.util.ArrayList;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("centers")
public class MyCenter {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Center> getCenterList() {
        ArrayList<Center> centers = new ArrayList<Center>();

        Center c1 = new Center();
        c1.setId(1);
        c1.setName("I3S");
        c1.setLongitude("43.6156381");
        c1.setLatitude("7.0668937");

        Center c2 = new Center();
        c2.setId(2);
        c2.setName("Resus");
        c2.setLongitude("43.6156400");
        c2.setLatitude("7.0668901");
        centers.add(c1);
        centers.add(c2);

        return centers;
    }
}
