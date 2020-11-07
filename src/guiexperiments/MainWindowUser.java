/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexperiments;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author diego
 */
public class MainWindowUser extends MyFrame {
    
    JLabel lSBN = new JLabel("Search by Name");
    JTextField tSBN = new JTextField();
    JLabel lSBL = new JLabel("Search by Location");
    JTextField tSBL = new JTextField();
    BorderLayout bLayout = new BorderLayout();
    public MainWindowUser(){
        this.setLayout(bLayout);
        
    }
}
