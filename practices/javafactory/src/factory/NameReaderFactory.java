package factory;

import read.NameReader;
import read.Reader;

public class NameReaderFactory implements ReaderFactory {

	@Override
	public Reader getReader() {
		return new NameReader();
	}

}
