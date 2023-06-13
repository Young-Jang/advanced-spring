package common.pkpass.passkit4j.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true, fluent=true)
@NoArgsConstructor
@RequiredArgsConstructor
public class NumberField implements Field<Number> {

	@NonNull private String key;
	private String label;
	private String changeMessage;
	private TextAlignment textAlignment;
	private String attributedValue;

	@NonNull private Number value;
	private String currencyCode;

	public NumberField(String key, String label, Number value) {
		this(key, value);
		this.label = label;
	}

}
