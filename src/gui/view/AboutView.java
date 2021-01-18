package gui.view;

import javax.swing.*;

import java.awt.*;
import java.net.URL;

public class AboutView  extends JDialog {

    public AboutView(){
        super(MainView.getInstance(),"About");
        BoxLayout box = new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS);
        this.setLayout(box);
        add(Box.createHorizontalStrut(30));
        add(petarSplit());
        add(Box.createHorizontalStrut(30));
        add(lazarSplit());


        this.setSize(680  ,680);

    }

    private JPanel petarSplit(){

        JPanel panel = new JPanel();
        BoxLayout box = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(box);
        String path = "images/Petar.jpg";
        ImageIcon slika = new ImageIcon(path);
        JLabel Lslika = (new JLabel(slika));
        Lslika.setPreferredSize(new Dimension(200,200));
        panel.add(Lslika);
        panel.add(Box.createVerticalStrut(30));
        JLabel lIme = new JLabel("Petar Sarenac");
        panel.add(lIme);
        panel.add(Box.createVerticalStrut(30));
        JLabel lIndeks = new JLabel("RN66/19");
        panel.add(lIndeks);
        return panel;

    }

    private JPanel lazarSplit(){
        JPanel panel = new JPanel();
        BoxLayout box = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(box);
        String path = "images/lazar.jpg";
        ImageIcon slika = new ImageIcon(path);
        JLabel lSlika = (new JLabel(slika));
        lSlika.setPreferredSize(new Dimension(200,200));
        panel.add(lSlika);
        panel.add(Box.createVerticalStrut(30));
        JLabel lIme = new JLabel("Lazar Radovanovic");
        panel.add(lIme);
        panel.add(Box.createVerticalStrut(30));
        JLabel lIndeks = new JLabel("RN89/19");
        panel.add(lIndeks);
        return panel;
    }

}
