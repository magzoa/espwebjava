package py.edu.fpune.posgrado.util;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class ManejadorFecha {
	private static java.sql.Date fechaSQL;
	private static java.util.Date fechaUtil;
	
	
	
	public static java.sql.Date stringADateSQL(String fecha){
		fechaSQL = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fechaSQL = new java.sql.Date(formatter.parse(fecha).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaSQL;
	}
	
	
	public static String dateSQLAString(java.sql.Date fecha){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
		String fechaString = df.format(fecha);
		return fechaString; 
	}
	
	public static String fechaActual(){
		java.util.Date utilDate = new java.util.Date();
		long lnMilisegundos = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
		String fechaString = df.format(sqlDate);
		return fechaString;
	}




	public static java.util.Date dateSQLAdateUtil(java.sql.Date fechaSQL){
		java.util.Date utilDate = new java.util.Date(fechaSQL.getTime()); 
		return utilDate;
	}
	
	public static java.sql.Date dateUtilAdateSQL(java.util.Date fechaUtil){
		java.sql.Date dateSQL = new java.sql.Date(fechaUtil.getTime()); 
		return dateSQL;
	}
	
	public static java.util.Date stringADateUtil(String fecha){
		fechaUtil = null;//yyyy-MM-dd  dd/MM/yyyy
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechaUtil = new java.util.Date(formatter.parse(fecha).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaUtil;
	}
	
	
	public static String dateUtilAString(java.util.Date fecha){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
		String fechaString = df.format(fecha);
		return fechaString; 
	}
	
	public static String dateUtilAStringFrances(java.util.Date fecha){
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	
		String fechaString = df.format(fecha);
		return fechaString; 
	}
	
	
	

}
