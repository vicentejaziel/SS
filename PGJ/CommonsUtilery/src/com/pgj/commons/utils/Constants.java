/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.commons.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pepgonalez
 */
public class Constants implements Serializable{
    
    public static final Integer MAX_NO_VALUE = 6;
    
    
    public static List<Integer> getNoList(){
        List<Integer> values = new ArrayList<Integer>();
        
        for (int i = 1; i <= Constants.MAX_NO_VALUE; i++){
            values.add(i);
        }
        return values;
    }
    
}
