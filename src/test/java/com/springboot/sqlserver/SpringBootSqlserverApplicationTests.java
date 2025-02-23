package com.springboot.sqlserver;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
class SpringBootSqlserverApplicationTests {
/*
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private IRepository repository;

	@Autowired
	private ObjectMapper objectMapper;

	private static List<EmployeeRequest> employees = new ArrayList<>();

	@Container
	private static final MSSQLServerContainer<?> SQLSERVER_CONTAINER = new MSSQLServerContainer<>(
			"mcr.microsoft.com/mssql/server:2022-latest").acceptLicense();

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.datasource.url", SQLSERVER_CONTAINER::getJdbcUrl);
		dynamicPropertyRegistry.add("spring.datasource.username", SQLSERVER_CONTAINER::getUsername);
		dynamicPropertyRegistry.add("spring.datasource.password", SQLSERVER_CONTAINER::getPassword);
	}
	
	static {
		SQLSERVER_CONTAINER.start();
	}
	

	static {

		EmployeeRequest emp1 = EmployeeRequest.builder().name("test emp1").address("address1").build();
		EmployeeRequest emp2 = EmployeeRequest.builder().name("test emp2").address("address2").build();
		EmployeeRequest emp3 = EmployeeRequest.builder().name("test emp3").address("address3").build();
		EmployeeRequest emp4 = EmployeeRequest.builder().name("test emp4").address("address4").build();
		EmployeeRequest emp5 = EmployeeRequest.builder().name("test emp5").address("address5").build();

		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
	}

	@Test
	@Order(value = 1)
	void testConnectionToDatabase() {
		Assertions.assertNotNull(repository);
	}

	@Test
	@Order(value = 2)
	void testAddEmployees() throws Exception {
		for (EmployeeRequest employee : employees) {
			String emp = objectMapper.writeValueAsString(employee);
			mockMvc.perform(
					MockMvcRequestBuilders.post("/api/v1/employees").contentType(MediaType.APPLICATION_JSON).content(emp))
					.andExpect(status().isCreated());
		}
		Assertions.assertEquals(5, repository.findAll().size());
	}

	@Test
	@Order(value = 3)
	void testGetAllEmployees() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees")).andExpect(status().isOk());
		Assertions.assertEquals(employees.get(3).getName(), repository.findById(4).get().getName());
	}

	@Test
	@Order(value = 4)
	void testGetEmployeeById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees/2")).andExpect(status().isOk());
		Assertions.assertEquals(employees.get(1).getName(), repository.findById(2).get().getName());
	}

	@Test
	@Order(value = 5)
	void testDeleteEmployeeById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/employees/2")).andExpect(status().isOk());
	}

	@Test
	@Order(value = 6)
	void testUpdateEmployee() throws Exception {
		Employee employee = Employee.builder().id(3).name("Saurav Kumar Shah").address("India East").build();
		String emp = objectMapper.writeValueAsString(employee);
		mockMvc.perform(
				MockMvcRequestBuilders.put("/api/v1/employees").contentType(MediaType.APPLICATION_JSON).content(emp))
				.andExpect(status().isOk());
		Assertions.assertEquals(employee.getName(), repository.findById(3).get().getName());
	}

	@Test
	@Order(value = 7)
	void testDeleteAllEmployees() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/employees")).andExpect(status().isOk());
		Assertions.assertEquals(0, repository.findAll().size());
	}*/

}
