
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import mysql.home.MysqlConfigHome;

public class App {
	static {
		// set system default UI
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) throws Exception {
		new MysqlConfigHome(new JFrame());
		// new App().encrypt();
//        System.out.println("Hello World");
		// new App().readLargeFile();
	}

	private void readLargeFile() {
		try {
			File file = new File("G://New folder//Shaadi Mein Zaroor Aana.mkv");
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] data1 = null;
			int data;
			System.out.println("start reading.....");
			while ((data = fileInputStream.read()) != -1) {
				fileInputStream.read(data1, data, (int) file.length());
			}
			System.out.println(data1);
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	}

	private void encrypt() {
		try {
			File file = new File("G://Ticket//Shivmohan.pdf");
			File file1 = new File("G://Ticket//ShivmohanEncrypted.pdf");
			PdfReader pdfReader = new PdfReader(file.getAbsolutePath());
			PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(file1.getAbsolutePath()));
			pdfStamper.setEncryption("pwd123".getBytes(), "cp123".getBytes(), PdfWriter.ALLOW_COPY,
					PdfWriter.ENCRYPTION_AES_256);
			pdfStamper.close();
			pdfReader.close();
			System.out.println("Pdf Encrypted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
