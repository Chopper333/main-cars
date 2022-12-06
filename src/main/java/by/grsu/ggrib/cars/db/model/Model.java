package by.grsu.ggrib.cars.db.model;

public class Model {

	private Integer id;
    private String brend;
    private String model;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

   public String getBrend() {
		return brend;
	}

	public void setBrend(String brend) {
		this.brend = brend;
	}

    public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "participant [id=" + id + ", brend=" + brend + ",model=" + model + "]";
	}
}
