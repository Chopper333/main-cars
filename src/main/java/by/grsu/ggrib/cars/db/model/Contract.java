package by.grsu.ggrib.cars.db.model;

import java.sql.Timestamp;

public class Contract {

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Contract [id=" + id + ", carId=" + carId + ", personId=" + personId + ", getId()=" + getId()
				+ ", getCarId()=" + getCarId() + ", getPersonId()=" + getPersonId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	private Integer id;
	private Integer carId;
    private Integer personId;
    private Timestamp startTime;
    private Timestamp endTime;
}
