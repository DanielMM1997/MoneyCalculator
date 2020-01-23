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
        this.setSize(620,150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        initComponents();
        situateComponents();
    }
    
    private void initComponents() {
        title = new JLabel("Conversor divisas");
        title.setFont(new Font("Arial", 3, 28));
        amount = new JLabel("Amount: ");
        amount.setFont(new Font("Tahoma", 1, 13));
        from = new JLabel(" From: ");
        from.setFont(new Font("Tahoma", 1, 13));
        to = new JLabel(" To: ");
        to.setFont(new Font("Tahoma", 1, 13));
        res = new JLabel("Result: ");
        res.setFont(new Font("Tahoma", 1, 13));
        tfAmount = new JTextField();
        tfAmount.setColumns(6);
        cbFrom = new JComboBox();
        cbTo = new JComboBox();
        tfRes = new JTextField();
        tfRes.setColumns(7);
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
    
    public void setExchange(double r, String code) {
        tfRes.setText(String.format("%.3f", r) + " " + code);
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