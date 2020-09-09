package com.example.lyx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {


	@GetMapping("/readFileByFileInputStream")
	public String readFileByFileInputStream() {
		String result = null;
		try {
			InputStream file = new FileInputStream("C:/JAVA_learn/Java-practice/practices/fileio/pom.xml");
			byte[] bytes = new byte[file.available()];
            int readLength;
            while ((readLength = file.read(bytes)) != -1) {
            	result = new String(bytes);
                System.out.println("本次读取" + readLength + "个字节数据内容为:" + result);
            }
            file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}


	@GetMapping("/readFileByFileReader")
	public char[] readFileByFileReader() {
		File file = new File("C:/JAVA_learn/Java-practice/practices/fileio/pom.xml");
		Reader fileReader = null;
		char[] charArray = new char[2762];
		try {
			fileReader = new FileReader(file);
			fileReader.read(charArray);
			System.out.println(charArray);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return charArray;
	}

	@GetMapping("/writeFileByFileOutputStream")
	public String writeFileByFileOutputStream() {
		String outResult = null;
		try {
			OutputStream  file = new FileOutputStream("C:/JAVA_learn/Java-practice/practices/fileio/pom.xml");
			String outInfo = "写出测试";
			byte[] byteArray = outInfo.getBytes();
			file.write(byteArray);
			outResult = new String(byteArray);
			System.out.println("按照字节流成功写出内容："+outResult);
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
            e.printStackTrace();
        }
		return outResult;
	}

}
