package View;

import Model.Currency;
import Model.CurrencyList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    private JLabel title, amount, from, to, res;
    private JTextField tfAmount, tfRes;
    private JComboBox cbFrom, cbTo;
    private JButton bConver;
    
    public MainFrame() {
        this.setTitle("MoneyCalculator");
        this.setSize(570,150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        initComponents();
        situateComponents();
    }
    
    private void initComponents() {
        title = new JLabel("Conversor divisas");
        title.setFont(new Font("Arial", 3, 18));
        amount = new JLabel("Amount: ");
        from = new JLabel("From: ");
        to = new JLabel("To: ");
        res = new JLabel("Result: ");
        tfAmount = new JTextField();
        tfAmount.setColumns(6);
        cbFrom = new JComboBox();
        cbFrom.setMaximumRowCount(8);
        cbTo = new JComboBox();
        cbTo.setSize(80, 20);
        tfRes = new JTextField();
        tfRes.setColumns(6);
        tfRes.setEditable(false);
        bConver = new JButton("Calculate");
    }
    
    private void situateComponents() {
        JPanel content = new JPanel(new BorderLayout());
        JPanel top = new JPanel();
        top.add(new JLabel());
        top.add(title);
        JPanel mid = new JPanel();
        mid.add(amount);
        mid.add(tfAmount);
        mid.add(from);
        mid.add(cbFrom);
        mid.add(to);
        mid.add(cbTo);
        JPanel bot = new JPanel();
        bot.add(bConver);
        bot.add(new JLabel("           "));
        bot.add(res);
        bot.add(tfRes);
        content.add(top, BorderLayout.NORTH);
        content.add(mid, BorderLayout.CENTER);
        content.add(bot, BorderLayout.SOUTH);
        this.add(content);
    }
    
    public double getAmount() {
        return Double.parseDouble(tfAmount.getText());
    }
    
    public Currency getFrom() {
        return (Currency) cbFrom.getSelectedItem();
    }
    
    public Currency getTo() {
        return (Currency) cbTo.getSelectedItem();
    }
    
    public void setExchange(double r) {
        tfRes.setText(Double.toString(r));
    }
    
    public void addRateListener(ActionListener listenForRateButton) {
        bConver.addActionListener(listenForRateButton);
    }
    
    public void DisplayErrorMessage(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public void addCurrencyList(CurrencyList currencies) {
        for (Currency cu : currencies.getCurrencies()) {
            cbFrom.addItem(cu);
            cbTo.addItem(cu);
        }
    }
}