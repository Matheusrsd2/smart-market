/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadastro_Cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author Laboratorio
 */
public class ConversorStringDate extends 
        org.jdesktop.beansbinding.Converter<String,Date>{

    private SimpleDateFormat df;
    public ConversorStringDate(){
        df = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    @Override
    public Date convertForward(String s) {
        try{
            return new Date (df.parse(s).getTime());
        }catch(ParseException e){
            return null;
        }
    }

    @Override
    public String convertReverse(Date t) {
        return df.format(t);
    }
    
}
