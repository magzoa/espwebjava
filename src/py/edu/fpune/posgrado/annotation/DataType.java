package py.edu.fpune.posgrado.annotation;

public @interface DataType {
	public static short CHAR = 0;
	public static short STRING = 1;
	public static short DATE = 2;
	public static short TIME = 3;
	public static short DATETIME = 4;
	public static short BOOLEAN = 5;	
	public static short INTEGER = 6;
	public static short LONG = 7;	
	public static short FLOAT = 8;
	public static short OBJECT = 9; //Para Foreign Keys
	public static short DOUBLE = 10;
}
