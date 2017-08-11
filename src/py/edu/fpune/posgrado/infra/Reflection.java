package py.edu.fpune.posgrado.infra;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Vector;

import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.DataType;
import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.Id;
import py.edu.fpune.posgrado.annotation.Table;
import py.edu.fpune.posgrado.annotation.Transient;

public class Reflection {
	/**
	 * M�todo que valida se uma classe possui as anota��es para ser considerada entidade
	 * @param c
	 * @throws Exception
	 */
	private static void validate(Class<?> c) throws Exception {
		if (!c.isAnnotationPresent(Entity.class)) {
			throw new Exception("Missing @Entity");
		}
		if (!c.isAnnotationPresent(Table.class)) {
			throw new Exception("Missing @Table");
		}
	}
	
	/**
	 * M�todo que devolve o nome da tabela de uma classe
	 * @param c
	 * @return
	 * @throws Exception
	 */
	public static String getTableName(Class <?> c) throws Exception {
		validate(c);
		Table table = c.getAnnotation(Table.class);
		return table.name();
	}
	
	/**
	 * M�todo que retorna o campo que possui o @Id da um classe
	 * @param c
	 * @return
	 * @throws Exception
	 */
	public static Field getIdField(Class<?> c) throws Exception {
		validate(c);
		Field fieldList[] = c.getDeclaredFields();
		for (int i = 0; i < fieldList.length; i++) {
			Field field = fieldList[i];
			if ((field.isAnnotationPresent(Id.class)) &&
				(field.isAnnotationPresent(Column.class))) {
				return field;
			}
		}
		throw new Exception("Missing @Id");
	}
	
	/**
	 * M�todo que devolve o valor de um campo de um objeto
	 * @param field
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Object getFieldValue(Field field,Object obj) throws Exception {
		Class <?> c = obj.getClass();
		Method methodList[] = c.getDeclaredMethods();
		for (int i = 0; i < methodList.length; i++) {
			if (methodList[i].getName().equalsIgnoreCase("get" + field.getName())) {
				return methodList[i].invoke(obj, new Object[0]); 
			}
		}
		throw new Exception("Method get not found");
	}
	
	/**
	 * M�todo set em um determinado campo de um determinado objeto um determinado valor 
	 * @param field
	 * @param obj
	 * @param value
	 * @throws Exception
	 */
	public static void setFieldValue(Field field,Object obj,Object value) throws Exception {
		Class <?> c = obj.getClass();
		Method methodList[] = c.getDeclaredMethods();
		boolean bOk = false;
		for (int i = 0; i < methodList.length; i++) {
			if (methodList[i].getName().equalsIgnoreCase("set" + field.getName())) {
				System.out.println("El valor: "+value+" "+field.getName());
				methodList[i].invoke(obj, value);
				bOk = true;
				break;
			}
		}
		if (!bOk) {
			throw new Exception("Method set not found");
		}
	}
	
	/**
	 * M�todo que devolve o conte�do do atributo que possui @Id no objeto
	 * @param obj
	 * @return
	 * @throws Exception
	 */	
	public static Object getIdFieldValue(Object obj) throws Exception {
		return getFieldValue(getIdField(obj.getClass()), obj);		
	}

	/**
	 * M�todo que seta o conte�do do atributo que possui @Id no objeto
	 * @param obj
	 * @param value
	 * @throws Exception
	 */
	public static void setIdFieldValue(Object obj,Object value) throws Exception {
		setFieldValue(getIdField(obj.getClass()), obj, value);
	}
	
	/**
	 * M�todo que devolve os campos de um objeto
	 * Podem ser todos ou somente os que n�o s�o transientes
	 * @param c
	 * @param bTransient (true = todos)
	 * @return
	 * @throws Exception
	 */
	public static Field[] getFields(Class<?> c, boolean bTransient) throws Exception {
		validate(c);
		Field fieldList[] = c.getDeclaredFields();
		Collection<Field> result = new Vector<Field>();
		for (int i = 0; i < fieldList.length; i++) {
			Field field = fieldList[i];
			if ((field.isAnnotationPresent(Column.class)) &&
				((bTransient) || (!field.isAnnotationPresent(Transient.class)))) {
				result.add(field);
			}
		}
		return (Field[]) result.toArray(new Field[result.size()]);
	}
	
	public static Field getListField(Class<?> c) throws Exception {
		validate(c);
		Field fieldList[] = c.getDeclaredFields();
		for (int i = 0; i < fieldList.length; i++) {
			Field field = fieldList[i];
			Column column = field.getAnnotation(Column.class);
			if ((field.isAnnotationPresent(Column.class))&&(column.type()==DataType.LIST) ) {
				return field;
			}
		}
		throw new Exception("Missing @Column in List");
	}
	public static String getListFieldClassName(Class<?> c) throws Exception {
		validate(c);
		Field fieldList[] = c.getDeclaredFields();
		for (int i = 0; i < fieldList.length; i++) {
			Field field = fieldList[i];
			Column column = field.getAnnotation(Column.class);
			if ((field.isAnnotationPresent(Column.class))&&(column.type()==DataType.LIST) ) {
				return column.classListName();
			}
		}
		throw new Exception("Missing @Column in List");
	}

	

	//public static String getClassListName(Class <?> c) throws Exception {
		
		//Column col = c.getAnnotation(Column.class);
		//return col.classListName();
	//}

}