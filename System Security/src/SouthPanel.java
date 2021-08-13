import java.awt.BorderLayout;

import javax.swing.JPanel;

import system.SystemInfo;

public class SouthPanel extends SystemInfo{
    public SouthPanel(JPanel mainPanel){
        JPanel southPanel=new JPanel(null);
        southPanel.setBackground(getSouthPanelColor());
        mainPanel.add(southPanel,BorderLayout.SOUTH);
    }
}
