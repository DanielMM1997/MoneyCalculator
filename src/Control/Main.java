package Control;

import View.MoneyCalculatorView;

public class Main {

    public static void main(String [] args) {
         MoneyCalculatorView mainFrame = new MoneyCalculatorView("Money Calculator");
        Controller controller = new Controller(mainFrame);
        controller.initialize();
    }
}

