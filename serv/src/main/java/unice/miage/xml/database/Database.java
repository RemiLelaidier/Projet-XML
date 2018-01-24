package unice.miage.xml.database;

import org.basex.core.*;
import org.basex.core.cmd.XQuery;
import org.basex.io.serial.Serializer;
import org.basex.query.QueryException;
import org.basex.query.QueryProcessor;
import org.basex.query.iter.Iter;
import org.basex.query.value.item.Item;
import org.inria.fr.ns.cr.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
    static Context context = new Context();

    public Database(){}

    /**
     * Execute the query and send the result
     * @param query
     * @return
     */
    public String execute(String query){
        String result = null;
        try {
            result = new XQuery(query).execute(context);
        } catch (BaseXException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Crs> iterate(String query){
      return iterate(query, "");
    }

    /**
     * Execute the query given in params then convert result in classType
     * TODO generify
     * @param query String
     * @param classType String must be fully-qualified
     * @return ArrayList
     */
    public ArrayList iterate(String query, String classType){
        try {
            // Create JAXB context and populate the chosen model
            ArrayList result = new ArrayList<>();
            JAXBContext jaxbContext = JAXBContext.newInstance(Class.forName(classType));
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            // Create XQuery context
            QueryProcessor proc = new QueryProcessor(query, context);
            Iter iter = proc.iter();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Serializer ser = proc.getSerializer(baos);
            proc.close();
            // Iterate on the result
            for(Item item; (item = iter.next()) != null;) {
                baos.reset();
                ser.serialize(item);
                // Create the model and add it to result
                Object crs = unmarshaller.unmarshal(new ByteArrayInputStream(baos.toByteArray()));
                result.add(crs);
            }
            return result;

        }catch (QueryException | IOException | JAXBException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }


}
