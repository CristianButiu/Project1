package ViewandController;


import Model.Operatii;
import Model.Polinom;

import javax.swing.*;
import java.awt.*;

public class ViewAndController {
    public   void label()
    {
        Operatii controller = new Operatii();
        JFrame calcPol = new JFrame("Polynomial Calculator");
        calcPol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcPol.setSize(500, 500);
        JPanel paneltitle = new JPanel();
        paneltitle.setLayout(new FlowLayout());
        JLabel titlu = new JLabel("Polynomial Calculator");
        titlu.setFont(new Font("Titlu",Font.PLAIN,30));
        paneltitle.add(titlu);
        JPanel panelfp = new JPanel();
        panelfp.setLayout(new FlowLayout());
        JPanel panelsp = new JPanel();
        panelsp.setLayout(new FlowLayout());
        JLabel fp = new JLabel("First polynomial:");
        JTextField ft = new JTextField();
        JLabel sp = new JLabel("Second polynomial:");
        JTextField st = new JTextField();
        ft.setColumns(30);
        st.setColumns(30);
        panelfp.add(fp);
        panelfp.add(ft);
        panelsp.add(sp);
        panelsp.add(st);
        JButton badd = new JButton("Add");

        JButton bsub = new JButton("Substract");
        JButton bmul = new JButton("Multiplicate");
        JButton bdiv = new JButton("Divide");
        JButton bderiv = new JButton("Derivate first polynomial");
        JButton bintg = new JButton("Integrate first polynomial");
        JPanel panelb = new JPanel();
        panelb.setLayout(new GridLayout(0, 2));
        panelb.add(badd);
        panelb.add(bsub);
        panelb.add(bmul);
        panelb.add(bdiv);
        panelb.add(bderiv);
        panelb.add(bintg);
        JPanel panelr = new JPanel();
        panelr.setLayout(new FlowLayout());
        JLabel rez = new JLabel("Result:");
        panelr.add(rez);
        JTextField result = new JTextField("");
        JTextField rest = new JTextField("");
        result.setColumns(40);
        rest.setColumns(40);
        JPanel panelr1 = new JPanel();
        panelr1.add(result);
        JLabel restLabel = new JLabel("Rest");
        JPanel panelRestLabel = new JPanel();
        panelRestLabel.add(restLabel);
        JPanel panelrr = new JPanel();
        panelrr.add(rest);
        JButton clear = new JButton("Clear");
        JPanel panelClear = new JPanel();
        panelClear.add(clear);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(paneltitle);
        panel.add(panelfp);
        panel.add(panelsp);
        panel.add(panelb);
        panel.add(panelr);
        panel.add(panelr1);
        panel.add(panelRestLabel);
        panel.add(panelrr);
        panel.add(panelClear);
        calcPol.add(panel);
        calcPol.setVisible(true);
        badd.addActionListener(e -> {
            Polinom p1 = controller.stringToPolinom(ft.getText());
            Polinom p2 = controller.stringToPolinom(st.getText());
            Polinom pfinal = controller.adunareSauScadare(p1,p2 , 0);
            result.setText(pfinal.toString());
            rest.setText("");
        });
        bsub.addActionListener(e -> {
            Polinom p1 = controller.stringToPolinom(ft.getText());
            Polinom p2 = controller.stringToPolinom(st.getText());
            Polinom pfinal = controller.adunareSauScadare(p1,p2 , 1);
            result.setText(pfinal.toString());
            rest.setText("");
        });
        bintg.addActionListener(e->
        {
            Polinom p1 = controller.stringToPolinom(ft.getText());
            Polinom pfinal = controller.integrare(p1);
            result.setText(pfinal.toString());
            rest.setText("");

        });

        bderiv.addActionListener(e ->
        {
            Polinom p1 = controller.stringToPolinom(ft.getText());
            Polinom pfinal = controller.derivare(p1);
            result.setText(pfinal.toString());
            rest.setText("");
        });
        bmul.addActionListener(e ->
        {
            Polinom p1 = controller.stringToPolinom(ft.getText());
            Polinom p2 = controller.stringToPolinom(st.getText());
            Polinom pfinal = controller.inmultire(p1, p2);
            result.setText(pfinal.toString());
            rest.setText("");

        });
        bdiv.addActionListener(e ->
        {
            Polinom p1 = controller.stringToPolinom(ft.getText());
            Polinom p2 = controller.stringToPolinom(st.getText());
            Polinom pfinal = controller.impartire(p1, p2).get(0);
            Polinom rfinal = controller.impartire(p1, p2).get(1);
            result.setText(pfinal.toString());
            rest.setText(rfinal.toString());
        });
        clear.addActionListener(e ->
        {
            result.setText("");
            rest.setText("");
            ft.setText("");
            st.setText("");
        });

    }
}
