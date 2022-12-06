package by.grsu.ggrib.cars.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.ggrib.cars.db.dao.IDao;
import by.grsu.ggrib.cars.db.model.Car;
import by.grsu.ggrib.cars.db.model.Contract;
import by.grsu.ggrib.cars.db.model.Model;
import by.grsu.ggrib.cars.db.model.Person;

public class ContractDaoTest extends AbstractTest
{
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Model> modelDao = ModelDaoImpl.INSTANCE;
	private static final IDao<Integer, Car> carDao = CarDaoImpl.INSTANCE;
	private static final IDao<Integer, Contract> contractDao = ContractDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Contract entity = new Contract();
		entity.setCarId(saveCar().getId());
		entity.setPersonId(savePerson().getId());
		entity.setStartTime(getCurrentTime());
		entity.setEndTime(getCurrentTime());
		contractDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testInsertWithoutOwner() {
		Contract entity = new Contract();
		entity.setCarId(saveCar().getId());
		entity.setPersonId(savePerson().getId());
		entity.setStartTime(getCurrentTime());
		entity.setEndTime(getCurrentTime());
		contractDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() 
	{
		Contract entity = new Contract();
		entity.setCarId(saveCar().getId());
		entity.setPersonId(savePerson().getId());
		entity.setStartTime(getCurrentTime());
		entity.setEndTime(getCurrentTime());
		contractDao.insert(entity);
		Assertions.assertNotNull(entity.getId());

		Car newCar = saveCar();
		Person newPerson = savePerson();
		entity.setCarId(saveCar().getId());
		entity.setPersonId(savePerson().getId());
		entity.setStartTime(getCurrentTime());
		entity.setEndTime(getCurrentTime());
		entity.setCarId(newCar.getId());
		entity.setPersonId(newPerson.getId());
		contractDao.insert(entity);
		Assertions.assertNotNull(entity.getId());

		Contract updatedEntity = contractDao.getById(entity.getId());
		Assertions.assertEquals(newPerson.getId(), updatedEntity.getPersonId());
		Assertions.assertEquals(newCar.getId(), updatedEntity.getCarId());

	}

	@Test
	public void testDelete() {
		Contract entity = new Contract();
		entity.setCarId(saveCar().getId());
		entity.setPersonId(savePerson().getId());
		entity.setStartTime(getCurrentTime());
		entity.setEndTime(getCurrentTime());
		contractDao.insert(entity);
		contractDao.delete(entity.getId());
		Assertions.assertNull(contractDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Contract entity = new Contract();
		entity.setCarId(saveCar().getId());
		entity.setPersonId(savePerson().getId());
		entity.setStartTime(getCurrentTime());
		entity.setEndTime(getCurrentTime());
		contractDao.insert(entity);

		Contract selectedEntity = contractDao.getById(entity.getId());
		Assertions.assertEquals(entity.getCarId(), selectedEntity.getCarId());
		Assertions.assertEquals(entity.getPersonId(), selectedEntity.getPersonId());

	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Contract entity = new Contract();
			entity.setCarId(saveCar().getId());
			entity.setPersonId(savePerson().getId());
			entity.setStartTime(getCurrentTime());
			entity.setEndTime(getCurrentTime());
			contractDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, contractDao.getAll().size());
	}
	private Contract saveContract()
	{
		Contract contractentity = new Contract();
		contractentity.setCarId(saveCar().getId());
		contractentity.setPersonId(savePerson().getId());
		contractentity.setStartTime(getCurrentTime());
		contractentity.setEndTime(getCurrentTime());
		contractDao.insert(contractentity);

		Person entity = new Person();
		entity.setFirstName("Ivan");
		entity.setLastName("Ivanov");
		entity.setPhoneNumber("+375296856598");
		entity.setPassportId("359grg394342b");
		entity.setPassword("1321513g");
		entity.setEmail("egor.kunickiy.02@mail.ru");
		personDao.insert(entity);

		Model modelEntity = new Model();
		modelEntity.setBrend("Volvo");
		modelEntity.setModel("s60");
		modelDao.insert(modelEntity);

		Car carEntity = new Car();
		carEntity.setModelId(modelEntity.getId());
		carEntity.setFuelType("diesel");
		carEntity.setTransmission("Auto");
		carEntity.setYear(2016);
		carEntity.setColor("Black");
		carEntity.setComfortLvl(1);
		carEntity.setPrice(300);
		carDao.insert(carEntity);

		return contractentity;



	}
	private Person savePerson()
	{
		Person entity = new Person();
		entity.setFirstName("Ivan");
		entity.setLastName("Ivanov");
		entity.setPhoneNumber("+375296856598");
		entity.setPassportId("359grg394342b");
		entity.setPassword("1321513g");
		entity.setEmail("egor.kunickiy.02@mail.ru");
		personDao.insert(entity);
		return entity;
	}

	private Car saveCar()
	{

		Model modelEntity = new Model();
		modelEntity.setBrend("Volvo");
		modelEntity.setModel("s60");
		modelDao.insert(modelEntity);

		Car carEntity = new Car();
		carEntity.setModelId(modelEntity.getId());
		carEntity.setFuelType("diesel");
		carEntity.setTransmission("Auto");
		carEntity.setYear(2016);
		carEntity.setColor("Black");
		carEntity.setComfortLvl(1);
		carEntity.setPrice(300);
		carDao.insert(carEntity);

		return carEntity;
	}
}
