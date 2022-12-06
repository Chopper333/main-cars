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
import by.grsu.ggrib.cars.db.model.Car;
import by.grsu.ggrib.cars.db.model.Model;
import by.grsu.ggrib.cars.db.model.Contract;
import by.grsu.ggrib.cars.web.dto.CarDto;

public class CarServlet extends HttpServlet
{
	private static final IDao<Integer, Car> carDao = CarDaoImpl.INSTANCE;
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
		List<Car> cars = carDao.getAll();

		List<CarDto> dtos = cars.stream().map((entity) -> {
			CarDto dto = new CarDto();
	
			dto.setId(entity.getId());
			dto.setModelId(entity.getModelId());
			dto.setFuelType(entity.getFuelType());
			dto.setTransmission(entity.getTransmission());
			dto.setYear(entity.getYear());
			dto.setColor(entity.getColor());
			dto.setComfortLvl(entity.getComfortLvl());
			dto.setPrice(entity.getPrice());

			Model model = modelDao.getById(entity.getModelId());
			dto.setModel(model.getModel());
			dto.setBrend(model.getBrend());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos); 
		req.getRequestDispatcher("freecars.jsp").forward(req, res); 
	}
	
	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String carIdStr = req.getParameter("id");
		CarDto dto = new CarDto();
		if (!Strings.isNullOrEmpty(carIdStr)) 
		{
			Integer carId = Integer.parseInt(carIdStr);
			Car entity = carDao.getById(carId);
			dto.setId(entity.getId());
			dto.setModelId(entity.getModelId());
			dto.setFuelType(entity.getFuelType());
			dto.setTransmission(entity.getTransmission());
			dto.setYear(entity.getYear());
			dto.setColor(entity.getColor());
			dto.setComfortLvl(entity.getComfortLvl());
			dto.setPrice(entity.getPrice());
		}
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("freecars.jsp").forward(req, res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Car car = new Car();
		String carIdStr = req.getParameter("id");
		String modelIdStr = req.getParameter("modelId");
		String YearStr = req.getParameter("year");
		String ComfortLvlStr = req.getParameter("comfort_lvl");
		String PriceStr = req.getParameter("price");
		
		car.setFuelType(req.getParameter("fuel_type"));
		car.setTransmission(req.getParameter("transmission"));
		car.setColor(req.getParameter("color"));
		car.setModelId(modelIdStr == null ? null : Integer.parseInt(modelIdStr));
		if (Strings.isNullOrEmpty(carIdStr)) 
		{
			carDao.insert(car);
		} 
		else 
		{
			car.setId(Integer.parseInt(carIdStr));
			carDao.update(car);
		}
		res.sendRedirect("/car");
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		carDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}
