
public class Car {
	
	private String carBrand;
	private String carType;
	private String carDescription;
	private String carLicensePlate;
	private boolean isCarAvailable;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String carBrand, String carType, String carDescription, String carLicensePlate, boolean isCarAvailable) {
		super();
		this.carBrand = carBrand;
		this.carType = carType;
		this.carDescription = carDescription;
		this.carLicensePlate = carLicensePlate;
		this.isCarAvailable = isCarAvailable;
	}

	public String getCarName() {
		return carBrand;
	}

	public void setCarName(String carBrand) {
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
	
	public String getCarLicensePlate() {
		return carLicensePlate;
	}

	public void setCarLicensePlate(String carLicensePlate) {
		this.carLicensePlate = carLicensePlate;
	}

	public boolean isCarAvailable() {
		return isCarAvailable;
	}

	public void setCarAvailable(boolean isCarAvailable) {
		this.isCarAvailable = isCarAvailable;
	}
	
}
