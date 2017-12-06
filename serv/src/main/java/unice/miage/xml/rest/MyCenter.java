package unice.miage.xml.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import unice.miage.xml.model.Center;

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
    public Center getCenterList() {
        Center c1 = new Center();
        c1.setId(1);
        c1.setName("I3S");
        c1.setLongitude("43.6156381");
        c1.setLatitude("7.0668937");
        return c1;
    }
}
