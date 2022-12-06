package by.grsu.ggrib.cars.web.dto;

import java.sql.Timestamp;

public class ContractDto 
{
	private Integer id;

	private Integer carId;

	private Integer personId;
	
	private Timestamp startTime;
	
	private Timestamp endTime;
	
	private Integer modelId;

	private String fuelType;

	private String transmission;

	private Integer year;

	private String color;

	private Integer comfortLvl;

	private Integer price;
	
	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String passportId;

	private String password;

	private String email;
	
	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}
	public Integer getCarId() 
	{
		return carId;
	}

	public void setCarId(Integer carId) 
	{
		this.carId = carId;
	}
	
	public Integer getPersonId() 
	{
		return personId;
	}

	public void setPersonId(Integer personId) 
	{
		this.personId = personId;
	}
	
	public Timestamp getStartTime() 
	{
		return startTime;
	}

	public void setStartTime(Timestamp startTime) 
	{
		this.startTime = startTime;
	}

	public Timestamp getEndTime() 
	{
		return endTime;
	}

	public void setEndTime(Timestamp endTime) 
	{
		this.endTime = endTime;
	}
	public Integer getModelId() 
	{
		return modelId;
	}

	public void setModelId(Integer modelId) 
	{
		this.modelId = modelId;
	}

	public String getFuelType() 
	{
		return fuelType;
	}

	public void setFuelType(String fuelType) 
	{
		this.fuelType = fuelType;
	}
	public String getTransmission() 
	{
		return transmission;
	}

	public void setTransmission(String transmission) 
	{
		this.transmission = transmission;
	}
	
	public Integer getYear() 
	{
		return year;
	}

	public void setYear(Integer year) 
	{
		this.year = year;
	}
	public String getColor() 
	{
		return color;
	}

	public void setColor(String color) 
	{
		this.color = color;
	}
	public Integer getComfortLvl() 
	{
		return comfortLvl;
	}

	public void setComfortLvl(Integer comfortLvl) 
	{
		this.comfortLvl = comfortLvl;
	}
	public Integer getPrice() 
	{
		return price;
	}

	public void setPrice(Integer price) 
	{
		this.price = price;
	}
	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}
	public String getPassportId() 
	{
		return passportId;
	}

	public void setPassportId(String passportId) 
	{
		this.passportId = passportId;
	}
	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
}
