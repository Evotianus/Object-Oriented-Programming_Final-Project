
public class Car {
	
	private String carName;
	private String carType;
	private String carLicensePlate;
	private boolean isCarAvailable;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String carName, String carType, String carLicensePlate, boolean isCarAvailable) {
		super();
		this.carName = carName;
		this.carType = carType;
		this.carLicensePlate = carLicensePlate;
		this.isCarAvailable = isCarAvailable;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
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
