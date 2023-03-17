/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumir_correio;

import java.util.List;
import org.omg.PortableServer.LifespanPolicy;
import org.tempuri.CResultado;
import org.tempuri.CServico;

/**
 *
 * @author Note
 */
public class Consumir_Correio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CResultado res = calcPrazo("41106", "19813155", "19820000");
        List<CServico> list =  res.getServicos().getCServico();
        
        for(CServico c : list){
            if (c.getErro().equals("")){
                System.out.println("Prazo de Entrega: " + c.getPrazoEntrega());
                System.out.println("Entrega domiciliar?: " + c.getEntregaDomiciliar());
                System.out.println("Entrega no Sábado?: " + c.getEntregaSabado());
                System.out.println("Prazo Máximo de Entrega: "+ c.getDataMaxEntrega());
            } else {
                System.out.println("Erro do WebService: "+c.getMsgErro());
            }
        }
        
    }

    private static CResultado calcPrazo(java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino) {
        org.tempuri.CalcPrecoPrazoWS service = new org.tempuri.CalcPrecoPrazoWS();
        org.tempuri.CalcPrecoPrazoWSSoap port = service.getCalcPrecoPrazoWSSoap();
        return port.calcPrazo(nCdServico, sCepOrigem, sCepDestino);
    }
    
}
