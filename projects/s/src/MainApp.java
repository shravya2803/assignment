import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
public class MainApp extends JFrame {

    public JPanel inputPanel;
    public JPanel outputPanel;
    public  JTextField mobileNoField;
    public  JTextField nameField;
    public JTextField addressField;
    public  JTextField barcodeField;
    public JTextField weightField;
    public  JTextField rateField;
    public JTextField tweightField;
    public  JTextField trateField;
    public  JTextField touchField;
    public  JTextField jamaField;
    public JComboBox<String> makingChargesComboBox;
    public  JTextField makingChargesField;
    public  JComboBox<String> conditionComboBox;
    public  JComboBox<String> paymentMethodComboBox;
    public JComboBox<String> transitionComboBox;
    public  JTextArea outputArea;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH-mm-ss");
    String formattedDateTime = now.format(formatter);

    File file = new File("output_" + formattedDateTime +"  "+ ".txt");
    FileWriter fileWriter ;
    
        public static void main(String[] args) {
            MainApp obj = new MainApp();
            obj.processor();
        }

    private void processor()  {
        setLayout(new BorderLayout());
        // Create input panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2));
        inputPanel.add(new JLabel("Condition:"));
        conditionComboBox = new JComboBox<>(new String[] {"Gold", "Silver"});
        inputPanel.add(conditionComboBox);

        inputPanel.add(new JLabel("Mobile No:"));
        mobileNoField = new JTextField();
        inputPanel.add(mobileNoField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        inputPanel.add(addressField);

        inputPanel.add(new JLabel("Barcode:"));
        barcodeField = new JTextField();
        inputPanel.add(barcodeField);

        inputPanel.add(new JLabel("Weight:"));
        weightField = new JTextField();
        inputPanel.add(weightField);

        inputPanel.add(new JLabel("Rate:"));
        rateField = new JTextField();
        inputPanel.add(rateField);

        inputPanel.add(new JLabel("Transition:"));
        transitionComboBox = new JComboBox<>(new String[] {"Gold" , "Silver"});
        inputPanel.add(transitionComboBox);
        trateField = new JTextField();
        tweightField = new JTextField();
        touchField = new JTextField();
        trateField.setVisible(false);
        tweightField.setVisible(false);
        touchField.setVisible(false);
        if(transitionComboBox.getSelectedItem().equals("Silver") || transitionComboBox.getSelectedItem().equals("Gold"))
        {
            inputPanel.add(new JLabel("Rate:"));
            inputPanel.add(trateField);
            inputPanel.add(new JLabel("Weight:"));
            inputPanel.add(tweightField);
            inputPanel.add(new JLabel("Touch:"));
            inputPanel.add(touchField);
            touchField.setVisible(true);
            trateField.setVisible(true);
            tweightField.setVisible(true);
        }
        inputPanel.add(new JLabel("Making Charges:"));
        makingChargesComboBox = new JComboBox<>(new String[]{"Whole","Part"});
        inputPanel.add(makingChargesComboBox);

        inputPanel.add(new JLabel("Making Charges:"));
        makingChargesField = new JTextField();
        inputPanel.add(makingChargesField);

        inputPanel.add(new JLabel("Payment Method:"));
        paymentMethodComboBox = new JComboBox<>(new String[] {"Cash", "Other"});
        inputPanel.add(paymentMethodComboBox);


        add(inputPanel, BorderLayout.CENTER);

        // Create output panel
        outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());

        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        add(outputPanel, BorderLayout.EAST);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitButtonListener());
        buttonPanel.add(exitButton);

        JButton reRun = new JButton("Re-Run");
        reRun.addActionListener(new ReRunButtonListener());
        buttonPanel.add(reRun);


