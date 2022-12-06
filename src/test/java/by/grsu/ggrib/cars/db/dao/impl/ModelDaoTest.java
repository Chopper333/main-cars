package by.grsu.ggrib.cars.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.ggrib.cars.db.dao.IDao;
import by.grsu.ggrib.cars.db.model.Model;

public class ModelDaoTest extends AbstractTest 
{
	private static final IDao<Integer, Model> dao = ModelDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Model entity = new Model();
		entity.setBrend("VW");
		entity.setModel("Polo");
		dao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Model entity = new Model();
		entity.setBrend("VW");
		entity.setModel("Polo");
		dao.insert(entity);

		entity.setBrend("BMW");
		entity.setModel("M3");
		dao.update(entity);

		Model updatedEntity = dao.getById(entity.getId());
		Assertions.assertEquals("BMW", updatedEntity.getBrend());
		Assertions.assertEquals("M3", updatedEntity.getModel());
	}

	@Test
	public void testDelete() {
		Model entity = new Model();
		entity.setBrend("VW");
		entity.setModel("Polo");
		dao.insert(entity);

		dao.delete(entity.getId());

		Assertions.assertNull(dao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Model entity = new Model();
		entity.setBrend("VW");
		entity.setModel("Polo");
		dao.insert(entity);

		Model selectedEntity = dao.getById(entity.getId());

		Assertions.assertEquals(entity.getBrend(), selectedEntity.getBrend());
		Assertions.assertEquals(entity.getModel(), selectedEntity.getModel());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Model entity = new Model();
			entity.setBrend("VW" + i); 
			entity.setModel("Polo"+ i);
			dao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, dao.getAll().size());
	}
}
