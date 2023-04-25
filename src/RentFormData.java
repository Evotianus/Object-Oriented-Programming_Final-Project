
public class RentFormData {

	private String carBrand;
	private String carType;
	private String carDescription;
	private String carRentDate;
	private String carLicensePlate;
	private String renterName;
	private String renterAddress;
	private String renterTelephoneNumber;
	private String renterEmailAddress;
	private boolean isCarReturned;
	
	public RentFormData() {
		// TODO Auto-generated constructor stub
	} 	

	public RentFormData(String carBrand, String carType, String carDescription, String carRentDate, String carLicensePlate,
			String renterName, String renterAddress, String renterTelephoneNumber, String renterEmailAddress,
			boolean isCarReturned) {
		super();
		this.carBrand = carBrand;
		this.carType = carType;
		this.carDescription = carDescription;
		this.carRentDate = carRentDate;
		this.carLicensePlate = carLicensePlate;
		this.renterName = renterName;
		this.renterAddress = renterAddress;
		this.renterTelephoneNumber = renterTelephoneNumber;
		this.renterEmailAddress = renterEmailAddress;
		this.isCarReturned = isCarReturned;
	}

	public boolean isCarReturned() {
		return isCarReturned;
	}

	public void setCarReturned(boolean isCarReturned) {
		this.isCarReturned = isCarReturned;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarDescription() {
		return carDescription;
	}

	public void setCarDescription(String carDescription) {
		this.carDescription = carDescription;
	}

	public String getCarRentDate() {
		return carRentDate;
	}

	public void setCarRentDate(String carRentDate) {
		this.carRentDate = carRentDate;
	}

	public String getCarLicensePlate() {
		return carLicensePlate;
	}

	public void setCarLicensePlate(String carLicensePlate) {
		this.carLicensePlate = carLicensePlate;
	}

	public String getRenterName() {
		return renterName;
	}

	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}

	public String getRenterAddress() {
		return renterAddress;
	}

	public void setRenterAddress(String renterAddress) {
		this.renterAddress = renterAddress;
	}

	public String getRenterTelephoneNumber() {
		return renterTelephoneNumber;
	}

	public void setRenterTelephoneNumber(String renterTelephoneNumber) {
		this.renterTelephoneNumber = renterTelephoneNumber;
	}

	public String getRenterEmailAddress() {
		return renterEmailAddress;
	}

	public void setRenterEmailAddress(String renterEmailAddress) {
		this.renterEmailAddress = renterEmailAddress;
	}
	
}
