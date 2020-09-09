package factory;

import read.Reader;
import read.SexReader;

public class SexReaderFactory implements ReaderFactory {

	@Override
	public Reader getReader() {
		return new SexReader();
	}

}
