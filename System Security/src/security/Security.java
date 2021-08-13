package security;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class Security{
    private static String KEY="10101011010101bhutni5muhi5muhwalishiv"; 
    private String key;
    public Security(String key){
        this.key=key;
    }

    public byte[] getEncryptedData(File file){
        try{
            if(file.length()>Runtime.getRuntime().totalMemory()) // out of heap memory
            return null;

            byte[] key=this.key.getBytes();
            MessageDigest messageDigest=MessageDigest.getInstance("SHA-1");
            key=messageDigest.digest(key);
            key=Arrays.copyOf(key,16);
            SecretKeySpec secretKeySpec=new SecretKeySpec(key,"AES");
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
            FileInputStream fileInputStream=new FileInputStream(file);
            key=cipher.doFinal(fileInputStream.readAllBytes());
            fileInputStream.close();
            return key;
        }catch(Exception e){
            return null;
        }
    }

    public byte[] getEncryptedData(String data){
        try{
            byte[] key=KEY.getBytes();
            MessageDigest messageDigest=MessageDigest.getInstance("SHA-1");
            key=messageDigest.digest(key);
            key=Arrays.copyOf(key,16);
            SecretKeySpec secretKeySpec=new SecretKeySpec(key,"AES");
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
            key=cipher.doFinal(data.getBytes());
            return key;
        }catch(Exception e){
            return null;
        }
    }

    public byte[] getDecryptedData(String data){
        try{
            byte[] key=KEY.getBytes();
            MessageDigest messageDigest=MessageDigest.getInstance("SHA-1");
            key=messageDigest.digest(key);
            key=Arrays.copyOf(key,16);
            SecretKeySpec secretKeySpec=new SecretKeySpec(key,"AES");
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
            key=cipher.doFinal(data.getBytes());
            return key;
        }catch(Exception e){
            return null;
        }
    }

    public byte[] getDecryptedData(File file){
        try{
            if(file.length()>Runtime.getRuntime().totalMemory()) // out of heap memory
            return null;
            byte[] key=this.key.getBytes();
            MessageDigest messageDigest=MessageDigest.getInstance("SHA-1");
            key=messageDigest.digest(key);
            key=Arrays.copyOf(key,16);
            SecretKeySpec secretKeySpec=new SecretKeySpec(key,"AES");
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
            FileInputStream fileInputStream=new FileInputStream(file);
            key=cipher.doFinal(fileInputStream.readAllBytes());
            fileInputStream.close();
            return key;
        }catch(Exception e){
            return null;
        }
    }
}
