/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumindo_nfe_sp;

import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeDadosMsg;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServico2;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServico2Soap12;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServicoNF2Result;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.ObjectFactory;
import java.rmi.RemoteException;
import java.security.Security;
import javax.xml.stream.XMLStreamException;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;

/**
 *
 * @author Note
 */
public class Consumindo_Nfe_Sp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AxisFault, RemoteException, XMLStreamException {
        try {  
            /** 
             * 1) caminhoDoCertificadoDoCliente = Caminho do Certificado do Cliente (A1). 
             * 
             * 2) senhaDoCertificadoDoCliente = Senha do Certificado A1 do Cliente. 
             * 
             * 3) arquivoCacertsGeradoParaCadaEstado = Arquivo com os Certificados necessarios para 
             * acessar o WebService. Pode ser gerado com a Classe NFeBuildAllCacerts. 
             */  
            String caminhoDoCertificadoDoCliente = "C:/JavaC/certificado/Roger.pfx";  
            String senhaDoCertificadoDoCliente = "12345678";
            String arquivoCacertsGeradoParaCadaEstado = "C:/JavaC/nfe-cacerts/NFeCacerts";
            
            System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");  
            /** 
             * Informações do Certificado Digital. 
             */  
            System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");  
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());              
  
            System.setProperty("javax.net.ssl.keyStoreType", "PKCS12"); 
  
            System.clearProperty("javax.net.ssl.keyStore");  
            System.clearProperty("javax.net.ssl.keyStorePassword");  
            System.clearProperty("javax.net.ssl.trustStore");  
  
            System.setProperty("javax.net.ssl.keyStore", caminhoDoCertificadoDoCliente);  
            System.setProperty("javax.net.ssl.keyStorePassword", senhaDoCertificadoDoCliente);  
  
            System.setProperty("javax.net.ssl.trustStoreType", "JKS");  
            System.setProperty("javax.net.ssl.trustStorep", arquivoCacertsGeradoParaCadaEstado);  
            
            StringBuilder xml = new StringBuilder();  
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")  
                .append("<consStatServ versao=\"3.10\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">")  
                .append("<tpAmb>2</tpAmb>")  
                .append("<cUF>")  
                .append(35)  
                .append("</cUF>")  
                .append("<xServ>STATUS</xServ>")  
                .append("</consStatServ>");  
      
            OMElement ome = AXIOMUtil.stringToOM(xml.toString());  
            NfeDadosMsg dadosMsg = new NfeDadosMsg();  
            dadosMsg.setExtraElement(ome);  
            
            NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();  
            /** 
             * Código do Estado. 
             */  
            nfeCabecMsg.setCUF("35");  
      
            /** 
             * Versão do XML 
             */  
            nfeCabecMsg.setVersaoDados("3.10");  
            NfeCabecMsg nfeCabecMsgE = new NfeCabecMsg();  
//            nfeCabecMsgE.(nfeCabecMsg);  
            String url = "https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeStatusServico2.asmx";
//            NfeStatusServico2 stub = new NfeStatusServico2(url.toString());  
//            NfeStatusServicoNF2Result result = nfeStatusServicoNF2(dadosMsg, nfeCabecMsgE);  
            
//            info("Estado " + "35" + ": XML = " + result.getExtraElement().toString());  
        } catch (Exception e) {  
            error(e.toString());  
        }  
    }

    private static void error(String log) {  
        System.out.println("ERROR: " + log);  
    } 

    private static void info(String log) {  
        System.out.println("INFO: " + log);  
    }  

    private static NfeStatusServicoNF2Result nfeStatusServicoNF2(br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeDadosMsg nfeDadosMsg) {
        br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServico2 service = new br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServico2();
        br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServico2Soap12 port = service.getNfeStatusServico2Soap12();
        return port.nfeStatusServicoNF2(nfeDadosMsg);
    }
    
}
