import java.awt.BorderLayout;

import javax.swing.JPanel;

import system.SystemInfo;

public class EastPanel extends SystemInfo{
    public EastPanel(JPanel mainPanel){
        JPanel eastPanel=new JPanel(null);
        eastPanel.setBackground(getEastPanelColor());
        mainPanel.add(eastPanel,BorderLayout.EAST);
    }
}
