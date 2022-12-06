package by.grsu.ggrib.cars.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import by.grsu.ggrib.cars.db.dao.IDao;
import by.grsu.ggrib.cars.db.dao.impl.CarDaoImpl;
import by.grsu.ggrib.cars.db.dao.impl.ModelDaoImpl;
import by.grsu.ggrib.cars.db.dao.impl.ContractDaoImpl;
import by.grsu.ggrib.cars.db.dao.impl.PersonDaoImpl;
import by.grsu.ggrib.cars.db.model.Car;
import by.grsu.ggrib.cars.db.model.Model;
import by.grsu.ggrib.cars.db.model.Contract;
import by.grsu.ggrib.cars.db.model.Person;
import by.grsu.ggrib.cars.web.dto.CarDto;
import by.grsu.ggrib.cars.web.dto.ContractDto;

public class ContractServlet extends HttpServlet
{
	private static final IDao<Integer, Car> carDao = CarDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Model> modelDao = ModelDaoImpl.INSTANCE;
	private static final IDao<Integer, Contract> contractDao = ContractDaoImpl.INSTANCE;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		System.out.println("doGet");
		String viewParam = req.getParameter("view");
		if ("edit".equals(viewParam)) {
			handleEditView(req, res);
		} else {
			handleListView(req, res);
		}
	}
	

	private void handleListView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		List<Contract> contracts = contractDao.getAll();

		List<ContractDto> dtos = contracts.stream().map((entity) -> {
			ContractDto dto = new ContractDto();
			dto.setId(entity.getId());
			dto.setCarId(entity.getCarId());
			dto.setPersonId(entity.getPersonId());
			dto.setStartTime(entity.getStartTime());
			dto.setEndTime(entity.getEndTime());

			Car car = carDao.getById(entity.getId());
			dto.setModelId(car.getModelId());
			dto.setFuelType(car.getFuelType());
			dto.setTransmission(car.getTransmission());
			dto.setYear(car.getYear());
			dto.setColor(car.getColor());
			dto.setComfortLvl(car.getComfortLvl());
			dto.setPrice(car.getPrice());

			Person person = personDao.getById(entity.getId());
			dto.setFirstName(person.getFirstName());
			dto.setLastName(person.getLastName());
			dto.setPhoneNumber(person.getPhoneNumber());
			dto.setPassportId(person.getPassportId());
			dto.setPassword(person.getPassword());
			dto.setEmail(person.getEmail());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos); 
		req.getRequestDispatcher("requestform.jsp").forward(req, res); 
	}
	
	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String ContractIdStr = req.getParameter("id");
		ContractDto dto = new ContractDto();
		if (!Strings.isNullOrEmpty(ContractIdStr)) 
		{
			Integer contractId = Integer.parseInt(ContractIdStr);
			Contract entity = contractDao.getById(contractId);
			dto.setId(entity.getId());
			dto.setCarId(entity.getCarId());
			dto.setPersonId(entity.getPersonId());
			dto.setStartTime(entity.getStartTime());
			dto.setEndTime(entity.getEndTime());
		}
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("request.jsp").forward(req, res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Contract contract = new Contract();
		String contractIdStr = req.getParameter("id");
		String carIdStr = req.getParameter("carId");
		String personIdStr = req.getParameter("personId");
		
		contract.setCarId(carIdStr == null ? null : Integer.parseInt(carIdStr));
		contract.setPersonId(personIdStr == null ? null : Integer.parseInt(personIdStr));
		contract.setStartTime(new Timestamp(new Date().getTime()));
		contract.setEndTime(new Timestamp(new Date().getTime()));
		if (Strings.isNullOrEmpty(contractIdStr)) 
		{
			contract.setEndTime(new Timestamp(new Date().getTime()));
			contractDao.insert(contract);
		} 
		else 
		{
			// updated entity
			contract.setId(Integer.parseInt(carIdStr));
			contractDao.update(contract);
		}
		res.sendRedirect("/contract");
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		contractDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}
