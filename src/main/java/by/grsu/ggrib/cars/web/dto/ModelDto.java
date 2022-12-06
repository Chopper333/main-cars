package by.grsu.ggrib.cars.web.dto;

import java.sql.Timestamp;

public class ModelDto 
{
	private Integer id;

	private String model;

	private String brend;

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getModel() 
	{
		return model;
	}

	public void setModel(String model) 
	{
		this.model = model;
	}

	public String getBrend() 
	{
		return brend;
	}

	public void setBrend(String brend) 
	{
		this.brend = brend;
	}
}
