/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterpattern;

import Adapters.ArqueiroAdapter;
import Adapters.GuerreiroAdapter;
import Classes.Asterix;
import Classes.Legolas;
import Classes.Merlin;
import Interfaces.IMago;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio R. Trindade
 */
public class AdapterPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<IMago> exercitoMagos = new ArrayList<>();
        Merlin merlin = new Merlin();
        Asterix asterix = new Asterix();
        Legolas legolas = new Legolas();
        
        exercitoMagos.add(merlin);
        //exercitoMagos.add(asterix); //Não pode ser recrutado porque ele não é um mago
        //exercitoMagos.add(legolas); //Não pode ser recrutado porque ele não é um mago
        
        //Para fingir que o guerreiro e o arqueiro são magos, podemos dar um habito, um chapéu e um cajado pra eles!
        ArqueiroAdapter legolasDisfarcado = new ArqueiroAdapter();
        GuerreiroAdapter asterixFashion = new GuerreiroAdapter();
        
        exercitoMagos.add(legolasDisfarcado);
        exercitoMagos.add(asterixFashion);
        
        for(IMago m : exercitoMagos){
            System.out.println(m.getQuemSouEu() + "ataca: " + m.lancarFeitico());
            System.out.println(m.getQuemSouEu() + "defende: " + m.barreiraMagica());
            System.out.println(" ------------------------------ ");
        }
    }
}
