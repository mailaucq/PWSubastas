package com.subastas.webService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fromCurrency",
    "toCurrency"
})
@XmlRootElement(name = "ConversionRate")
public class ConversionRate {

    @XmlElement(name = "FromCurrency", required = true)
    protected Currency fromCurrency;
    @XmlElement(name = "ToCurrency", required = true)
    protected Currency toCurrency;

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency value) {
        this.fromCurrency = value;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency value) {
        this.toCurrency = value;
    }

}
