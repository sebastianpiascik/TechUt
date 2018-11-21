package pl.spiascik.ug.app.service;

import java.util.List;

import pl.spiascik.ug.app.domain.Car;
import pl.spiascik.ug.app.domain.Person;

public interface SellingManager {
	
	void addClient(Person person);
	List<Person> getAllClients();
	void deleteClient(Person person);
	Person findClientByPin(String pin);
	
	Long addNewCar(Car car);
	List<Car> getAvailableCars();
	void disposeCar(Person person, Car car);
	Car findCarById(Long id);

	List<Car> getOwnedCars(Person person);
	void sellCar(Long personId, Long carId);

}
