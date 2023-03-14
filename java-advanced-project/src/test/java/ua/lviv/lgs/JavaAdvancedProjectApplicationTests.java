package ua.lviv.lgs;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.common.UniversityService;
import ua.lviv.lgs.common.UserService;
import ua.lviv.lgs.dao.UnivercityRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Role;
import ua.lviv.lgs.domain.Univercity;
import ua.lviv.lgs.domain.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application_test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JavaAdvancedProjectApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UniversityService universityService;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UnivercityRepository univercityRepository;

	@Test
	void userSaveTest() throws IOException {
		Iterable<User> userIterable = userRepository.findAll();
		List<User> userList = new ArrayList<>();
		userIterable.forEach(userList::add);

		Assert.assertTrue(userList.isEmpty());

		User user = new User();
		user.setEmail("test");
		user.setFirstName("test");
		user.setLastName("test");
		user.setPassword("test");
		user.setEncodedImage("1");
		user.setRole(Role.USER);

		userService.save(user);
		userIterable = userRepository.findAll();
		userIterable.forEach(userList::add);
		Assert.assertNotNull(userList);

		User userToCheck = userList.get(0);

		Assert.assertEquals(user.getId(), userToCheck.getId());
		Assert.assertEquals(user.getFirstName(), userToCheck.getFirstName());
		Assert.assertEquals(user.getLastName(), userToCheck.getLastName());
		Assert.assertEquals(user.getEmail(), userToCheck.getEmail());
		Assert.assertEquals(user.getRole(), userToCheck.getRole());
		Assert.assertEquals(user.getPassword(), userToCheck.getPassword());
		Assert.assertEquals(user.getEncodedImage(), userToCheck.getEncodedImage());
		Assert.assertEquals(user.getEnabled(), userToCheck.getEnabled());
	}

	@Test
	void universitySaveTest() {
		Iterable<Univercity> universities = univercityRepository.findAll();
		List<Univercity> universityList = new ArrayList<>();

		universities.forEach(universityList::add);
		Assert.assertEquals(universityList.size(), 0);
		Univercity university = new Univercity();
		Set<Faculty> faculties = new HashSet<>();
		university.setName("test");
		university.setDescription("test");
		university.setCountOfStudents(0L);
		university.setFaculties(faculties);

		univercityRepository.save(university);

		universities = universityService.readAll();

		Assert.assertNotNull(universities);
		universities.forEach(universityList::add);

		Univercity universityToCheck = universityList.get(0);

		Assert.assertEquals(universityToCheck.getName(), university.getName());
		Assert.assertEquals(universityToCheck.getDescription(), university.getDescription());
		Assert.assertEquals(universityToCheck.getRating(), university.getRating());
		Assert.assertEquals(universityToCheck.getCountOfStudents(), university.getCountOfStudents());
	}

	@Test
	void universityFindByIdTest() {
		Univercity university = new Univercity();
		Set<Faculty> faculties = new HashSet<>();
		university.setId(1);
		university.setName("test");
		university.setDescription("test");
		university.setCountOfStudents(0L);
		university.setFaculties(faculties);

		univercityRepository.save(university);

		Univercity foundedById = universityService.findById(1);

		Assert.assertEquals(foundedById.getName(), university.getName());
	}

	@Test
	void universityReadAllTest() {
		List<Univercity> univercityList = new ArrayList<>();
		Assert.assertTrue(univercityList.isEmpty());

		univercityList = universityService.readAll();
		Assert.assertFalse(univercityList.isEmpty());
	}
}
