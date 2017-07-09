
package com.subastas.webService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "CurrencyConvertor", targetNamespace = "http://www.webserviceX.NET/", wsdlLocation = "file:/home/rene/V\u00eddeos/projectDataGenerator/wsdl/currencyconvertor.wsdl")
public class CurrencyConvertor
    extends Service
{

    private final static URL CURRENCYCONVERTOR_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.subastas.webService.CurrencyConvertor.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.subastas.webService.CurrencyConvertor.class.getResource(".");
            url = new URL(baseUrl, "file:/home/rene/V\u00eddeos/projectDataGenerator/wsdl/currencyconvertor.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/home/rene/V\u00eddeos/projectDataGenerator/wsdl/currencyconvertor.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        CURRENCYCONVERTOR_WSDL_LOCATION = url;
    }

    public CurrencyConvertor(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CurrencyConvertor() {
        super(CURRENCYCONVERTOR_WSDL_LOCATION, new QName("http://www.webserviceX.NET/", "CurrencyConvertor"));
    }

    @WebEndpoint(name = "CurrencyConvertorSoap")
    public CurrencyConvertorSoap getCurrencyConvertorSoap() {
        return super.getPort(new QName("http://www.webserviceX.NET/", "CurrencyConvertorSoap"), CurrencyConvertorSoap.class);
    }

    @WebEndpoint(name = "CurrencyConvertorSoap")
    public CurrencyConvertorSoap getCurrencyConvertorSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.webserviceX.NET/", "CurrencyConvertorSoap"), CurrencyConvertorSoap.class, features);
    }

}
