package andresdlrg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CAR")
public class Car {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "CAR_ID")
	private String carId;

	@Column(name = "LICENSE_PLATE")
	private String licensePlate;

	@OneToOne
	@JoinColumn(name = "CAR_OWNER_ID")
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
