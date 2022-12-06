package by.grsu.ggrib.cars.db.model;

public class Car {

	private Integer id;
	private Integer modelId;
    private String fuelType;
    private String transmission;
    private Integer year;
    private String color;
    private Integer comfortLvl;
    private Integer price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

   public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

    public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

    public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

     public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

      public Integer getComfortLvl() {
		return comfortLvl;
	}

	public void setComfortLvl(Integer comfortLvl) {
		this.comfortLvl = comfortLvl;
	}

	   public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "participant [id=" + id + ", modelId=" + modelId + ",fuelType=" + fuelType + ",transmission=" + transmission + ",year=" + year + ",color=" + color + ",comfortLvl=" + comfortLvl + ",price=" + price + "]";
	}
}
