package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Date;

public class ValidaData {

	public static boolean isDateValid(String strDate) {
	    String dateFormat = "dd/MM/uuuu";

	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
	    .ofPattern(dateFormat)
	    .withResolverStyle(ResolverStyle.STRICT);
	    try {
	        LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
	        return true;
	    } catch (DateTimeParseException e) {
	       return false;
	    } 
	
	
	} 
	
	
	
	public static boolean ValidDtAtu(String data1 ) {  // Valida se a data é maior que a data atual 
		
		
		
		Calendar dataAtual = Calendar.getInstance();

		Integer yy = dataAtual .get(Calendar.YEAR);
		Integer mm = dataAtual .get(Calendar.MONTH) + 1 ;
		Integer dd = dataAtual .get(Calendar.DAY_OF_MONTH);
		
		//Integer tmp = dataAtual.get(Calendar.)
		
		
		
		String hoje=dd+"/"+mm+"/"+yy; 
		//System.out.println(hoje); 

	
	try {
        SimpleDateFormat dateFormat = new 
            SimpleDateFormat ("dd/MM/yyyy");
        Date data = dateFormat.parse(data1);
        Date dtAtu       = dateFormat.parse(hoje);

       
        //System.out.println("Data Atual  : " + 
        //                  dateFormat.format(dtAtu));
        //System.out.println("Data Informada  : " +
        //                   dateFormat.format(data));
        
        
        
        if(dtAtu.before(data)){
           return false  ;
        } 
        else 
        { 
        	return true ; 
        }
	  } catch (ParseException ex) {
		  return false ;
      }	   
	
	
	} 	
	
	//Recebe string no formato dd/mm/yyyy e retorna um sqldate para insert em database 	
	public static java.sql.Date stringTosqlDate(String data1 ) {
		
	
	 //System.out.printf("Data em String %s \n" , data1 ); 
     
     SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
     java.util.Date dtAux1=null;
		try {
			dtAux1 = formato.parse(data1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     //System.out.printf("Formatada para Date ..:%s \n ",  formato.format(dtAux1));
     long timeInMilliSeconds =dtAux1.getTime(); 
     java.sql.Date dtAux2  = new java.sql.Date(timeInMilliSeconds) ; 
     
     //dtAux2=dtAux1.getTime(); 
     //System.out.printf("Formatada para Date ( Sql ) ..:%s \n ",  formato.format(dtAux2));
     
	
	return dtAux2 ; 
	
	} 
	
	
	
	
}
