/*
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.xml.bind.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * <p>
 * Maps a Javabean property to a XML Schema attribute. 
 *
 * <p> <b>Usage</b> </p>
 * <p>
 * The <tt>@XmlAttribute</tt> annotation can be used with the
 * following program elements: 
 * <ul> 
 *   <li> Javabean property </li>
 *   <li> public non final, non static field </li>
 * </ul>
 *
 * <p>See "Package Specification" in javax.xml.bind.package javadoc for
 * additional common information.</p>
 *
 * The usage is subject to the following constraints:
 * <ul>
 *   <li> The type of the Javabean property must be mapped to a
 *        XML Schema simple type.</li>
 *   <li> The only other mapping annotations allowed with
 *        <tt>@XmlAttribute</tt> are: <tt>@XmlID</tt></li>
 * </ul>
 * </p>
 *
 * <p> <b>Example: </b>Map a Javabean property to an XML attribute.</p>
 * <pre>
 *     //Example: Code fragment
 *     public class USPrice { 
 *         &#64;XmlAttribute
 *         public java.math.BigDecimal getPrice();
 *         public void setPrice(java.math.BigDecimal );
 *     }
 *
 *     &lt;!-- Example: XML Schema fragment -->
 *     &lt;xs:complexType name="USPrice"/>
 *       &lt;xs:sequence/>
 *       &lt;/xs:sequence/>
 *       &lt;xs:attribute name="price"/>
 *     &lt;xs:simpleType/>
 * </pre>
 *
 * @author Sekhar Vajjhala, Sun Microsystems, Inc.
 * @see XmlType
 * @since JAXB2.0
 */

@Retention(RUNTIME) @Target({FIELD, METHOD})
public @interface XmlAttribute {
    /**
     * Name of the XML Schema attribute. By default, the XML Schema
     * attribute name is derived from the Javabean property name.
     *
     */
    String name() default "";
 
    /**
     * Specifies if the XML Schema attribute is optional or
     * required. If true, then the Javabean property is mapped to a
     * XML Schema attribute that is required. Otherwise it is mapped
     * to a XML Schema attribute that is optional.
     *
     */
     boolean required() default false;

    /**
     * Specifies the XML target namespace of the XML Schema
     * attribute.<b>TBD:</b>
     * 
     */
    String targetNamespace() default "##default" ;
}
