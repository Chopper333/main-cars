package by.grsu.ggrib.cars.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.ggrib.cars.db.dao.AbstractDao;
import by.grsu.ggrib.cars.db.dao.IDao;
import by.grsu.ggrib.cars.db.model.Contract;

public class ContractDaoImpl extends AbstractDao implements IDao<Integer, Contract>
{

	public static final ContractDaoImpl INSTANCE = new ContractDaoImpl();

	private ContractDaoImpl() {
		super();
	}

	@Override
	public void insert(Contract entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("insert into contract(car_id, person_id, start_time, end_time) values(?,?,?,?)");
			pstmt.setInt(1, entity.getCarId());
			pstmt.setInt(2, entity.getPersonId());
			pstmt.setTimestamp(3, entity.getStartTime());
			pstmt.setTimestamp(4, entity.getEndTime());
			pstmt.executeUpdate();


			entity.setId(getGeneratedId(c, "contract"));



		} catch (SQLException e) {
			throw new RuntimeException("can't insert Contract entity", e);
		}

	}

	@Override
	public void update(Contract entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("update contract set car_id=?, person_id=?, start_time=?, end_time=? where id=? ");
			pstmt.setInt(1, entity.getCarId());
			pstmt.setInt(2, entity.getPersonId());
			pstmt.setTimestamp(3, entity.getStartTime());
			pstmt.setTimestamp(4, entity.getEndTime());
		    pstmt.setInt(5, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Contract entity", e);
		}

	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from contract where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Contract entity", e);
		}
	}

	@Override
	public Contract getById(Integer id) {
		Contract entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from contract where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Contract entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Contract> getAll() {
		List<Contract> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from contract");
			while (rs.next()) {
				Contract entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Contract entities", e);
		}

		return entitiesList;
	}

	private Contract rowToEntity(ResultSet rs) throws SQLException {
		Contract entity = new Contract();
		entity.setId(rs.getInt("id"));
		entity.setCarId(rs.getInt("car_id"));
		entity.setPersonId(rs.getInt("person_id"));
		entity.setStartTime(rs.getTimestamp("start_time"));
		entity.setEndTime(rs.getTimestamp("end_time"));
		return entity;
	}
}

