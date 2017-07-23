package py.edu.fpune.posgrado.infra;

import java.lang.reflect.Field;

import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.DataType;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;

public class Query {
	
	private static String getIdFieldName(Object obj) throws Exception  {
		Field field = Reflection.getIdField(obj.getClass());
		Column column = field.getAnnotation(Column.class);
		return column.name();
	}
	//Agregando Double por Magno
	private static String getFieldFormatedValue(Field field,Object obj) throws Exception {
		Column column = field.getAnnotation(Column.class);
		Object value = Reflection.getFieldValue(field, obj); 
		if (value != null) {
			if ((column.type() == DataType.BOOLEAN) ||
				(column.type() == DataType.INTEGER) ||
				(column.type() == DataType.LONG) ||
				(column.type() == DataType.FLOAT)||
				(column.type() == DataType.DOUBLE))
			{
				return String.valueOf(value);
			} else if (column.type() == DataType.OBJECT) {
				Object idFK = Reflection.getIdFieldValue(value);
				if (idFK == null) {
					return "null";
				} else {
					return String.valueOf(idFK);
				}
			} else {
				return "'" +((String) value).replace("'","").trim() + "'";
			}
		} else {
			return "null";
		}
	}
	
	private static String getFieldNames(Object obj, Boolean bId) throws Exception {
		Field fieldList[] = Reflection.getFields(obj.getClass(), false);
		String result = "";
		Boolean bFirst = true;
		for (int i = 0; i < fieldList.length; i++) {			
			if ((bId) ||
			    ((!fieldList[i].isAnnotationPresent(Id.class)) &&
			     (!fieldList[i].isAnnotationPresent(GeneratedValue.class)))) {
				Column column = fieldList[i].getAnnotation(Column.class);
				if (bFirst) {
					result = column.name();
					bFirst = false;
				} else {
					result += "," + column.name();
				}
			}
		}
		return result;
	}
	
	private static String getFieldValues(Object obj,Boolean bId) throws Exception {
		Field fieldList[] = Reflection.getFields(obj.getClass(), false);
		String result = "";
		Boolean bFirst = true;
		for (int i = 0; i < fieldList.length; i++) {			
			if ((bId) ||
			    ((!fieldList[i].isAnnotationPresent(Id.class)) &&
			     (!fieldList[i].isAnnotationPresent(GeneratedValue.class)))) {
				String sFieldValue = getFieldFormatedValue(fieldList[i], obj);
				if (bFirst) {
					result = sFieldValue;
					bFirst = false;
				} else {
					result += "," + sFieldValue;
				}
			}
		}
		return result;
	}
	
	private static String getFieldNamesValues(Object obj,Boolean bId) throws Exception {
		Field fieldList[] = Reflection.getFields(obj.getClass(), false);
		String result = "";
		Boolean bFirst = true;
		for (int i = 0; i < fieldList.length; i++) {			
			if ((bId) ||
			    ((!fieldList[i].isAnnotationPresent(Id.class)) &&
			     (!fieldList[i].isAnnotationPresent(GeneratedValue.class)))) {
				Column column = fieldList[i].getAnnotation(Column.class);
				String sFieldValue = getFieldFormatedValue(fieldList[i], obj);
				if (bFirst) {
					result = column.name() + " = " + sFieldValue;
					bFirst = false;
				} else {
					result += "," + column.name() + " = " + sFieldValue;
				}
			}
		}
		return result;
	}

	private static String getSQLWhere(Object obj) throws Exception {
		Field fields[] = Reflection.getFields(obj.getClass(),false);
		String result = "";
		Boolean bFirst = true;		
		for (int i = 0; i < fields.length; i++) {
			Column column = fields[i].getAnnotation(Column.class);
			Object value = Reflection.getFieldValue(fields[i],obj);
			String sField = "";
			if ((value != null) &&
				(!value.equals(""))) {
				if ((column.type() == DataType.BOOLEAN) ||
					(column.type() == DataType.INTEGER) ||
					(column.type() == DataType.LONG) ||
					(column.type() == DataType.FLOAT)) {
					sField = " = " + String.valueOf(value);
				} else if (column.type() == DataType.OBJECT) {
					Object idFK = Reflection.getIdFieldValue(value);
					if (idFK == null) {
						continue;
					} else {
						sField = " = " + String.valueOf(idFK);
					}
				} else if (column.type() == DataType.STRING) {
					String sValue = String.valueOf(value).replace("'","");
					sField = " like '%" + String.valueOf(sValue.replace(' ', '%')) + "%'";
				} else {
					sField = " = '" + String.valueOf(value) + "'";
				}

				if (bFirst) {
					result = " where " + column.name() + sField;
					bFirst = false;
				} else {
					result += " and " + column.name() + sField;
				}
			}
		}
		return result;
	}
	
	private static String getSQLOrderBy(Object obj) throws Exception {
		Field fieldList[] = Reflection.getFields(obj.getClass(), false);
		String result = "";
		Boolean bFirst = true;
		for (int i = 0; i < fieldList.length; i++) {			
			Column column = fieldList[i].getAnnotation(Column.class);
			if (column.orderBy()) {
				if (bFirst) {
					result = " order by " + column.name();
					bFirst = false;
				} else {
					result += ", " + column.name();
				}
			}
		}
		return result;
	}
	
	public static String getSQLInsert(Object obj) throws Exception {
		return "insert into " + 
	           Reflection.getTableName(obj.getClass()) +
	           " (" + getFieldNames(obj,false) + ")" +
	           " values(" + getFieldValues(obj,false) + ")";
	}

	public static String getSQLUpdate(Object obj) throws Exception {
		return "update " + Reflection.getTableName(obj.getClass()) +
			   " set " + getFieldNamesValues(obj, false) +
			   " where " + getIdFieldName(obj) + " = " + 
			              Reflection.getIdFieldValue(obj);
	}
	
	public static String getSQLDelete(Object obj) throws Exception {
		return "delete from " + 
	           Reflection.getTableName(obj.getClass()) +
			   " where " + getIdFieldName(obj) + " = " + 
    		              Reflection.getIdFieldValue(obj);
	}
	
	public static String getSQLSelect(Object obj) throws Exception {
		return "select " + getFieldNames(obj,true) + 
				" from " + Reflection.getTableName(obj.getClass()) +
				getSQLWhere(obj) + 
				getSQLOrderBy(obj);
	}
}
