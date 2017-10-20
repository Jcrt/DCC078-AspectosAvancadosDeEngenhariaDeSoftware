/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Interface.IAction;

/**
 *
 * @author 07228620674
 */
public class ActionFactory {

    public static IAction create(String action) {
        IAction actionObject = null;
        String nomeClasse = "Action." + action + "Action";
        Class classe = null;
        Object objeto = null;
        
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }
        
        if(!(objeto instanceof IAction)) return null;
        
        actionObject = (IAction) objeto;
        return actionObject;
    }
    
}
