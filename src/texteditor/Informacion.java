/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Guillermo Leiro Arroyo
 */
public class Informacion extends JPanel{
    
    private JLabel info;
    
    public Informacion(String titulo){
        info = new JLabel("Bienbenido a "+titulo+" text editor.");
        add(info);
    }
    
    public void setInfo(String info){
        this.info.setText(info);
    }
    
}
