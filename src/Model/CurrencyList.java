package Model;

import java.util.ArrayList;
import java.util.List;


public final class CurrencyList {

    private final ArrayList<Currency> currencies;
    
    public CurrencyList() {
        currencies = new ArrayList<>();
    }
    
    public List<Currency> getCurrencies() {
        return currencies;
    }
    
    public void add(Currency currency) {
        currencies.add(currency);
    }    
}