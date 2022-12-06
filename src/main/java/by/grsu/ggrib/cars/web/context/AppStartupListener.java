package by.grsu.ggrib.cars.web.context;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.grsu.ggrib.cars.db.dao.AbstractDao;
import by.grsu.ggrib.cars.db.dao.IDao;
import by.grsu.ggrib.cars.db.dao.impl.PersonDaoImpl;
import by.grsu.ggrib.cars.db.dao.impl.CarDaoImpl;
import by.grsu.ggrib.cars.db.dao.impl.ModelDaoImpl;
import by.grsu.ggrib.cars.db.dao.impl.ContractDaoImpl;
import by.grsu.ggrib.cars.db.model.Person;
import by.grsu.ggrib.cars.db.model.Car;
import by.grsu.ggrib.cars.db.model.Model;
import by.grsu.ggrib.cars.db.model.Contract;

public class AppStartupListener implements ServletContextListener 
{
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Model> modelDao = ModelDaoImpl.INSTANCE;
	private static final IDao<Integer, Car> carDao = CarDaoImpl.INSTANCE;
	private static final IDao<Integer, Contract> contractDao = ContractDaoImpl.INSTANCE;
	
	private static final String DB_NAME = "production-db";

	private void initDb() throws SQLException {
		AbstractDao.init(DB_NAME);
		if (!AbstractDao.isDbExist()) {
			System.out.println(String.format("DB '%s' doesn't exist and will be created", DB_NAME));
			AbstractDao.createDbSchema();
			loadInitialData();
		} else {
			System.out.println(String.format("DB '%s' exists", DB_NAME));
		}
	}

	private void loadInitialData() {
		Model modelEntity = new Model();
		modelEntity.setBrend("VW");
		modelEntity.setModel("Polo");
		modelDao.insert(modelEntity);
		System.out.println("created: " + modelEntity);


		
		Car carEntity = new Car();
		carEntity.setModelId(modelEntity.getId());
		carEntity.setYear(2020);
		carEntity.setFuelType("petrol");
		carEntity.setTransmission("Auto");
		carEntity.setYear(2020);
		carEntity.setColor("White");
		carEntity.setComfortLvl(1);
		carEntity.setPrice(100);
		carDao.insert(carEntity);
		System.out.println("created: " + carEntity);

	
		Person personEntity = new Person();
		personEntity.setFirstName("Grisha");
		personEntity.setLastName("Grib");
		personEntity.setPhoneNumber("375333128284");
		personEntity.setPassportId("3215SGRG32KO2");
		personEntity.setPassword("Qwerty12345");
		personEntity.setEmail("grisha.grib.03@mail.ru");
		personDao.insert(personEntity);
		System.out.println("created: " + personEntity);
		
		Contract contractEntity = new Contract();
		contractEntity.setCarId(carEntity.getId());
		contractEntity.setPersonId(personEntity.getId());
		contractEntity.setStartTime(getCurrentTime());
		contractEntity.setEndTime(getCurrentTime());
		contractDao.insert(contractEntity);
		System.out.println("created: " + contractEntity);
		System.out.println("initial data created");
	}

	private Timestamp getCurrentTime() {
		return new Timestamp(new Date().getTime());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
		try {
			initDb();
		} catch (SQLException e) {
			throw new RuntimeException("can't init DB", e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}
}
