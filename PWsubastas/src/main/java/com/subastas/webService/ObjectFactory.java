
package com.subastas.webService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Double_QNAME = new QName("http://www.webserviceX.NET/", "double");

    public ObjectFactory() {
    }

    public ConversionRate createConversionRate() {
        return new ConversionRate();
    }

    public ConversionRateResponse createConversionRateResponse() {
        return new ConversionRateResponse();
    }

    @XmlElementDecl(namespace = "http://www.webserviceX.NET/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

}
