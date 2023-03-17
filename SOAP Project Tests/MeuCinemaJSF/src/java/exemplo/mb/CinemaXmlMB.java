/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.mb;

import com.google.gson.reflect.TypeToken;
import exemplo.modelo.Filme;
import java.util.List;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author Note
 */
@ManagedBean
public class CinemaXmlMB {
    public Object getFilmesEmCartaz(){
        Client c = Client.create();
        WebResource wr = c.resource("http://localhost:8080/MeuCinemaXML/webresources/filmes");
        String xml = wr.get(String.class);
        
        XStream xstream = new XStream(new DomDriver());
        return xstream.fromXML(xml, new TypeToken<List<Filme>>(){}.getType());
    }
}
