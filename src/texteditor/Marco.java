/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

/**
 *
 * @author Guillermo Leiro Arroyo
 */
public class Marco extends JFrame{
    
    private AreaTexto mainArea;
    private Informacion infoPanel;
    
    public Marco(String titulo){
        super(titulo+" text editor.");
        this.setIconImage(new ImageIcon(getClass().getResource("../t_cont.png")).getImage());
        infoPanel = new Informacion(titulo);
        mainArea = new AreaTexto();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        addComponents();
        //setSize(450,110);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void addComponents(){
        add(mainArea.getContent());
        //add(new JSeparator(JSeparator.HORIZONTAL),BorderLayout.LINE_START);
        add(new Busqueda(mainArea.getAreaT(),infoPanel));
        add(new JSeparator(JSeparator.HORIZONTAL),BorderLayout.LINE_START);
        add(new Guardado(mainArea.getAreaT(),infoPanel));
        add(new JSeparator(JSeparator.HORIZONTAL),BorderLayout.LINE_START);
        add(new CopiarPegar(mainArea.getAreaT(),infoPanel));
        add(new JSeparator(JSeparator.HORIZONTAL),BorderLayout.LINE_START);
        add(infoPanel);
    }
}
