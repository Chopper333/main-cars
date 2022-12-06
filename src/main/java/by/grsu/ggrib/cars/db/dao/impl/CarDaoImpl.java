package by.grsu.ggrib.cars.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.ggrib.cars.db.dao.AbstractDao;
import by.grsu.ggrib.cars.db.dao.IDao;
import by.grsu.ggrib.cars.db.model.Car;

public class CarDaoImpl extends AbstractDao implements IDao<Integer, Car>
{

	public static final CarDaoImpl INSTANCE = new CarDaoImpl();

	private CarDaoImpl() {
		super();
	}

	@Override
	public void insert(Car entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("insert into car(model_id, fuel_type, transmission, year, color, comfort_lvl, price) values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, entity.getModelId());
			pstmt.setString(2, entity.getFuelType());
			pstmt.setString(3, entity.getTransmission());
			pstmt.setInt(4, entity.getYear());
			pstmt.setString(5, entity.getColor());
			pstmt.setInt(6, entity.getComfortLvl());
			pstmt.setInt(7, entity.getPrice());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "Car"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Car entity", e);
		}

	}

	@Override
	public void update(Car entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("update car set model_id=?, fuel_type=?,transmission=?,year=?,color=?,comfort_lvl=?,price=? where id=?");
			pstmt.setInt(1, entity.getModelId());
			pstmt.setString(2, entity.getFuelType());
			pstmt.setString(3, entity.getTransmission());
			pstmt.setInt(4, entity.getYear());
			pstmt.setString(5, entity.getColor());
			pstmt.setInt(6, entity.getComfortLvl());
			pstmt.setInt(7, entity.getPrice());
			pstmt.setInt(8, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Car entity", e);
		}

	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from car where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Car entity", e);
		}
	}

	@Override
	public Car getById(Integer id) {
		Car entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from car where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Car entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Car> getAll() {
		List<Car> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from car");
			while (rs.next()) {
				Car entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Car entities", e);
		}

		return entitiesList;
	}

	private Car rowToEntity(ResultSet rs) throws SQLException {
		Car entity = new Car();
		entity.setId(rs.getInt("id"));
		entity.setModelId(rs.getInt("model_id"));
		entity.setFuelType(rs.getString("fuel_type"));
		entity.setTransmission(rs.getString("transmission"));
		entity.setYear(rs.getInt("year"));
		entity.setColor(rs.getString("color"));
		entity.setComfortLvl(rs.getInt("comfort_lvl"));
		entity.setPrice(rs.getInt("price"));
		return entity;
	}
}
