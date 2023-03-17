/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.mb;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.URLName;
/**
 *
 * @author Note
 */

@ManagedBean
@SessionScoped
public class InicialMB {
	
	public String prepararAcessoRestJson(){
		return "index";
	}
	
	public String prepararAcessoRestXml(){
		return "xml";
	}
        
}

