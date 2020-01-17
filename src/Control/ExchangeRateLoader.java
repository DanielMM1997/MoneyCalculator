package Control;

import Model.*;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency currency);
}