package by.grsu.ggrib.cars.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.ggrib.cars.db.dao.IDao;
import by.grsu.ggrib.cars.db.model.Car;
import by.grsu.ggrib.cars.db.model.Model;

public class CarDaoTest extends AbstractTest {

	private static final IDao<Integer, Model> modelDao = ModelDaoImpl.INSTANCE;
	private static final IDao<Integer, Car> carDao = CarDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Car entity = new Car();
		entity.setModelId(saveModel("BMW", "M5 Compitition").getId());
		entity.setFuelType("petrol");
		entity.setTransmission("Auto");
		entity.setYear(2020);
		entity.setColor("White");
		entity.setComfortLvl(1);
		entity.setPrice(100);
		carDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testInsertWithoutOwner() {
		Car entity = new Car();
		entity.setId(1);
		entity.setModelId(saveModel("BMW", "M5 Compitition").getId());
		entity.setFuelType("petrol");
		entity.setTransmission("Auto");
		entity.setYear(2020);
		entity.setColor("White");
		entity.setComfortLvl(1);
		entity.setPrice(100);
		carDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate()
	{
		Car entity = new Car();
		entity.setId(1);
		entity.setModelId(saveModel("BMW", "M5 Compitition").getId());
		entity.setFuelType("petrol");
		entity.setTransmission("Auto");
		entity.setYear(2020);
		entity.setColor("White");
		entity.setComfortLvl(1);
		entity.setPrice(100);
		carDao.insert(entity);

		Model newModel = saveModel("Volkswagen", "Polo");
		entity.setFuelType("diesel");
		entity.setTransmission("Mechanical");
		entity.setYear(2014);
		entity.setColor("Red");
		entity.setComfortLvl(3);
		entity.setPrice(25);
		
		entity.setModelId(newModel.getId());
		carDao.update(entity);

		Car updatedEntity = carDao.getById(entity.getId());
		Assertions.assertEquals(newModel.getId(), updatedEntity.getModelId());
		Assertions.assertEquals("diesel", updatedEntity.getFuelType());
		Assertions.assertEquals("Mechanical", updatedEntity.getTransmission());
		Assertions.assertEquals(2014, updatedEntity.getYear());
		Assertions.assertEquals("Red", updatedEntity.getColor());
		Assertions.assertEquals(3, updatedEntity.getComfortLvl());
		Assertions.assertEquals(25, updatedEntity.getPrice());
	}

	@Test
	public void testDelete() {
		Car entity = new Car();
		entity.setId(1);
		entity.setModelId(saveModel("BMW", "M5 Compitition").getId());
		entity.setFuelType("petrol");
		entity.setTransmission("Auto");
		entity.setYear(2020);
		entity.setColor("White");
		entity.setComfortLvl(1);
		entity.setPrice(100);
		carDao.insert(entity);

		carDao.delete(entity.getId());

		Assertions.assertNull(carDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Car entity = new Car();
		entity.setModelId(saveModel("BMW", "M5 Compitition").getId());
		entity.setFuelType("petrol");
		entity.setTransmission("Auto");
		entity.setYear(2020);
		entity.setColor("White");
		entity.setComfortLvl(1);
		entity.setPrice(100);
		carDao.insert(entity);

		Car selectedEntity = carDao.getById(entity.getId());

		Assertions.assertEquals(entity.getModelId(), selectedEntity.getModelId());
		Assertions.assertEquals(entity.getFuelType(), selectedEntity.getFuelType());
		Assertions.assertEquals(entity.getTransmission(), selectedEntity.getTransmission());
		Assertions.assertEquals(entity.getYear(), selectedEntity.getYear());
		Assertions.assertEquals(entity.getColor(), selectedEntity.getColor());
		Assertions.assertEquals(entity.getComfortLvl(), selectedEntity.getComfortLvl());
		Assertions.assertEquals(entity.getPrice(), selectedEntity.getPrice());

	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Car entity = new Car();
			entity.setModelId(saveModel("BMW"+i, "M5 Compitition"+i).getId());
			entity.setFuelType("petrol");
			entity.setTransmission("Auto");
			entity.setYear(2020);
			entity.setColor("White");
			entity.setComfortLvl(1);
			entity.setPrice(100);
			carDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, carDao.getAll().size());
	}

	private Model saveModel(String brand, String model) {

		Model modelEntity = new Model();
		modelEntity.setBrend(model);
		modelEntity.setModel(model);
		modelDao.insert(modelEntity);

		return modelEntity;
	}

}
