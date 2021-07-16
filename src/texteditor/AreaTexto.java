/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.Color;
import static java.awt.SystemColor.text;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

/**
 *
 * @author Guillermo Leiro Arroyo
 */
public class AreaTexto{
    private JTextArea texto;
    private JScrollPane scroll;
    
    public AreaTexto(){
        texto=new JTextArea(20,40);
        scroll=new JScrollPane(texto);
    }
    
    public JScrollPane getContent(){
        return scroll;
    }
    
    public JTextArea getAreaT(){
        return texto;
    }
    
    public void buscarPalabra(String palabra){
        //String text = "hola mundo. ¿cómo estáis?";
        texto.setText(palabra);
        Highlighter highlighter = texto.getHighlighter();
        HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.red);
        int p0 = palabra.indexOf("mundo");
        int p1 = p0 + "mundo".length();
        //highlighter.addHighlight(p0, p1, painter);
    }
}
