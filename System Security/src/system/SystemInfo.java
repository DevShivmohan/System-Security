package system;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;

import color.Colors;
import security.Security;
public class SystemInfo extends Colors{   
    private static String PASSWORD="1010101shivmhasivnprnkbhutni";   
    private static String KEY="10101011010101bhutni5muhi5muhwalishiv";   
    private String mainPath=System.getProperty("user.home");
    private Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
    public int getScreenWidth(){
        return dimension.width;
    }

    public int getScreenHeight(){
        return dimension.height;
    }

    // getting all drive list instead of OS drive
    public File[] scanDrives(){
        File[] files=File.listRoots();
        File[] files2=new File[files.length-1];
        int j=0;
        for (int i=0;i<files.length;i++){
            if(files[i].getAbsolutePath().indexOf(System.getenv("SystemDrive"),0)==-1){
                files2[j]=files[i];
                j++;
            }
        }
        files=files2;
        return files;
    }

    public String getSecurityRootPath(){
        File file=new File(mainPath+"//"+"security");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public String getSystemPassword(){
        try{
            File file=new File(getSecurityRootPath()+"//SystemGrant.shiv");
            Security security=new Security(KEY);
            byte[] data=security.getDecryptedData(file);
            if(data!=null){
                return new String(data);
            }else
            return PASSWORD;
        }catch(Exception e){
            e.printStackTrace();
            return PASSWORD;
        }
    }

    public boolean updateSystemPassword(String password){
        try{
            Security security=new Security("");
            File file=new File(getSecurityRootPath()+"//SystemGrant.shiv");
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(security.getEncryptedData(password));
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public long getRuntimeMemory(){
        return Runtime.getRuntime().totalMemory();
    }

}