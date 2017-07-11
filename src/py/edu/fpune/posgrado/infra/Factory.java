package py.edu.fpune.posgrado.infra;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.DataType;
import py.edu.fpune.posgrado.annotation.Transient;

public class Factory {

	public static Object[] createByResultSet(ResultSet rst, Class <?> c) throws Exception {
		Field fieldList[] = Reflection.getFields(c, false);
		Collection <Object> result = new Vector <Object> ();
		while (rst.next()) {
			Object obj = c.newInstance();
			for (int i = 0; i < fieldList.length; i++) {
				Column column = fieldList[i].getAnnotation(Column.class);
				Object value = null;
				switch (column.type()) {
					case DataType.BOOLEAN:
						value = rst.getBoolean(column.name());
						break;
					case DataType.CHAR:
						value = rst.getString(column.name());
						break;
					case DataType.DATE:
						value = rst.getDate(column.name());
						break;
					case DataType.DATETIME:
						value = rst.getDate(column.name());
						break;
					case DataType.TIME:
						value = rst.getTime(column.name());
						break;
					case DataType.FLOAT:
						value = rst.getFloat(column.name());
						break;
					case DataType.LONG:
						value = rst.getLong(column.name());
						break;
					case DataType.INTEGER:
						value = rst.getInt(column.name());
						break;
					case DataType.STRING:
						value = rst.getString(column.name());
						break;
					case DataType.OBJECT:
						Integer idFK = rst.getInt(column.name());
						Object objFK = fieldList[i].getType().newInstance();
						Reflection.setIdFieldValue(objFK,idFK);
						value = objFK;					
					default:
						break;
				}
				Reflection.setFieldValue(fieldList[i], obj, value);
			}
			result.add(obj);
		}
		return (Object[]) result.toArray(new Object[result.size()]);
	}

	private static Object getFormatedValue(Field field, String rawValue) {
		Column column = field.getAnnotation(Column.class);
		int type;
		if (column != null) {
			type = column.type();
		} else {
			Transient transientColumn = field.getAnnotation(Transient.class);
			type = transientColumn.type();
		}
		if (rawValue != null) {
			switch (type) {
			case DataType.CHAR:
				if (rawValue.length() > 0) {
					return rawValue.charAt(0);
				}
				break;
			case DataType.STRING:
				return rawValue;
			case DataType.DATE:
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					return sdf.parse(rawValue);
				} catch (Exception e) {
					return null;
				}
			case DataType.TIME:
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					return sdf.parse(rawValue);
				} catch (Exception e) {
					return null;
				}
			case DataType.DATETIME:
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					return sdf.parse(rawValue);
				} catch (Exception e) {
					return null;
				}
			case DataType.BOOLEAN:
				return rawValue.equals("true") || (!rawValue.equals("0") && (!rawValue.equals("false"))); 
			case DataType.INTEGER:
				try {
					return Integer.parseInt(rawValue);
				} catch (Exception e) {
					return null;
				}
			case DataType.LONG:
				try {
					return Long.parseLong(rawValue);
				} catch (Exception e) {
					return null;
				}
			case DataType.FLOAT:
				try {
					return Float.parseFloat(rawValue);
				} catch (Exception e) {
					return null;
				}
			case DataType.OBJECT:
				try {
					Integer id = Integer.parseInt(rawValue);
					Object objFK = field.getType().newInstance();
					Reflection.setIdFieldValue(objFK, id);
					return objFK;				
				} catch (Exception e) {
					return null;
				}
			default:
				break;
			}
		}
		return null;
	}
	
	public static Object createById(Integer id, Class <?> c) throws Exception {
		Object obj = c.newInstance();
		Reflection.setIdFieldValue(obj, id);
		return obj;
	}
	
	public static Object createByPost(HashMap <String,String> postData,  Class<?> c) throws Exception {
		Object obj = c.newInstance();
		Field fields[] = Reflection.getFields(c,true);
		for (Iterator iterator = postData.keySet().iterator(); iterator.hasNext();) {
			String postFieldName = (String) iterator.next();
			for (int i = 0; i < fields.length; i++) {
				if (postFieldName.equalsIgnoreCase(fields[i].getName())) {
					Reflection.setFieldValue(fields[i], obj, getFormatedValue(fields[i], postData.get(postFieldName)));
					break;
				}
			}
		}
		return obj;
	}	
}
