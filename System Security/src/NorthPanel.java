import javax.swing.JPanel;

import system.SystemInfo;

import java.awt.BorderLayout;

public class NorthPanel extends SystemInfo{
    public NorthPanel(JPanel mainPanel){
        JPanel northPanel=new JPanel(null);
        northPanel.setBackground(getNorthPanelColor());
        mainPanel.add(northPanel,BorderLayout.NORTH);
    }
}
