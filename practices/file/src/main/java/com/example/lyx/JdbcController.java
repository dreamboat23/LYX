package com.example.lyx;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {

	@GetMapping("/readFileByFileInputStream")
	public String readFileByFileInputStream() {
		String result = null;
		try {
			InputStream file = new FileInputStream("C:/JAVA_learn/Java-practice/practices/file/pom.xml");
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

	@GetMapping("/writeFileByFileOutputStream")
	public String writeFileByFileOutputStream() {
		String outResult = null;
		try {
			OutputStream  file = new FileOutputStream("C:/JAVA_learn/outfile.txt");
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

	@GetMapping("/readFileByFileReader")
	public char[] readFileByFileReader() {
		File file = new File("C:/JAVA_learn/Java-practice/practices/file/pom.xml");
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

	@GetMapping("/writeFileByFileWriter")
	public String writeFileByFileWriter() {
		File file = new File("C:/JAVA_learn/outfile.txt");
		Writer fileWriter = null;
		String strInfo = "字符写出数据";
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(strInfo);
			System.out.println("按照字符流成功写出内容："+strInfo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fileWriter != null){
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return strInfo;
	}

	@GetMapping("/copyFile")
	public void copyFile() {
		try {
			InputStream infile = new FileInputStream("C:/JAVA_learn/infile.txt");
			OutputStream outfile = new FileOutputStream("C:/JAVA_learn/outfile.txt");
            while (true) {
                int temp = infile.read();
                if (temp == -1) {
                    break;
                }
                outfile.write(temp);
            }
            System.out.println("拷贝文件成功完成");
			infile.close();
			outfile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/copyFileAfterReplace")
	public void copyFileAfterReplace() throws IOException {
		String srcStr = "student";
		String replaceStr  = "Stu";
		File infile = new File("C:/JAVA_learn/infile.txt");
		File outfile = new File("C:/JAVA_learn/outfile.txt");
		FileReader in = new FileReader(infile);
		FileWriter out = new FileWriter(outfile);
		BufferedReader bufIn = new BufferedReader(in);
		CharArrayWriter tempStream = new CharArrayWriter();
		String line = null;
		while ( (line = bufIn.readLine()) != null) {  
            line = line.replaceAll(srcStr, replaceStr);  
            tempStream.write(line);  
            tempStream.append(System.getProperty("line.separator"));  
        }  
        bufIn.close();
        tempStream.writeTo(out);  
        out.close();
        System.out.println("拷贝修改后文件成功完成");
	}

	@GetMapping("/countCharacter")
	public void countCharacter() throws IOException {
		File infile = new File("C:/JAVA_learn/infile.txt");
		File outfile = new File("C:/JAVA_learn/outfile.txt");
		FileReader in = new FileReader(infile);
		FileWriter out = new FileWriter(outfile);
		BufferedReader bufIn = new BufferedReader(in);
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		String line = null;
		Integer count = 0;
		Integer total = 0;
		while ((line=bufIn.readLine())!=null) {
			char[] ch = line.toCharArray();
			total = total +ch.length;
			for (int i = 0; i < ch.length; i++) {
				ch[i] = Character.toLowerCase(ch[i]);
				count = hm.get(ch[i] + "");
				if (count == null) {
					count = 1;
				}else {
					count++;
				}
				hm.put(ch[i]+"", count);
			}
		}
		for (String str : hm.keySet()) {
			out.write(str+"个数:"+hm.get(str)+"        "+hm.get(str)*100.0/total+"%"+"\n");
			System.out.println(str+"个数:"+hm.get(str)+"        "+hm.get(str)*100.0/total+"%");
		}
		System.out.println("总字母个数："+total);
		System.out.println(hm);
		bufIn.close();
		out.close();
	}

	@GetMapping("/countWords")
	public void countWords() throws IOException {
		File infile = new File("C:/JAVA_learn/infile.txt");
		File outfile = new File("C:/JAVA_learn/outfile.txt");
		FileReader in = new FileReader(infile);
		FileWriter out = new FileWriter(outfile);
		BufferedReader bufIn = new BufferedReader(in);
		StringBuffer sb = new StringBuffer();
		Map<String ,Integer> map = new HashMap<String, Integer>() ;		
		String line = null;
		while ((line=bufIn.readLine())!=null) {
			sb.append(line);
		}
		bufIn.close();
		String str = sb.toString().toLowerCase();
		String[] words = str.split("[^a-zA-Z]+");
		System.out.println(words.toString());
		for(String word :words){
			map.put(word, map.getOrDefault(word, 0)+1);
        }
//		for (String word : words) {
//			if (!map.containsKey(word)) {
//				map.put(word,1);
//			} else {
//				map.put(word,map.get(word)+1);
//			}
//			map.put(word, !map.containsKey(word) ? 1 : map.get(word)+1);
//		}
		for (String strs : map.keySet()) {
			out.write(strs+"个数:"+map.get(strs)+"\n");
		}
		System.out.println(map);
		out.close();
	}

	@GetMapping("/mynewGetOrDefault")
	public void mynewGetOrDefault() throws IOException {
		MyMap<String, Integer> myMap = new MyMap<String, Integer>();

		File infile = new File("C:/JAVA_learn/infile.txt");
		File outfile = new File("C:/JAVA_learn/outfile.txt");
		FileReader in = new FileReader(infile);
		FileWriter out = new FileWriter(outfile);
		BufferedReader bufIn = new BufferedReader(in);
		StringBuffer sb = new StringBuffer();
		String line = null;
		while ((line=bufIn.readLine())!=null) {
			sb.append(line);
		}
		bufIn.close();
		String str = sb.toString().toLowerCase();
		String[] words = str.split("[^a-zA-Z]+");
		for(String word :words){
			myMap.put(word, myMap.newGetOrDefault(word, 0)+1);
		}

		for (String strs : myMap.keySet()) {
			out.write(strs+"个数:"+myMap.get(strs)+"\n");
		}
		System.out.println("myMap: " + myMap);
		out.close();
	}
}
