///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package consumindo_nfe_sp;
//
////import br.com.samuelweb.certificado.Certificado;  
////import br.com.samuelweb.certificado.CertificadoService;  
////import br.com.samuelweb.certificado.exception.CertificadoException;  
////import br.inf.portalfiscal.nfe.wsdl.consStatServ.TConsStatServ;  
////import br.inf.portalfiscal.nfe.schema_4.retConsStatServ.TRetConsStatServ;  
////import br.inf.portalfiscal.nfe_4.wsdl.NFeStatusServico4Stub;  
//import org.apache.axiom.om.OMElement;  
//import org.apache.axiom.om.util.AXIOMUtil;  
//  
//import javax.xml.bind.*;  
//import javax.xml.stream.XMLStreamException;  
//import javax.xml.transform.stream.StreamSource;  
//import java.io.*;  
//import java.rmi.RemoteException;  
//  
///** 
//* @author Samuel Oliveira 
//* 
//*/  
//public class StatusServicoTesteJavac {  
//
//    public static void main(String[] args) {  
//
//        try {  
//  
//            String enderecoWS = "https://homolog.sefaz.go.gov.br/nfe/services/NFeStatusServico4?wsdl";  
//  
//            // Inicializa Certificado Digital  
//            Certificado certificado = CertificadoService.certificadoPfx("C:\\JavaC\\certificado\\Bonilha-cert.pfx", "12345678");  
//            InputStream inputStreamCacert = new FileInputStream(new File("D:\\Java\\util\\Cacert\\Cacert"));  
//            CertificadoService.inicializaCertificado(certificado, inputStreamCacert);  
//  
//            TConsStatServ consStatServ = new TConsStatServ();  
//            consStatServ.setTpAmb("2");  
//            consStatServ.setCUF("52");  
//            consStatServ.setVersao("4.00");  
//            consStatServ.setXServ("STATUS");  
//  
//            String xml = objectToXml(consStatServ);  
//  
//            OMElement ome = AXIOMUtil.stringToOM(xml);  
//  
//            NFeStatusServico4Stub.NfeDadosMsg dadosMsg = new NFeStatusServico4Stub.NfeDadosMsg();  
//            dadosMsg.setExtraElement(ome);  
//  
//            NFeStatusServico4Stub stub = new NFeStatusServico4Stub(enderecoWS);  
//            NFeStatusServico4Stub.NfeResultMsg result = stub.nfeStatusServicoNF(dadosMsg);  
//  
//            TRetConsStatServ retorno =  xmlToObject(result.getExtraElement().toString(), TRetConsStatServ.class);  
//  
//            System.out.println("Status:" + retorno.getCStat());  
//            System.out.println("Motivo:" + retorno.getXMotivo());  
//            System.out.println("Data:" + retorno.getDhRecbto());  
//  
//        } catch (CertificadoException | FileNotFoundException | RemoteException | JAXBException | XMLStreamException e) {  
//            System.err.println(e.getMessage());  
//        }  
//  
//    }  
//  
//    public static <T> T xmlToObject(String xml, Class<T> classe) throws JAXBException {  
//  
//        JAXBContext context = JAXBContext.newInstance(classe);  
//        Unmarshaller unmarshaller = context.createUnmarshaller();  
//  
//        return unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), classe).getValue();  
//    }  
//  
//    public static <T> String objectToXml(Object obj) throws JAXBException {  
//  
//        JAXBContext context = null;  
//        JAXBElement<?> element = null;  
//  
//        context = JAXBContext.newInstance(TConsStatServ.class);  
//        element = new br.inf.portalfiscal.nfe.schema_4.consStatServ.ObjectFactory().createConsStatServ((TConsStatServ) obj);  
//  
//        Marshaller marshaller = context.createMarshaller();  
//  
//        marshaller.setProperty("jaxb.encoding", "Unicode");  
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);  
//        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);  
//  
//        StringWriter sw = new StringWriter();  
//  
//        marshaller.marshal(element, sw);  
//        StringBuilder xml = new StringBuilder();  
//        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(sw.toString());  
//  
//        return xml.toString();  
//  
//    }  
//  
//}  