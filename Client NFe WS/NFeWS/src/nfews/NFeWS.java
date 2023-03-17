/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfews;

import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeDadosMsg;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServico2;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServico2Soap12;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServicoNF2Result;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;


/**
 *
 * @author Note
 */
public class NFeWS {

    private static String dados;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String caminhoDoCertificadoDoCliente = "..\\TESTE.pfx";
            String senhaDoCertificadoDoCliente = "12345678";
            String arquivoCacertsGeradoTodosOsEstados = "..\\TESTE\\NFeCacerts";
            
            dados = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                         + "<consStatServ versao=\"3.10\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">"
                            + "<tpAmb>2</tpAmb>"
                            + "<cUF>35</cUF>"
                            + "<xServ>STATUS</xServ>"
                         + "</consStatServ>";

            KeyStore keystore = KeyStore.getInstance(("PKCS12"));
            keystore.load(new FileInputStream(caminhoDoCertificadoDoCliente), senhaDoCertificadoDoCliente.toCharArray());  

//            Enumeration<String> eAliases = keystore.aliases();  
//
//                while (eAliases.hasMoreElements()) {  
//                    String alias = (String) eAliases.nextElement();  
//                    Certificate certificado = (Certificate) keystore.getCertificate(alias);  
//
//                    X509Certificate cert = (X509Certificate) certificado;  
//
//                    info(cert.getSubjectDN().getName());
//                    
//                }  
            
//            nfeStatusServicoNF2(dados);
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
            error(e.toString());
        }
    }

//    @GET
//    @Produces(MediaType.APPLICATION_XML)
    public String getXml(){
        XStream stream = new XStream(new DomDriver());
        return stream.toXML(dados);
    }
    
//    @PUT
//    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    private static NfeStatusServicoNF2Result nfeStatusServicoNF2(NfeDadosMsg nfeDadosMsg) {
        NfeStatusServico2 service = new NfeStatusServico2();
        NfeStatusServico2Soap12 port = service.getNfeStatusServico2Soap12();
        return port.nfeStatusServicoNF2(nfeDadosMsg);
    }
    
    private static void error(String log) {
	System.out.println("ERROR: " + log);
    }
    
    private static void info(String log) {
	System.out.println("INFO: " + log);
    }
    
}
