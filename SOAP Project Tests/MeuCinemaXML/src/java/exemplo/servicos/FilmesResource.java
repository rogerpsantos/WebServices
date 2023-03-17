/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.servicos;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import exemplo.modelo.Filme;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;



/**
 * REST Web Service
 *
 * @author Note
 */
@Path("filmes")
public class FilmesResource {

    private List<Filme> filmes;

    /**
     * Creates a new instance of FilmesResource
     */
    public FilmesResource() {
        filmes = new ArrayList<Filme>();
        filmes.add(new Filme(1L, "<font color='white'>Deadpool</font>", "<font color='white'>Ex-militar e mercenário, Wade Wilson (Ryan Reynolds) é diagnosticado com câncer em estado terminal, porém encontra uma possibilidade de cura em uma sinistra experiência científica. Recuperado, com poderes e um incomum senso de humor, ele torna-se Deadpool e busca vingança contra o homem que destruiu sua vida.</font>", "<font color='white'>Ação, Fantasia</font>", "<font color='white'>200 min.</font>", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/Q9X-bAE8KTc\" frameborder=\"0\" allowfullscreen></iframe>"));
        filmes.add(new Filme(2L, "<font color='white'>Batman Vs Superman - A Origem da Justiça</font>", "<font color='white'>Após os eventos de O Homem de Aço, Superman (Henry Cavill) divide a opinião da população mundial. Enquanto muitos contam com ele como herói e principal salvador, vários outros não concordam com sua permanência no planeta. Bruce Wayne (Ben Affleck) está do lado dos inimigos de Clark Kent e decide usar sua força de Batman para enfrentá-lo. Enquanto os dois brigam, porém, uma nova ameaça ganha força.</font>", "<font color='white'>Ação, Fantasia, Aventura</font>", "<font color='white'>250 min.</font>", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/IHDgrNxO-5I\" frameborder=\"0\" allowfullscreen></iframe>"));
        filmes.add(new Filme(3L, "<font color='white'>Homem-Formiga</font>", "<font color='white'>Dr. Hank Pym (Michael Douglas), o inventor da fórmula/ traje que permite o encolhimento, anos depois da descoberta, precisa impedir que seu ex-pupilo Darren Cross (Corey Stoll), consiga replicar o feito e vender a tecnologia para uma organização do mal. Depois de sair da cadeia, o trambiqueiro Scott Lang (Paul Rudd) está disposto a reconquistar o respeito da ex-mulher, Maggie (Judy Greer) e, principalmente, da filha. Com dificuldades de arrumar um emprego honesto, ele aceita praticar um último golpe. O que ele não sabia era que tudo não passava de um plano do Dr. Pym que, depois de anos observando o hábil ladrão, o escolhe para vestir o traje do Homem-Formiga.</font>", "<font color='white'>Ação, Ficção Científica</font>", "<font color='white'>157 min.</font>", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/wITUolzfkwI\" frameborder=\"0\" allowfullscreen></iframe>"));
        filmes.add(new Filme(4L, "<font color='white'>O Último Caçador de Bruxas</font>", "<font color='white'>Amaldiçoado com a imortalidade, o caçador de bruxas Kaulder (Vin Diesel) é obrigado a enfrentar mais uma vez sua maior inimiga e unir forças com a jovem bruxa Chloe (Rose Leslie) para impedir que uma convenção espalhe uma terrível praga pela cidade.</font>", "<font color='white'>Fantasia, Ação</font>", "<font color='white'>147 min.</font>", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/gfzJmsFb_Lo\" frameborder=\"0\" allowfullscreen></iframe>"));
    }

    /**
     * Retrieves representation of an instance of exemplo.servicos.FilmesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(){
        XStream stream = new XStream(new DomDriver());
        return stream.toXML(filmes);
    }
    
    /**
     * PUT method for updating or creating an instance of FilmesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
