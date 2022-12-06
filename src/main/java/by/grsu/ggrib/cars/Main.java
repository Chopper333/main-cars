package by.grsu.ggrib.cars;

import java.sql.Timestamp;
import java.util.Date;

import by.grsu.ggrib.cars.db.model.Car;
import by.grsu.ggrib.cars.db.model.Contract;
import by.grsu.ggrib.cars.db.model.Model;
import by.grsu.ggrib.cars.db.model.Person;

public class Main {

	public static void main(String[] args) {

		Car car = new Car();

		car.setId(1);
		car.setModelId(1);
		car.setFuelType("diesel");
		car.setTransmission("auto");
		car.setYear(2015);
		car.setColor("Red");
		car.setComfortLvl(2);
		car.setPrice(150);

		System.out.println(car.toString());

		/////////////////

		Contract contract = new Contract();

		contract.setId(1);
		contract.setCarId(1);
		contract.setPersonId(1);
		contract.setStartTime(new Timestamp(new Date().getTime()));
		contract.setEndTime(new Timestamp(new Date().getTime()));

		System.out.println(contract.toString());

		/////////////////

		Model model = new Model();

		model.setId(1);
		model.setBrend("Volkswagen");
		model.setModel("Polo");

		System.out.println(model.toString());

		/////////////

		Person person = new Person();

		person.setId(1);
		person.setFirstName("Grisha");
		person.setLastName("Grib");
		person.setPhoneNumber("375333128284");
		person.setPassportId("GFE24K525K5");
		person.setPassword("QWERTY12345");
		person.setEmail("grisha.grib.03@mail.ru");

		System.out.println(person.toString());

		///////////

	}
}
