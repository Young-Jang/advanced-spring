package common.pkpass.passkit4j;

import java.io.IOException;

public class PassSerializationException extends IOException {

	public PassSerializationException(String message) {
		super(message);
	}

	public PassSerializationException(Throwable cause) {
		super(cause);
	}

	public PassSerializationException(String message, Throwable cause) {
		super(message, cause);
	}

}
