package View;

/**
 *
 * @author Néstor
 */

import Model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MoneyCalculatorView extends JFrame {
    private Map<String,JComponent> components = new LinkedHashMap<>();
    private List<Currency> currencies;

    public MoneyCalculatorView (String arg) {
        super(arg);
    }

    public void initialize () {

        components.put("Title" , new JLabel("Cambiar de EURO a otra moneda"));
        components.get("Title").setFont(components.get("Title").getFont().deriveFont(2,19));

        components.put("AmountLabel", new JLabel("Inserta cantidad: "));
        components.put("Amount", new JTextField());
        components.get("Amount").setPreferredSize(new Dimension(100, 20));

        components.put("To", new JLabel("Escoge una moneda: "));
        components.put("SelectorTo", new JComboBox<Currency>());

        components.put("CalculateButton", new JButton("Calcular"));
        components.put("ClearButton", new JButton("Borrar"));

        components.put("ResultLabel", new JLabel("Resultado: "));
        components.get("ResultLabel").setFont(components.get("ResultLabel").getFont().deriveFont(1,14));
        components.put("Result", new JTextField());
        components.get("Result").setPreferredSize(new Dimension(160, 20));
        JTextField resultField = (JTextField)components.get("Result");
        resultField.setEditable(false);


        JComboBox<Currency> to = (JComboBox<Currency>) components.get("SelectorTo");
        for (Currency curr: currencies) {
            to.addItem(curr);
        }


        JPanel panelTop = new JPanel();
        JPanel panelMid = new JPanel();
        JPanel panelMid1 = new JPanel();
        JPanel panelMid2 = new JPanel();
        JPanel panelMid3 = new JPanel();
        JPanel panelBot = new JPanel();
        JPanel panelBot1 = new JPanel();
        JPanel panelBot2 = new JPanel();
        JPanel content = new JPanel();

        panelTop.add(components.get("Title"));
        panelTop.setLayout(new FlowLayout());
        panelTop.setBorder(new EmptyBorder(0, 0, 20, 0));

        panelMid1.add(components.get("AmountLabel"));
        panelMid1.add(components.get("Amount"));
        panelMid1.setLayout(new FlowLayout());

        panelMid2.add(components.get("To"));
        panelMid2.add(components.get("SelectorTo"));
        panelMid2.setLayout(new FlowLayout());

        panelMid3.add(components.get("CalculateButton"));
        panelMid3.setLayout(new FlowLayout());

        panelMid.add(panelMid1);
        panelMid.add(panelMid2);
        panelMid.add(panelMid3);
        panelMid.setLayout(new BoxLayout(panelMid, BoxLayout.Y_AXIS));

        panelBot1.add(components.get("ResultLabel"));
        panelBot1.add(components.get("Result"));
        panelBot1.setLayout(new FlowLayout());

        panelBot2.add(panelBot1);
        panelBot2.add(components.get("ClearButton"));
        panelBot2.setLayout(new GridLayout(2, 1));
        panelBot.add(panelBot2);
        panelBot.setLayout(new FlowLayout());
        panelBot.setBorder(new EmptyBorder(17, 0, 0, 0));

        content.add(panelMid);
        content.add(panelBot);
        content.setLayout(new GridLayout(1, 2));

        this.add(panelTop, BorderLayout.NORTH);
        this.add(content, BorderLayout.CENTER);


        setSize(700, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void setCurrencySet (List<Currency> loadCurrencies) {
        this.currencies = loadCurrencies;
    }

    public Map<String, JComponent> getMyComponents() {
        return components;
    }
}