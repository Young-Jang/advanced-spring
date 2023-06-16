package common.pkpass.passkit4j.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public abstract class PassInformation {

	@JsonIgnore private final String typeName;

	private List<Field<?>> headerFields;
	private List<Field<?>> primaryFields;
	private List<Field<?>> secondaryFields;
	private List<Field<?>> backFields;
	private List<Field<?>> auxiliaryFields;

	protected PassInformation(final String typeName) {
		this.typeName = typeName;
	}

	public String typeName() {
		return this.typeName;
	}

	public PassInformation headerFields(Field<?>... fields) {
		this.headerFields = Arrays.asList(fields);
		return this;
	}

	public PassInformation backFields(Field<?>... fields) {
		this.backFields = Arrays.asList(fields);
		return this;
	}

	public PassInformation auxiliaryFields(Field<?>... fields) {
		this.auxiliaryFields = Arrays.asList(fields);
		return this;
	}

}
