package service.IT.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jeyni.bean.Car;
import com.jeyni.dao.CarDaoService;

public class CarDaoServiceIT {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
	}

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
	
}
