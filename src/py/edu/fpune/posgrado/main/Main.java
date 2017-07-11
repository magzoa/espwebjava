package py.edu.fpune.posgrado.main;

import java.lang.reflect.Method;

import py.edu.fpune.posgrado.entity.Marca;
import py.edu.fpune.posgrado.entity.Modelo;
import py.edu.fpune.posgrado.session.SessionModelo;


public class Main {
	
	public static void prueba(Object obj, 
			                  String attributeName, Object value) 
								throws Exception {
		Class c = obj.getClass();	
		
//		System.out.println("Atributos");
//		Field listFields[] = c.getDeclaredFields();
//		for (int i = 0; i < listFields.length; i++) {
//			System.out.println(listFields[i].getName());
//		}
//		System.out.println("\nMétodos");
//		Method listMethods[] = c.getDeclaredMethods();
//		for (int i = 0; i < listMethods.length; i++) {
//			System.out.println(listMethods[i].getName());
//		}

//		Field listFields[] = c.getDeclaredFields();
//		for (int i = 0; i < listFields.length; i++) {
//			if (listFields[i].getName().equalsIgnoreCase(attributeName)) {
//				listFields[i].setAccessible(true);
//				listFields[i].set(obj,value);
//				break;
//			}
//		}
		
		
		Method listMethods[] = c.getDeclaredMethods();
		for (int i = 0; i < listMethods.length; i++) {
			if (listMethods[i].getName().
					equalsIgnoreCase("set" + attributeName)) {
				listMethods[i].invoke(obj, value);
			}
		}
	}

	public static void main(String[] args) throws Exception {
//		Class <?> c = Marca.class;
//		
//		if (c.isAnnotationPresent(Entity.class)) {
//			if (c.isAnnotationPresent(Table.class)) {
//				Table table = c.getAnnotation(Table.class);
//				System.out.println("Tabla: " + table.name());				
//			}
//			
//			Field listFields[] = c.getDeclaredFields();
//			for (int i = 0; i < listFields.length; i++) {
//				if (listFields[i].isAnnotationPresent(Column.class)) {
//					Column column = listFields[i].getAnnotation(Column.class);
//					System.out.println("Coluna: " + column.name());					
//				}
//			}
//			
//		}
		
		SessionModelo sessionModelo = new SessionModelo();
		
		Marca marca = new Marca();
		marca.setIdMarca(3);
			
		Modelo modelo = new Modelo();
//		modelo.setIdModelo(2);
		modelo.setDescripcion("O");
//		modelo.setMarca(marca);
		
		Object list[] = sessionModelo.find(modelo);
		for (int i = 0; i < list.length; i++) {
			Modelo m = (Modelo) list[i];
			System.out.println(m);
		}
		
//		System.out.println(sessionModelo.detail(modelo));
	}

}