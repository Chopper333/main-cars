package by.grsu.ggrib.cars.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.ggrib.cars.db.dao.AbstractDao;
import by.grsu.ggrib.cars.db.dao.IDao;
import by.grsu.ggrib.cars.db.model.Person;

public class PersonDaoImpl extends AbstractDao implements IDao<Integer, Person>
{
public static final PersonDaoImpl INSTANCE = new PersonDaoImpl();

	private PersonDaoImpl() {
		super();
	}

	@Override
	public void insert(Person entity) {
		try (Connection c = createConnection()){
			PreparedStatement pstmt =c.prepareStatement("insert into person(first_name, last_name, phone_number, passport_id, password, email) values(?,?,?,?,?,?)");
			pstmt.setString(1, entity.getFirstName());
			pstmt.setString(2, entity.getLastName());
			pstmt.setString(3, entity.getPhoneNumber());
			pstmt.setString(4, entity.getPassportId());
			pstmt.setString(5, entity.getPassword());
			pstmt.setString(6, entity.getEmail());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "person"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Person entity", e);
		}
	}

	@Override
	public void update(Person entity) {
		try (Connection c = createConnection()){
			PreparedStatement pstmt =c.prepareStatement("update person set first_name=?,last_name=?, phone_number=?,passport_id=?,password=?,email=? where id=?");
			pstmt.setString(1, entity.getFirstName());
			pstmt.setString(2, entity.getLastName());
			pstmt.setString(3, entity.getPhoneNumber());
			pstmt.setString(4, entity.getPassportId());
			pstmt.setString(5, entity.getPassword());
			pstmt.setString(6, entity.getEmail());
			pstmt.setInt(7, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) 
		{
			throw new RuntimeException("can't update Person entity", e);
		}
	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()){
			PreparedStatement pstmt =c.prepareStatement("delete from person where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Person entity", e);
		}
	}

	@Override
	public Person getById(Integer id) {
		Person entity = null;
		try (Connection c = createConnection()){
			PreparedStatement pstmt =c.prepareStatement("select * from person where id=?");
			pstmt.setInt(1, id);


			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Person entity by id", e);
		}

		return entity;
			}

	@Override
	public List<Person> getAll() {
		List<Person> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()){
			ResultSet rs = c.createStatement().executeQuery("select * from person");
			while (rs.next()) {
				Person entity = rowToEntity(rs);
				entitiesList.add(entity);
		}
	}
		catch (SQLException e) {
			throw new RuntimeException("can't select Person entities", e);
		}

		return entitiesList;
	}

	private Person rowToEntity(ResultSet rs) throws SQLException{
		Person entity = new Person();
		entity.setId(rs.getInt("id"));
		entity.setFirstName(rs.getString("first_name"));
		entity.setLastName(rs.getString("last_name"));
		entity.setPhoneNumber(rs.getString("phone_number"));
		entity.setPassportId(rs.getString("passport_id"));
		entity.setPassword(rs.getString("password"));
		entity.setEmail(rs.getString("email"));
		return entity;
		}
	}
