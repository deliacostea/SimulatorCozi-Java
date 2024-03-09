package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public JFrame f;
    public JTextField timeLimit;
    public JTextField minAr;
    public JTextField maxAr;

    public JTextField minProc;
    public JTextField maxProc;
    public JTextField nrSer;
    public JTextField nrCl;
    public JLabel timeLimit1;
    public JLabel minAr1;
    public JLabel maxAr1;
    public JLabel minProc1;
    public JLabel maxProc1;
    public JLabel nrSer1;
    public JLabel nrCl1;
    public JButton buton;

    public JButton getButon() {
        return buton;
    }

    public JTextField getTimeLimit() {
        return timeLimit;
    }

    public JTextField getMinAr() {
        return minAr;
    }

    public JTextField getMaxAr() {
        return maxAr;
    }

    public JTextField getMinProc() {
        return minProc;
    }

    public JTextField getMaxProc() {
        return maxProc;
    }

    public JTextField getNrSer() {
        return nrSer;
    }

    public JTextField getNrCl() {
        return nrCl;
    }

    public GUI()
    {
        timeLimit1=new JLabel("Timp limita:");
        minAr1=new JLabel("Timp min de sosire:");
        maxAr1=new JLabel("Timp max de sosire:");
        minProc1=new JLabel("Timp min de service:");
        maxProc1=new JLabel("Timp max de service:");
        nrSer1=new JLabel("Numar de cozi:");
        nrCl1=new JLabel("Numar de clienti:");
        buton=new JButton("Start");

        timeLimit=new JTextField("60");
        minAr=new JTextField("2");
        maxAr=new JTextField("30");
        minProc=new JTextField("2");
        maxProc=new JTextField("4");
        nrSer=new JTextField("2");
        nrCl=new JTextField("4");
        f=new JFrame("Cozi");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(200,200,300,400);
        f.setResizable(false);

        timeLimit1.setBounds(20,30,130,20);
        nrSer1.setBounds(20,60,130,20);
        nrCl1.setBounds(20,90,130,20);
        minAr1.setBounds(20,120,130,20);
        maxAr1.setBounds(20,150,130,20);
        minProc1.setBounds(20,180,130,20);
        maxProc1.setBounds(20,210,130,20);

        timeLimit.setBounds(150,30,100,20);
        nrSer.setBounds(150,60,100,20);
        nrCl.setBounds(150,90,100,20);
        minAr.setBounds(150,120,100,20);
        maxAr.setBounds(150,150,100,20);
        minProc.setBounds(150,180,100,20);
        maxProc.setBounds(150,210,100,20);
        buton.setBounds(20,240,100,50);

        f.add(timeLimit);
        f.add(timeLimit1);
        f.add(nrCl);
        f.add(nrCl1);
        f.add(nrSer1);
        f.add(nrSer);
        f.add(minAr);
        f.add(maxAr);
        f.add(minAr1);
        f.add(maxAr1);
        f.add(minProc);
        f.add(maxProc);
        f.add(minProc1);
        f.add(maxProc1);
        f.add(buton);
        f.setLayout(null);
        f.setVisible(true);



    }

}
