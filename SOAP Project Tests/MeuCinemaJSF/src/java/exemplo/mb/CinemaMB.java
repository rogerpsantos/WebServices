package exemplo.mb;

import exemplo.modelo.Filme;
import java.util.List;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.faces.bean.ManagedBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author Note
 */

@ManagedBean
public class CinemaMB {
    public List<Filme> getFilmesEmCartaz(){
        Client c = Client.create();
        WebResource wr = c.resource("http://localhost:8080/MeuCinema/webresources/filmes/");
        String json = wr.get(String.class);
        
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<Filme>>(){}.getType());
    }
    
}
