package pl.polsl.andrzej.kowol.sort.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation with information about method and author's name.
 * 
 * @author Andrzej Kowol
 * @version 2.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface BubbleSortAnnotation {
    
    /**
     * Information about method.
     * 
     * @return String with information about method.
     */
    String info();
    
    /**
     * Name of the author.
     * 
     * @return String with name of the author.
     */
    String author();
}
