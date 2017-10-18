/*
  ______ __  __          __  __ ________   _____   ___
 |  ____|  \/  |   /\   |  \/  |  ____\ \ / / _ \ / _ \
 | |__  | \  / |  /  \  | \  / | |__   \ V / (_) | (_) |
 |  __| | |\/| | / /\ \ | |\/| |  __|   > < \__, |> _ <
 | |____| |  | |/ ____ \| |  | | |____ / . \  / /| (_) |
 |______|_|  |_/_/    \_\_|  |_|______/_/ \_\/_/  \___/

Emanuel Estrada Larios - A01633605
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI extends JFrame implements ActionListener{

  private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btPunto, btSum, btRes, btDiv, btMul, btPow, btEqu, btCA;
  private JTextField tfDisplay;
  private String output;
  private Calculadora calculadora;

  public GUI(){
    super("Calculadora");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(420,250);

    this.calculadora = new Calculadora();

    JPanel display = new JPanel();
    display.setPreferredSize(new Dimension(400,50));

    this.tfDisplay = new JTextField(30);
    display.add(this.tfDisplay);
    this.output = "";

    ////////////////////////////////////////////////////////

    JPanel gui = new JPanel(new FlowLayout(FlowLayout.LEFT));
    gui.setPreferredSize(new Dimension(250,200));

    this.bt7 = new JButton("7");
    this.bt7.addActionListener(this);
    gui.add(this.bt7);

    this.bt8 = new JButton("8");
    this.bt8.addActionListener(this);
    gui.add(this.bt8);

    this.bt9 = new JButton("9");
    this.bt9.addActionListener(this);
    gui.add(this.bt9);

    this.bt4 = new JButton("4");
    this.bt4.addActionListener(this);
    gui.add(this.bt4);

    this.bt5 = new JButton("5");
    this.bt5.addActionListener(this);
    gui.add(this.bt5);

    this.bt6 = new JButton("6");
    this.bt6.addActionListener(this);
    gui.add(this.bt6);

    this.bt1 = new JButton("1");
    this.bt1.addActionListener(this);
    gui.add(this.bt1);

    this.bt2 = new JButton("2");
    this.bt2.addActionListener(this);
    gui.add(this.bt2);

    this.bt3 = new JButton("3");
    this.bt3.addActionListener(this);
    gui.add(this.bt3);

    this.bt0 = new JButton("0");
    this.bt0.addActionListener(this);
    gui.add(this.bt0);

    this.btPunto = new JButton(".");
    this.btPunto.addActionListener(this);
    gui.add(this.btPunto);

    ////////////////////////////////////////////////////////

    JPanel gui2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    gui2.setPreferredSize(new Dimension(200,200));

    this.btMul = new JButton("x");
    this.btMul.addActionListener(this);
    gui2.add(this.btMul);

    this.btDiv = new JButton("/");
    this.btDiv.addActionListener(this);
    gui2.add(this.btDiv);

    this.btSum = new JButton("+");
    this.btSum.addActionListener(this);
    gui2.add(this.btSum);

    this.btRes = new JButton("–");
    this.btRes.addActionListener(this);
    gui2.add(this.btRes);

    this.btPow = new JButton("^");
    this.btPow.addActionListener(this);
    gui2.add(this.btPow);

    this.btEqu = new JButton("=");
    this.btEqu.addActionListener(this);
    gui2.add(this.btEqu);

    this.btCA = new JButton("CA");
    this.btCA.addActionListener(this);
    gui2.add(this.btCA);

    //////////////////////////////////////////////////////

    this.add(display, BorderLayout.NORTH);
    this.add(gui, BorderLayout.WEST);
    this.add(gui2, BorderLayout.EAST);

    this.setVisible(true);
  }

  //////////////////////////////////////////////////////////

  public void actionPerformed(ActionEvent e){

    if(e.getSource() == this.bt0)
      this.output += "0";
    else if(e.getSource() == this.bt1)
      this.output += "1";
    else if(e.getSource() == this.bt2)
      this.output += "2";
    else if(e.getSource() == this.bt3)
      this.output += "3";
    else if(e.getSource() == this.bt4)
      this.output += "4";
    else if(e.getSource() == this.bt5)
      this.output += "5";
    else if(e.getSource() == this.bt6)
      this.output += "6";
    else if(e.getSource() == this.bt7)
      this.output += "7";
    else if(e.getSource() == this.bt8)
      this.output += "8";
    else if(e.getSource() == this.bt9)
      this.output += "9";
    else if(e.getSource() == this.btPunto)
      this.output += ".";

    else if(e.getSource() == this.btMul){
      this.calculadora.setA(Double.parseDouble(this.output));
      this.calculadora.setOperation('m');
      changeStatus(false);
      this.output = "";
    }
    else if(e.getSource() == this.btDiv){
      this.calculadora.setA(Double.parseDouble(this.output));
      this.calculadora.setOperation('d');
      changeStatus(false);
      this.output = "";
    }
    else if(e.getSource() == this.btSum){
      this.calculadora.setA(Double.parseDouble(this.output));
      this.calculadora.setOperation('s');
      changeStatus(false);
      this.output = "";
    }
    else if(e.getSource() == this.btRes){
      this.calculadora.setA(Double.parseDouble(this.output));
      this.calculadora.setOperation('r');
      changeStatus(false);
      this.output = "";
    }
    else if(e.getSource() == this.btPow){
      this.calculadora.setA(Double.parseDouble(this.output));
      this.calculadora.setOperation('p');
      changeStatus(false);
      this.output = "";
    }
    else if(e.getSource() == this.btEqu){
      this.calculadora.setB(Double.parseDouble(this.output));
      changeStatus(true);
      this.output = Double.toString(this.calculadora.calcula());
    }
    else {
      this.calculadora.setA(0);
      this.calculadora.setB(0);
      this.calculadora.setOperation('n');
      changeStatus(true);
      this.output = "";
    }


    this.tfDisplay.setText(this.output);
    this.revalidate();

  }

  //////////////////////////////////////////////////////////

  private void changeStatus(boolean b){
      this.btMul.setEnabled(b);
      this.btDiv.setEnabled(b);
      this.btSum.setEnabled(b);
      this.btRes.setEnabled(b);
      this.btPow.setEnabled(b);
  }

  public static void main(String[] args) {
    GUI gui = new GUI();
  }

}
