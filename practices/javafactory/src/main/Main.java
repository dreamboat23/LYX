package main;

import factory.NameReaderFactory;
import factory.ReaderFactory;
import read.Reader;

public class Main {

	public static void main(String[] args) {
		ReaderFactory factory = new NameReaderFactory();
		Reader reader = factory.getReader();//new NameReader();
		reader.read();
	}

}
