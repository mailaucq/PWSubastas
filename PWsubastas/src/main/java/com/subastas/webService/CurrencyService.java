package com.subastas.webService;

import java.net.URL;
import java.util.List;
import java.util.Properties;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceClient;

public class CurrencyService {

	private CurrencyConvertorSoap currencySoap = null; 
	protected BindingProvider bindingProvider =null;
	protected String serviceEndpoint = null;
	
	public static String ENDPOINT = "/currencyconvertor.asmx";
	public static String HOST = "http://www.webservicex.net";
	public static String WEBSERVICES_SCHEMA = "http://www.webserviceX.NET/";
	public static String CURRENCY_SCHEMA = "CurrencyConvertor";
	public static String WSDL_PREFIX = "?WSDL";

	public CurrencyService() throws Exception {
		String serviceEndpoint = CurrencyService.HOST+CurrencyService.ENDPOINT
				+CurrencyService.WSDL_PREFIX;
		//http://www.webservicex.net/currencyconvertor.asmx?WSDL
		
		CurrencyConvertor service = new CurrencyConvertor(new URL(serviceEndpoint),
				new QName(CurrencyService.WEBSERVICES_SCHEMA, CurrencyService.CURRENCY_SCHEMA));
		currencySoap = service.getCurrencyConvertorSoap();
		bindingProvider = (BindingProvider) currencySoap;
	}

	public double conversion(Currency source,Currency target){
		return currencySoap.conversionRate(source, target);
		
	}

	public static void main(String args[]){
		CurrencyService c = null;
		try {
			c = new CurrencyService();
			System.out.println(Currency.USD);
			double conversion = c.conversion(Currency.USD, Currency.PEN);
			System.err.println("conversion: "+conversion);
		} catch (Exception e) {
			System.err.println("Error al conectar");
			//e.printStackTrace();
		}
		

	}
		
}
