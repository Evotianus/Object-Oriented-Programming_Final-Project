
public class ReturnFormData {

	private String carBrand;
	private String carType;
	private String carRentDate;
	private String carReturnDate;
	private String carLicensePlate;
	private String renterName;
	private int renterFine;
	
	public ReturnFormData() {
		// TODO Auto-generated constructor stub
	}

	public ReturnFormData(String carBrand, String carType, String carRentDate, String carReturnDate,
			String carLicensePlate, String renterName, int renterFine) {
		super();
		this.carBrand = carBrand;
		this.carType = carType;
		this.carRentDate = carRentDate;
		this.carReturnDate = carReturnDate;
		this.carLicensePlate = carLicensePlate;
		this.renterName = renterName;
		this.renterFine = renterFine;
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

	public String getCarRentDate() {
		return carRentDate;
	}

	public void setCarRentDate(String carRentDate) {
		this.carRentDate = carRentDate;
	}

	public String getCarReturnDate() {
		return carReturnDate;
	}

	public void setCarReturnDate(String carReturnDate) {
		this.carReturnDate = carReturnDate;
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

	public int getRenterFine() {
		return renterFine;
	}

	public void setRenterFine(int renterFine) {
		this.renterFine = renterFine;
	}
	
}
