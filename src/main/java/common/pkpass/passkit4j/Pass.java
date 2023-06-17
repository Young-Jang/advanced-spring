package common.pkpass.passkit4j;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import kr.co.starbucks.common.util.pkpass.passkit4j.io.NamedInputStreamSupplier;
import kr.co.starbucks.common.util.pkpass.passkit4j.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain=true, fluent=true)
public class Pass {


	// Standard Keys

	@NonNull private String description;
	@NonNull private String organizationName;
	@NonNull private String passTypeIdentifier;
	@NonNull private String serialNumber;
	@NonNull private String teamIdentifier;

	@JsonProperty("formatVersion") private final int $formatVersion = 1;


	// Visual Appearance Keys

	private Barcode barcode;
	private List<Barcode> barcodes;
	
	private Color backgroundColor;
	private Color foregroundColor;
	private String groupingIdentifier;
	private Color labelColor;
	private String logoText;
	@JsonInclude(Include.NON_DEFAULT) private boolean suppressStripShine = false;


	// Web Service Keys

	private String webServiceURL;
	private String authenticationToken;


	// Relevance Keys
	private boolean ignoresTimeZone = false;
	private List<Location> locations;
	private Integer maxDistance;
	private Date relevantDate;


	// Associated App Keys

	private List<Long> associatedStoreIdentifiers;
	private String appLaunchURL;


	// Companion App Keys

	private JsonNode userInfo;


	// Expiration Keys

	private Date expirationDate;
	@JsonInclude(Include.NON_DEFAULT) private boolean voided = false;



	@JsonIgnore private PassInformation passInformation;
	@JsonIgnore private List<NamedInputStreamSupplier> files;
	
	public List<NamedInputStreamSupplier> files() {
		if (this.files == null) {
			return Collections.emptyList();
		}
		return this.files;
	}

	public Pass files(NamedInputStreamSupplier... values) {
		this.files = Arrays.asList(values);
		return this;
	}

	public Pass locations(List<Location> locations) {
		this.locations = locations;
		return this;
	}

}
