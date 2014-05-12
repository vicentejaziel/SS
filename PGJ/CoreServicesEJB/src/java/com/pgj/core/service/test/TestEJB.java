/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.core.service.test;

import com.pgj.core.service.ejb.ProcessServiceEJBRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author pepgonalez
 */
public class TestEJB {
    
    
    public static void main (String args[]){
        
        try {
            Context c = new InitialContext();
            
        ProcessServiceEJBRemote ejb = (ProcessServiceEJBRemote) c.lookup(ProcessServiceEJBRemote.MAPPED_NAME);
            
        ejb.findAllJudgeGroup();
        
        } catch (NamingException ex) {
            Logger.getLogger(TestEJB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
