/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.Color;
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

/**
 *
 * @author Guillermo Leiro Arroyo
 */
public class Busqueda extends JPanel{
    
    //variables campos visuales
    private JButton buscar;
    private JButton siguiente;
    private JTextField query;
    private Informacion infoPanel;
    //contenedores para campos
    private JPanel first, second;
    //variables busqueda
    private JTextArea textArea;
    private int searchIndex;
    private String text;
    //subrayado variables
    private HighlightPainter painter;
    private Highlighter highlighter;
    private int count;
    
    public Busqueda(JTextArea text, Informacion infoPanel){
        this.infoPanel=infoPanel;
        textArea=text;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        buscar=new JButton("Buscar");
        siguiente=new JButton("Siguiente");
        firstRow();
        add(first);
        secondRow();
        add(second);
        
        //Establecimiento parametros de subrayado
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
        highlighter = textArea.getHighlighter();
       
    }
    
    private void search(){
        text=query.getText();
        //textArea.setText(text);
        String archivo=textArea.getText();
        int p0 = archivo.indexOf(text);
        searchIndex = p0 + text.length();
        try {
            highlighter.removeAllHighlights();
            highlighter.addHighlight(p0, searchIndex, painter);
            siguiente.setEnabled(true);
            count=1;
        } catch (BadLocationException ex) {
            //Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se encontro ninguna coincidencia.");
        }
    }
    
    private void next(){
        String archivo=textArea.getText();
        int p0 = archivo.indexOf(text,searchIndex);
        searchIndex = p0 + text.length();
        try {
            highlighter.removeAllHighlights();
            highlighter.addHighlight(p0, searchIndex, painter);
            count++;
        } catch (BadLocationException ex) {
            //Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Final del fichero, no hay mas coincidencias.");
            highlighter.removeAllHighlights();
            siguiente.setEnabled(false);
        }
    }
    
    
    private void firstRow(){
        query=new JTextField(12);
        first = new JPanel();
        first.add(new JLabel("Texto a buscar: "));
        first.add(query);
    }
    
    private void secondRow(){
        second = new JPanel();
        buscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                search();
                infoPanel.setInfo(count+"ª ocurrencia de la cadena \""+text+"\"");
                textArea.requestFocus();
            }
        });
        second.add(buscar);
        siguiente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                next();
                infoPanel.setInfo(count+"ª ocurrencia de la cadena \""+text+"\"");
                textArea.requestFocus();
            }
        });
        second.add(siguiente);
        siguiente.setEnabled(false);
    }
    
}
