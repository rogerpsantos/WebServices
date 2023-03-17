/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumindo_nfe_sp;


import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;

public class ValidadeCertificadoDigitalA1 {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static void main(String[] args) {
		
		try {
//			String caminhoDoCertificadoDoCliente = "C:/JavaC/certificado/certificadoDoCliente.pfx";
//            String senhaDoCertificadoDoCliente = "1234";
            //String caminhoDoCertificadoDoCliente = "C:\\JavaC\\certificado\\Certificado_Digital_NFe 2016_MM_Cofap.pfx";
            //String senhaDoCertificadoDoCliente = "nfemmcofap";
            
//            String caminhoDoCertificadoDoCliente = "C:/JavaC/certificado/Backup Certificado Digital NFe 2017 - MM Cofap.pfx";  
//            String senhaDoCertificadoDoCliente = "nfemmc2017";
//            String arquivoCacertsGeradoParaCadaEstado = "C:/JavaC/nfe-cacerts/NFeCacerts";
//            
            
            
            String caminhoDoCertificadoDoCliente = "C://JavaC//certificado//WB.pfx";  
            String senhaDoCertificadoDoCliente = "1234";
            String arquivoCacertsGeradoParaCadaEstado = "C:/JavaC/nfe-cacerts/NFeCacerts";
            
            
//            String caminhoDoCertificadoDoCliente = "C:\\JavaC\\certificado\\Bonilha-cert.pfx";
//            String senhaDoCertificadoDoCliente = "12345678";
//            String arquivoCacertsGeradoTodosOsEstados = "C:/JavaC/nfe-cacerts/NFeCacerts";
//            
		    KeyStore keystore = KeyStore.getInstance(("PKCS12"));
                    keystore.load(new FileInputStream(caminhoDoCertificadoDoCliente), senhaDoCertificadoDoCliente.toCharArray());  
                    //KeyStore ks = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
		    
		  
		    Enumeration<String> eAliases = keystore.aliases();  

		    while (eAliases.hasMoreElements()) {  
		        String alias = (String) eAliases.nextElement();  
		        Certificate certificado = (Certificate) keystore.getCertificate(alias);  
		  
                        certificado.getPublicKey();
		        info("Aliais teste: " + alias.toString());
		        X509Certificate cert = (X509Certificate) certificado;  
		        
                        
                        
		        info(cert.getSubjectDN().getName());
		        info("Válido a partir de..: " + dateFormat.format(cert.getNotBefore()));
		        info("Válido até..........: " + dateFormat.format(cert.getNotAfter())); 
                        info("CNPJ:...............: "+ cert.getIssuerUniqueID());
                        info(cert.getIssuerDN().toString());
                        info(cert.getSigAlgName().toString());
                        info(cert.getSigAlgOID().toString());
                        info(cert.getPublicKey().toString());
                        info(cert.getSerialNumber().toString());
                        info(cert.getPublicKey().toString());
                        info(cert.getExtendedKeyUsage().toString());
                        info(cert.getCriticalExtensionOIDs().toString());
                        info(cert.getEncoded().toString());
                        System.out.println(cert.hashCode());
                        info(cert.getKeyUsage().toString());
                        info(cert.getSubjectAlternativeNames().toString());
                        info(cert.getTBSCertificate().toString());
                        info(cert.getIssuerX500Principal().toString());                       
  
  
		    }  
		} catch (Exception e) {
			error(e.toString());
		}
	}

	/**
	 * Error.
	 * @param log
	 */
	private static void error(String log) {
		System.out.println("ERROR: " + log);
	}

	/**
	 * Info
	 * @param log
	 */
	private static void info(String log) {
		System.out.println("INFO: " + log);
	}
	
}