        add(buttonPanel, BorderLayout.SOUTH);

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                calculate();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(MainApp.this, "Error: " + ex.getMessage());
            }
        }
    }

    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class ReRunButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MainApp obj = new MainApp();
            obj.processor();
        }
    }

    

      

    private void calculate() {
        long mobileNo = Long.parseLong(mobileNoField.getText());
        String name = nameField.getText();
        String address = addressField.getText();
        String barcode = barcodeField.getText();
        double weight = Double.parseDouble(weightField.getText());
        double rate = Double.parseDouble(rateField.getText());
        double tweight = Double.parseDouble(tweightField.getText());
        double trate = Double.parseDouble(trateField.getText());
        double touch = Double.parseDouble(touchField.getText());
        double majuri = Double.parseDouble(makingChargesField.getText());
        String makingCharges = (String) makingChargesComboBox.getSelectedItem();
        String condition = (String) conditionComboBox.getSelectedItem();
        String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();
        String transition = (String) transitionComboBox.getSelectedItem();
        MainApp obj = new MainApp();
        try{
        obj.mobileNo(mobileNo);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(MainApp.this, "Invalid Mobile Number");
            mobileNoField.setText(null);
        }
        double netAmount ;
         netAmount = calculateNetAmount(weight, rate,majuri, makingCharges, condition);
        
        
        netAmount=obj.tax(netAmount,tweight,trate,touch,paymentMethod, transition);
        netAmount=obj.transition(transition, netAmount, tweight, trate, touch);
        
        try {
            writeOutputToFile(name, address, mobileNo, barcode, weight, rate, majuri, condition, paymentMethod, transition, netAmount, tweight, trate, touch);
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
        outputArea.setText("Net Amount: " + netAmount);


    
        
    }
    private void mobileNo(long mobileNo) {
        if(mobileNo>9999999999L||mobileNo<1000000000L){
            JOptionPane.showMessageDialog(MainApp.this, "Invalid Mobile Number");
            MainApp obj = new MainApp();
            obj.processor();
        }
        
    }

    private double calculateNetAmount(double weight, double rate, double majuri,String makingCharges, String condition) {
        // Implement your calculation logic here
        double netAmount = 0.0;
        
        if(condition.equals("Gold")) {
            if(makingCharges.equals("Whole")) {
                netAmount = ((weight * rate)/10)+majuri;
            }
            else if(makingCharges.equals("Part")) {
                netAmount = ((weight * rate)/10)+(majuri*weight);
            }
            }
        
        else if(condition.equals("Silver")) {
            if(makingCharges.equals("Whole")) {
                netAmount = ((weight * rate)/1000)+majuri;
            }
            else if(makingCharges.equals("Part")) {
                netAmount = ((weight * rate)/1000)+(majuri*weight);
            }
        }
        return netAmount;
        }
    
    private void writeOutputToFile(String name, String address, long mobileNo, String barcode, double weight, double rate, double makingCharges, String condition, String paymentMethod, String transition, double netAmount, double tWeight, double tRate, double touch) throws IOException {
        // Implement your file writing logic here LocalDateTime now = LocalDateTime.now();
         fileWriter = new FileWriter(file);
       
        fileWriter.write("Bill From Mutri Jewellers of "+condition+"\n");
        fileWriter.write("Date: " + formattedDateTime + "\n");

        fileWriter.write("Name: " + name + "\n");
        fileWriter.write("Address: " + address + "\n");
        fileWriter.write("Mobile No: " + mobileNo + "\n");
        fileWriter.write("Barcode: " + barcode + "\n");
        fileWriter.write("Weight: " + weight + "\n");
        fileWriter.write("Rate: " + rate + "\n");
        fileWriter.write("Making Charges: " + makingCharges + "\n");
        fileWriter.write("Payment Method: " + paymentMethod + "\n");
        if(paymentMethod.equals("Cash")) {
            fileWriter.write("Transition: Cash\n");
            fileWriter.write("Tax :- 0%\n");
        }
        else if(paymentMethod.equals("Other")) {
            fileWriter.write("Transition: Other\n");
            fileWriter.write("Tax : 3%\n");
        }
        if(touch!=0){
        fileWriter.write("Transition: " + transition + "\n");
        fileWriter.write("Trastion Weight : " + tweightField.getText() + "\n");
        fileWriter.write("Trastion Rate : " + ((((tWeight*touch)/100)*tRate)/((transition.equals("Gold")?10:1000))) + "\n");
        }
        fileWriter.write("Net Amount: " + netAmount + "\n");
        fileWriter.close();
    }

    private double tax(double netAmount,double tWeight,double tRate,double touch, String paymentMethod, String transition) {
         if(paymentMethod.equals("Other")) {
            netAmount=(netAmount*0.03)+netAmount;
            MainApp obj = new MainApp();
            obj.transition(transition, netAmount, tWeight, tRate, touch);
        }
        return netAmount;
        }

    private double transition(String transition, double netAmount, double tWeight, double tRate, double touch)  {
        if(transition.equals("Gold")||transition.equals("Silver")) {
            touch=touch/100;
            tWeight=tWeight*touch;
            netAmount=netAmount-((tWeight*tRate)/((transition.equals("Gold")?10:1000)));
        }
        return netAmount;
    }

}