package by.grsu.ggrib.cars.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.ggrib.cars.db.dao.IDao;
import by.grsu.ggrib.cars.db.model.Person;

public class PersonDaoTest extends AbstractTest
{
	private static final IDao<Integer, Person> dao = PersonDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Person entity = new Person();
		entity.setFirstName("Grisha");
		entity.setLastName("Grib");
		entity.setPhoneNumber("375333128284");
		entity.setPassportId("3215SGRG32KO2");
		entity.setPassword("Qwerty12345");
		entity.setEmail("grisha.grib.03@mail.ru");
		dao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Person entity = new Person();
		entity.setFirstName("Grisha");
		entity.setLastName("Grib");
		entity.setPhoneNumber("375333128284");
		entity.setPassportId("3215SGRG32KO2");
		entity.setPassword("Qwerty12345");
		entity.setEmail("grisha.grib.03@mail.ru");
		dao.insert(entity);

		entity.setFirstName("Roma");
		entity.setLastName("Karachun");
		entity.setPhoneNumber("375291234567");
		entity.setPassportId("3215SGRG32K13");
		entity.setPassword("Qwerty54321");
		entity.setEmail("kara.roma.03@mail.ru");
		dao.update(entity);

		Person updatedEntity = dao.getById(entity.getId());
		Assertions.assertEquals("Roma", updatedEntity.getFirstName());
		Assertions.assertEquals("Karachun", updatedEntity.getLastName());
		Assertions.assertEquals("375291234567", updatedEntity.getPhoneNumber());
		Assertions.assertEquals("3215SGRG32K13", updatedEntity.getPassportId());
		Assertions.assertEquals("Qwerty54321", updatedEntity.getPassword());
		Assertions.assertEquals("kara.roma.03@mail.ru", updatedEntity.getEmail());
	}

	@Test
	public void testDelete() {
		Person entity = new Person();
		entity.setFirstName("Grisha");
		entity.setLastName("Grib");
		entity.setPhoneNumber("375333128284");
		entity.setPassportId("3215SGRG32KO2");
		entity.setPassword("Qwerty12345");
		entity.setEmail("grisha.grib.03@mail.ru");
		dao.insert(entity);

		dao.delete(entity.getId());

		Assertions.assertNull(dao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Person entity = new Person();
		entity.setFirstName("Grisha");
		entity.setLastName("Grib");
		entity.setPhoneNumber("375333128284");
		entity.setPassportId("3215SGRG32KO2");
		entity.setPassword("Qwerty12345");
		entity.setEmail("grisha.grib.03@mail.ru");
		dao.insert(entity);

		Person selectedEntity = dao.getById(entity.getId());

		Assertions.assertEquals(entity.getFirstName(), selectedEntity.getFirstName());
		Assertions.assertEquals(entity.getLastName(), selectedEntity.getLastName());
		Assertions.assertEquals(entity.getPhoneNumber(), selectedEntity.getPhoneNumber());
		Assertions.assertEquals(entity.getPassportId(), selectedEntity.getPassportId());
		Assertions.assertEquals(entity.getPassword(), selectedEntity.getPassword());
		Assertions.assertEquals(entity.getEmail(), selectedEntity.getEmail());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Person entity = new Person();
			entity.setFirstName("Grisha"+i);
			entity.setLastName("Grib"+i);
			entity.setPhoneNumber("375333128284"+i);
			entity.setPassportId("3215SGRG32KO2"+i);
			entity.setPassword("Qwerty12345"+i);
			entity.setEmail("grisha.grib.03@mail.ru"+i);
			dao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, dao.getAll().size());
	}
}
