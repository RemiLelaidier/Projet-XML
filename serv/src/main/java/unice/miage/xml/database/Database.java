package unice.miage.xml.database;

import org.basex.core.*;
import org.basex.core.cmd.XQuery;
import org.basex.query.QueryException;
import org.basex.query.QueryProcessor;
import org.basex.query.iter.Iter;
import org.basex.query.value.item.Item;
import org.inria.fr.ns.cr.*;
import org.inria.fr.ns.sr.*;

import java.util.ArrayList;

public class Database {
    static Context context = new Context();

    public Database(){

    }

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

    /**
     * Iterate
     * @param query
     * @return
     */
    public ArrayList iterate(String query){
        ArrayList result = new ArrayList();
        try {
            QueryProcessor proc = new QueryProcessor(query, context);
            // Store the pointer to the result in an iterator:
            Iter iter = proc.iter();

            // Iterate through all items and serialize
            for(Item item; (item = iter.next()) != null;) {
                result.add(item.toJava());
                System.out.println(item);
            }
        }catch (QueryException e){
            e.printStackTrace();
        }
        return result;
    }


}
