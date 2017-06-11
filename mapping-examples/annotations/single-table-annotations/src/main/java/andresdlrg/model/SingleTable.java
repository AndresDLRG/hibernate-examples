package andresdlrg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SINGLE_TABLE")
public class SingleTable {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "SINGLE_TABLE_ID")
	private String singleTableId;

	@Column(name = "NUMBER")
	private int number;

	@Column(name = "ANOTHER_NUMBER")
	private long anotherNumber;

	@Column(name = "SOME_STRING")
	private String someString;

	public String getSingleTableId() {
		return singleTableId;
	}

	public void setSingleTableId(String singleTableId) {
		this.singleTableId = singleTableId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public long getAnotherNumber() {
		return anotherNumber;
	}

	public void setAnotherNumber(long anotherNumber) {
		this.anotherNumber = anotherNumber;
	}

	public String getSomeString() {
		return someString;
	}

	public void setSomeString(String someString) {
		this.someString = someString;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SingleTable [");
		if (singleTableId != null) {
			builder.append("singleTableId=");
			builder.append(singleTableId);
			builder.append(", ");
		}
		builder.append("number=");
		builder.append(number);
		builder.append(", anotherNumber=");
		builder.append(anotherNumber);
		builder.append(", ");
		if (someString != null) {
			builder.append("someString=");
			builder.append(someString);
		}
		builder.append("]");
		return builder.toString();
	}

}
