/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Guillermo Leiro Arroyo
 */
public class Guardado extends JPanel{
    
    private JButton save;
    private JButton open;
    private JTextArea areaTexto;
    private Informacion infoPanel;
    
    public Guardado(JTextArea text, Informacion infoPanel){
        this.infoPanel=infoPanel;
        areaTexto = text;
        save= new JButton("Salvar Fichero");
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                salvar();
            }
        });
        add(save);
        open= new JButton("Abrir Fichero");
        open.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cargar();
            }
        });
        add(open);
        
    }
    
    public void salvar(){
        JFileChooser fileChooser = new JFileChooser();
        
        int seleccion = fileChooser.showSaveDialog(areaTexto);
        
        if (seleccion == JFileChooser.APPROVE_OPTION){
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile().getPath()));
                out.write(areaTexto.getText());
                out.close();
                infoPanel.setInfo("Guardado "+fileChooser.getSelectedFile().toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
    
    public void cargar(){
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(areaTexto);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedReader out = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                areaTexto.read(out,null);
                out.close();
                infoPanel.setInfo("Mostrando "+fileChooser.getSelectedFile().toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
}
