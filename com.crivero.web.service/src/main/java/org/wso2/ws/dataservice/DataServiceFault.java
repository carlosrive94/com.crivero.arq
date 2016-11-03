
package org.wso2.ws.dataservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="current_params" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="current_request_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nested_exception" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="source_data_service">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="default_namespace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="data_service_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ds_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "currentParams",
    "currentRequestName",
    "nestedException",
    "sourceDataService",
    "dsCode"
})
@XmlRootElement(name = "DataServiceFault")
public class DataServiceFault {

    @XmlElement(name = "current_params", required = true)
    protected String currentParams;
    @XmlElement(name = "current_request_name", required = true)
    protected String currentRequestName;
    @XmlElement(name = "nested_exception", required = true)
    protected String nestedException;
    @XmlElement(name = "source_data_service", required = true)
    protected DataServiceFault.SourceDataService sourceDataService;
    @XmlElement(name = "ds_code", required = true)
    protected String dsCode;

    /**
     * Obtiene el valor de la propiedad currentParams.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentParams() {
        return currentParams;
    }

    /**
     * Define el valor de la propiedad currentParams.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentParams(String value) {
        this.currentParams = value;
    }

    /**
     * Obtiene el valor de la propiedad currentRequestName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentRequestName() {
        return currentRequestName;
    }

    /**
     * Define el valor de la propiedad currentRequestName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentRequestName(String value) {
        this.currentRequestName = value;
    }

    /**
     * Obtiene el valor de la propiedad nestedException.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNestedException() {
        return nestedException;
    }

    /**
     * Define el valor de la propiedad nestedException.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNestedException(String value) {
        this.nestedException = value;
    }

    /**
     * Obtiene el valor de la propiedad sourceDataService.
     * 
     * @return
     *     possible object is
     *     {@link DataServiceFault.SourceDataService }
     *     
     */
    public DataServiceFault.SourceDataService getSourceDataService() {
        return sourceDataService;
    }

    /**
     * Define el valor de la propiedad sourceDataService.
     * 
     * @param value
     *     allowed object is
     *     {@link DataServiceFault.SourceDataService }
     *     
     */
    public void setSourceDataService(DataServiceFault.SourceDataService value) {
        this.sourceDataService = value;
    }

    /**
     * Obtiene el valor de la propiedad dsCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsCode() {
        return dsCode;
    }

    /**
     * Define el valor de la propiedad dsCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsCode(String value) {
        this.dsCode = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="default_namespace" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="data_service_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "location",
        "defaultNamespace",
        "description",
        "dataServiceName"
    })
    public static class SourceDataService {

        @XmlElement(required = true)
        protected String location;
        @XmlElement(name = "default_namespace", required = true)
        protected String defaultNamespace;
        @XmlElement(required = true)
        protected String description;
        @XmlElement(name = "data_service_name", required = true)
        protected String dataServiceName;

        /**
         * Obtiene el valor de la propiedad location.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocation() {
            return location;
        }

        /**
         * Define el valor de la propiedad location.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocation(String value) {
            this.location = value;
        }

        /**
         * Obtiene el valor de la propiedad defaultNamespace.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDefaultNamespace() {
            return defaultNamespace;
        }

        /**
         * Define el valor de la propiedad defaultNamespace.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDefaultNamespace(String value) {
            this.defaultNamespace = value;
        }

        /**
         * Obtiene el valor de la propiedad description.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Define el valor de la propiedad description.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * Obtiene el valor de la propiedad dataServiceName.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDataServiceName() {
            return dataServiceName;
        }

        /**
         * Define el valor de la propiedad dataServiceName.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDataServiceName(String value) {
            this.dataServiceName = value;
        }

    }

}
