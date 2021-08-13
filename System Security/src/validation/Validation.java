package validation;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;

public class Validation {
    public boolean isValidEncryptField(JList list,JTextField textField){
        boolean status1=false,status2=false;
        textField.setBackground(Color.MAGENTA);
        // checking list array
        if(list.getSelectedValues().length==0)
        JOptionPane.showMessageDialog(null, "Not selected any drives whoose can encrypt","error",0);
        else {
            status1=true;
            //checking textfield
            if(textField.getText().length()>10 && textField.getText().length()<50)
            status2=true;
            else{
                textField.setBackground(ColorUIResource.RED);
                JOptionPane.showMessageDialog(null, "Key length should have greater then 10 and less then 50 Character","error",0);
            }
        }
        //returning value
        if(status1 && status2)
        return true;
        else
        return false;
    }

    public boolean isValidKey(JTextField textField){
        //checking textfield
        textField.setBackground(ColorUIResource.MAGENTA);
        if(textField.getText().length()>10 && textField.getText().length()<50)
        return true;
        else{
            textField.setBackground(ColorUIResource.RED);
            JOptionPane.showMessageDialog(null, "Key length should have greater then 10 and less then 50 Character","error",0);
            return false;
        }
    }
}
