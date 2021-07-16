/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Guillermo Leiro Arroyo
 */
public class CopiarPegar extends JPanel{
    
    private JButton copy, paste, cut;
    private JTextArea areaTexto;
    
    public CopiarPegar(JTextArea text,Informacion infoPanel){
        areaTexto= text;
        cut = new JButton("Cortar");
        cut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                infoPanel.setInfo("Se ha cortado \""+areaTexto.getSelectedText()+"\" al portapapeles.");
                areaTexto.cut();
                paste.setEnabled(true);
            }
        });
        add(cut);
        paste = new JButton("Pegar");
        paste.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    infoPanel.setInfo("Portapapeles = "+(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
                } catch (UnsupportedFlavorException ex) {
                    //Logger.getLogger(CopiarPegar.class.getName()).log(Level.SEVERE, null, ex);
                    infoPanel.setInfo("El contenido del portapapeles no es texto");
                } catch (IOException ex) {
                    //Logger.getLogger(CopiarPegar.class.getName()).log(Level.SEVERE, null, ex);
                    infoPanel.setInfo("Fallo al pegar el portapapeles.");
                }
                areaTexto.paste();
            }
        });
        add(paste);
        paste.setEnabled(false);
        copy = new JButton("Copiar");
        copy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                infoPanel.setInfo("Se ha copiado \""+areaTexto.getSelectedText()+"\" al portapapeles.");
                areaTexto.copy();
                paste.setEnabled(true);
            }
        });
        add(copy);
    }
}
