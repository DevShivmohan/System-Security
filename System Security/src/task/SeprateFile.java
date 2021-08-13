package task;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import security.Security;

public class SeprateFile {
    private JTextArea textArea;
    private Thread thread1;
    private String key;
    public SeprateFile(JTextArea textArea,String key){
        this.textArea=textArea;
        this.key=key;
        DefaultCaret defaultCaret=(DefaultCaret) textArea.getCaret();
        defaultCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    public void initEncryptionTask(Object[] objects){
        textArea.setText("");
        if(isThreadAlive()){ // if thread already running then ignore this event
            thread1=new Thread(new Runnable(){
                public void run(){
                    for (Object object : objects) {
                        traverseEncryptionFile(new File((String)object));
                    }
                    textArea.append("\n\t\tTask is finished");
                }
            });
            thread1.start();
        }
    }

    public void initEncryptionTask(File[] files){
        textArea.setText("");
        if(isThreadAlive()){
            thread1=new Thread(new Runnable(){
                public void run(){
                    for (File file:files) {
                        traverseEncryptionFile(file);
                        // System.out.println(file.getAbsolutePath());
                    }
                    textArea.append("\n\t\tTask is finished");
                }
            });
            thread1.start();
        }
    }

    public void initDecryptionTask(File[] files){
        textArea.setText("");
        if(isThreadAlive()){
            thread1=new Thread(new Runnable(){
                public void run(){
                    for (File file:files) {
                        traverseDecryptionFile(file);
                    }
                    textArea.append("\n\t\tTask is finished");
                }
            });
            thread1.start();
        }
    }

    synchronized public void traverseEncryptionTask(File[] files){
        thread1=new Thread(new Runnable(){
            public void run(){
                for (File file : files) {
                    if(isIgnoreVideoFiles(file) || true){
                        Security security=new Security(key);
                        byte[] fileData=security.getEncryptedData(file);
                        if(fileData!=null){
                            writeFile(file, fileData);
                            textArea.append(file.getAbsolutePath()+"\t- Success\n");
                        }
                        else
                        textArea.append(file.getAbsolutePath()+"\t- Failed\n");
                    }
                }
                textArea.append("\n\t\tTask is finished");
            }
        });
        thread1.start();
    }

    synchronized private void traverseEncryptionFile(File file){
        File[] files=file.listFiles();
        if(files!=null) for (File file2 : files) {
            if(file2.isDirectory())
            traverseEncryptionFile(file2);
            if(file2.isFile())
            if(isIgnoreVideoFiles(file2) || true){ // ignoring video files
                Security security=new Security(key);
                byte[] fileData=security.getEncryptedData(file2);
                if(fileData!=null){
                    writeFile(file2, fileData);
                    textArea.append(file2.getAbsolutePath()+"\t- Success\n");
                }
                else
                textArea.append(file2.getAbsolutePath()+"\t- Failed\n");
            }
        }
    }

    private void writeFile(File file,byte[] data){
        try{
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(data);
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch(Exception e){

        }
    }

    private boolean isIgnoreVideoFiles(File file){
        String[] fileExten={
            ".mp4",
            ".mov",
            ".wmv",
            ".avi",
            ".avchd",
            ".flv",
            ".f4v",
            ".swf",
            ".mkv",
            ".webm",
            ".html5",
            ".mpeg-2"
        };
        for (String string : fileExten) {
            if(file.getAbsolutePath().endsWith(string))
            return false;
        }
        return true;
    }

    public void initDecryptionTask(Object[] objects){
        textArea.setText("");
        if(isThreadAlive()){
            thread1=new Thread(new Runnable(){
                public void run(){
                    for (Object object : objects) {
                        traverseDecryptionFile(new File((String)object));
                    }
                    textArea.append("\n\t\tTask is finished");  // 12345678901
                }
            });
            thread1.start();
        }
    }

    synchronized private void traverseDecryptionFile(File file){
        File[] files=file.listFiles();
        if(files!=null) for (File file2 : files) {
            if(file2.isDirectory())
            traverseDecryptionFile(file2);
            if(file2.isFile())
            if(isIgnoreVideoFiles(file2) || true){ // ignoring video files
                Security security=new Security(key);
                byte[] fileData=security.getDecryptedData(file2);
                if(fileData!=null){
                    writeFile(file2, fileData);
                    textArea.append(file2.getAbsolutePath()+"\t- Success\n");
                }
                else
                textArea.append(file2.getAbsolutePath()+"\t- Failed\n");
            }
        }
    }

    synchronized public void traverseDecryptionTask(File[] files){
        thread1=new Thread(new Runnable(){
            public void run(){
                for (File file : files) {
                    if(isIgnoreVideoFiles(file) || true){
                        Security security=new Security(key);
                        byte[] fileData=security.getDecryptedData(file);
                        if(fileData!=null){
                            writeFile(file, fileData);
                            textArea.append(file.getAbsolutePath()+"\t- Success\n");
                        }
                        else
                        textArea.append(file.getAbsolutePath()+"\t- Failed\n");
                    }
                }
                textArea.append("\n\t\tTask is finished");
            }
        });
        thread1.start();
    }

    private boolean isThreadAlive(){
        if(thread1!=null) System.out.println(thread1.isAlive());
        System.out.println(thread1!=null);
        if(thread1!=null && thread1.isAlive())
        return false;
        else
        return true;
    }
}
