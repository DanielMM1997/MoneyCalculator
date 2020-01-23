package Control;

import Model.Currency;
import Model.CurrencyList;
import Persistance.ExchangeRateLoaderFromWeb;
import View.MainFrame;
import java.awt.event.*;

public class Controller {
    private MainFrame frame;
    private CurrencyList currencies;
    private ExchangeRateLoaderFromWeb exchange;

    public Controller(MainFrame MoneyCalculatorView, CurrencyList currencies,
                                        ExchangeRateLoaderFromWeb exchangeRate) {
        this.frame = MoneyCalculatorView;
        this.currencies = currencies;
        this.exchange = exchangeRate;
        frame.addRateListener(new RateListener());
        frame.addCurrencyList(currencies);
        frame.setVisible(true);
    }

    private class RateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            double amount;
            Currency from;
            Currency to;
            double rate;
            
            try {
              amount = frame.getAmount();
              from = frame.getFrom();
              to = frame.getTo();
              rate = exchange.load(from, to).getRate();
              frame.setExchange(amount * rate, to.getSysmbol());
            } catch (NumberFormatException ex) {
                frame.DisplayErrorMessage("Debes introducir un número");
            }
        }
    }
   
}