import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Temperature extends JFrame implements ActionListener{
    private Container pane;
    private JButton CToF, FToC;
    private JTextField temp;
    public Temperature(){
	this.setTitle("Temperature Converter");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	CToF = new JButton("Convert to Farenheit");
	FToC = new JButton("Convert to Celsius");
	temp = new JTextField(10);
	CToF.addActionListener(this);
	FToC.addActionListener(this);
	temp.addActionListener(this);
	pane.add(CToF);
	pane.add(FToC);
	pane.add(temp);	    
    }
    public void actionPerformed(ActionEvent e){
	String func = e.getActionCommand();
	if(func.equals("Convert to Farenheit")){
	    temp.setText(String.valueOf(CtoF(Double.parseDouble(temp.getText()))));
	}
	if(func.equals("Convert to Celsius")){
	    temp.setText(String.valueOf(FtoC(Double.parseDouble(temp.getText()))));
	}
    }
    public static double FtoC(double t){
	return (t - 32) * (5.0 / 9);
    }
    public static double CtoF(double t){
	return t * (9.0/5) + 32;
    }
    public static void main(String[]args){
	GUI g = new GUI();
	g.setVisible(true);
    }
}
    
