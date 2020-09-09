package factory;

import read.AgeReader;
import read.Reader;

public class AgeReaderFactory implements ReaderFactory {

	@Override
	public Reader getReader() {
		return new AgeReader();
	}

}
