import java.io.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class LogException {
	String FileName="Logs.txt";
	BufferedWriter writer;
	public LogException() {
		try {
		//writer = new BufferedWriter(new FileWriter(FileName,true));
		}catch(Exception ex1) {
			System.out.println(ex1);
		}
	}
	void logException(Exception ex){
		try {
			writer = new BufferedWriter(new FileWriter(FileName,true));
			//String toWrite = new SimpleDateFormat("yyyy.MM.dd HH : mm : ss").format(new Timestamp(System.currentTimeMillis())) + " : " + ex ; 
			//Files.write(Paths.get(FileName), toWrite.getBytes(), StandardOpenOption.APPEND);
			//System.out.println("fbiugbreoi");
			//System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis())) + " : " + ex);
			writer.write("\n" + new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Timestamp(System.currentTimeMillis())) + " : " + ex);
			writer.close();
		}catch(Exception E) {
			System.out.println("PPP" + E);
		}
		
	}
	void closeFile() {
		try {
		writer.close();
		}catch(Exception ex1) {
			
		}
	}
}
