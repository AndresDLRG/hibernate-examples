package andresdlrg.model;

public class Car {

	private String carId;
	private String licensePlate;
	private CarOwner owner;

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public CarOwner getOwner() {
		return owner;
	}

	public void setOwner(CarOwner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [");
		if (carId != null) {
			builder.append("carId=");
			builder.append(carId);
			builder.append(", ");
		}
		if (licensePlate != null) {
			builder.append("licensePlate=");
			builder.append(licensePlate);
			builder.append(", ");
		}
		if (owner != null) {
			builder.append("owner=");
			builder.append(owner);
		}
		builder.append("]");
		return builder.toString();
	}

}
