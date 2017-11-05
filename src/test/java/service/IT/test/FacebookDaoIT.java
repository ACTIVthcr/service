package service.IT.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.jeyni.dao.FacebookDao;

import facebook4j.ResponseList;
import facebook4j.User;

public class FacebookDaoIT {

	@Test
	public void should_find_a_user() {
		// GIVEN
		String userName = "Thomas";
		// WHEN
		ResponseList<User> responseList = FacebookDao.searchUsers(userName);
		// ASSERT
		assertThat(responseList).isNotEmpty();
	}

}
