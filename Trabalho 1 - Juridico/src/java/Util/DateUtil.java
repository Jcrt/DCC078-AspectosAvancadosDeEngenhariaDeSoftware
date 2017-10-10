/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author Julio R. Trindade
 */
public class DateUtil {
    
    private static final String DATEFORMATCOMPLETE = "dd/MM/yyyy HH:mm:ss";
    
    private DateUtil(){}
    private DateUtil instance;
    
    public DateUtil getInstance(){
        if(this.instance == null)
            this.instance = new DateUtil();
        return this.instance;
    }
    
    public static String GetCurDate(){
       DateFormat df = new SimpleDateFormat(DateUtil.DATEFORMATCOMPLETE);
       Date date = new java.sql.Date(new java.util.Date().getTime()); 
       return df.format(date);
    }
     
    public static String GetFormattedDate(Date d){
        DateFormat df = new SimpleDateFormat(DateUtil.DATEFORMATCOMPLETE);
        return df.format(d);
    }
}
