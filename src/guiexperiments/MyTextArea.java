/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexperiments;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 *
 * @author diego
 */
public class MyTextArea extends JTextArea {
    
    public MyTextArea(String s){
        this.setWrapStyleWord(true);
        this.setLineWrap(true);
        this.setOpaque(false);
        this.setEditable(false);
        this.setFocusable(false);
        this.setFont(new Font("Serif",Font.PLAIN,12));
        this.setForeground(new Color(200,0,0));
        this.setText(s);
        this.setVisible(false);
    }
}
