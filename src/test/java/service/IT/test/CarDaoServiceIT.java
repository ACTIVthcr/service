package service.IT.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.jeyni.bean.Car;
import com.jeyni.dao.CarDaoService;
import com.jeyni.service.CarService;

public class CarDaoServiceIT {
	
	@Test
	public void should_create_read_and_delete_a_car() {
		// GIVEN
		String CarUUID = null;
		// WHEN
		CarUUID = CarDaoService.create(Car.builder().name("test1").ownerName("ownertest").build());
		// ASSERT
		assertThat(CarUUID).isNotEmpty();
		assertThat(CarDaoService.read(CarUUID)).isNotNull();
		assertThat(CarDaoService.delete(CarUUID)).isTrue();
	}
	
	@Test
	public void should_update_a_car() {
		// GIVEN
		String newName = "test1_updated";
		String CarUUID = CarDaoService.create(Car.builder().name("test1").ownerName("ownertest").build());
		Car car = CarDaoService.read(CarUUID);
		// WHEN
		car.setName(newName);
		CarService.update(CarUUID, car);
		Car carUpdated = CarService.read(CarUUID);
		// ASSERT
		assertThat(carUpdated.getName()).isEqualToIgnoringCase(newName);
		assertThat(CarDaoService.delete(CarUUID)).isTrue();
	}
	
}
