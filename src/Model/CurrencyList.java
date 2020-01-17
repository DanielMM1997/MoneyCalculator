package Model;

import java.util.*;

public final class CurrencyList {

    private final List<Currency> currencies;
    
    public CurrencyList() {
        currencies = new ArrayList<>();
        currencies.add(new Currency("GBP", "Libra", "£"));
        currencies.add(new Currency("PLN", "Zloty polaco", "zł"));
        currencies.add(new Currency("USD", "Dolar", "$"));
        currencies.add(new Currency("KRW", "Won surcoreano", "₩"));
    }
    
    public List<Currency> getCurrencies() {
        return currencies;
    }
    
    public void add(Currency currency) {
        currencies.add(currency);
    }

    public List<Currency> getList() {
        return currencies;
    }
}