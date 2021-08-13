import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;

import system.SystemInfo;

public class CenterPanel extends SystemInfo{
    private JPanel panel;
    public CenterPanel(JPanel mainPanel){
        JPanel centerPanel=new JPanel(new GridBagLayout());
        centerPanel.setBackground(getCenterPanelColor());
        mainPanel.add(centerPanel,BorderLayout.CENTER);

        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(50,50,50,50);
        gbc.gridx=0;
        gbc.gridy=0;
        this.panel=centerPanel;
    }

    public JPanel getPanel(){
        return panel;
    }
}
