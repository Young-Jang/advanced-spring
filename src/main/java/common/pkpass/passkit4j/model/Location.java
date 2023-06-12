package common.pkpass.passkit4j.model;

import kr.co.starbucks.sbcard.domain.model.sp.aggregates.StoreInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import static kr.co.starbucks.sbcard.domain.constants.applewallet.AppleWalletConstants.NEAR_LOCATION_MESSAGE;

@Data
@Accessors(chain=true, fluent=true)
@NoArgsConstructor
public class Location {

	private double latitude;
	private double longitude;

	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Location(StoreInfo storeInfo) {
		this.latitude = storeInfo.getLatitude();
		this.longitude = storeInfo.getLongitude();
	}

	private String relevantText = NEAR_LOCATION_MESSAGE;

}
