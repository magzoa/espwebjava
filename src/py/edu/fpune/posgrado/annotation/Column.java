package py.edu.fpune.posgrado.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	public String name() default "";
	public short type() default DataType.STRING;
	public int length() default 255;
	
	public boolean orderBy() default false;
	public boolean unique() default false;
	public boolean nullable() default true;
	public boolean insertable() default true;
	public boolean updatable() default true;
}
