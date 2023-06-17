package common.pkpass.passkit4j;

import kr.co.starbucks.common.util.pkpass.passkit4j.io.InputStreamSupplier;
import kr.co.starbucks.common.util.pkpass.passkit4j.io.NamedInputStreamSupplier;

import java.io.*;

public class PassResource implements NamedInputStreamSupplier {

	private final String name;
	private final InputStreamSupplier dataSupplier;

	public PassResource(final String name, final ByteArrayInputStream file) {
		this(name, new InputStreamSupplier() {
			@Override
			public InputStream getInputStream() throws IOException {
				return file;
			}
		});
	}

	public PassResource(final String name, final File file) {
		this(name, new InputStreamSupplier() {
			@Override
			public InputStream getInputStream() throws IOException {
				return new FileInputStream(file);
			}
		});
	}

	public PassResource(final String name, final InputStreamSupplier dataSupplier) {
		this.name = name;
		this.dataSupplier = dataSupplier;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return dataSupplier.getInputStream();
	}

}
