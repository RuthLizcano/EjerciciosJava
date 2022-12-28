/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewDirector;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JFrame;


/**
 *
 * @author casierrav
 */
public class MainWindowDirector extends JFrame {
    
    public MainWindowDirector(){
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
    }
    
    private void initComponents(){
         
        setTitle("Director");
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        ResultsPanelDirector resultsPanelDirector = new ResultsPanelDirector();
        setContentPane(resultsPanelDirector);
        add(new ControlsPanelDirector(resultsPanelDirector));
        
        setSize(700, 500);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        setLocation((screenSize.width  - frameSize.width)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
