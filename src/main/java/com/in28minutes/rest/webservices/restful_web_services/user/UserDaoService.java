package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
private static List<User> users = new ArrayList<>();

private static int usersCount = 0;

static {
	users.add(new User(++usersCount, "Sunil balla", LocalDate.parse("2002-03-10")));
	users.add(new User(++usersCount, "Nithin kumar", LocalDate.now().minusYears(22)));
	users.add(new User(++usersCount, "Karnakar jodu", LocalDate.now().minusYears(24)));;
}

public List<User> findAll() {
	return users;
}

public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
	return users.stream().filter(predicate).findFirst().orElse(null);
	
	/*for(User user: users) {
		if(user.getId() == id) {
			return user;
		}
	}
return null;
*/
}

public User save(User user) {
	user.setId(++usersCount);
	users.add(user);
	return user;
}

/*public void save(User user) {
	user.setId(++usersCount);
	users.add(user);
}*/

public void delete(int id) {
	users.removeIf(u -> u.getId() == id);
}

public void deleteAll() {
users.clear();	
}

}
