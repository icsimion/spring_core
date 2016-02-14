package tut.sprng.jdbc.student;


import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:**/StudentJDBCTemplateIT-context.xml"})
public class StudentJDBCTemplateIT {

	@Autowired
	private StudentJDBCTemplate studentJDBCTemplate;

	@Autowired
	private DataSource dataSource;

	JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() throws Exception {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	@DirtiesContext
	public void testInsertSuccess() throws Exception {

		studentJDBCTemplate.create(100, "Success", 33, 99, null);

		String SQL = "select * from student where id = ?";
		Student student = jdbcTemplate.queryForObject(SQL,
				new Object[]{100}, new StudentMapper());

		assertThat(student, is(notNullValue()));

		assertThat(student.getName(), is("Success"));
		assertThat(student.getAge(), is(33));
		assertThat(student.getScore(), is(99));
		assertThat(student.getSpecialization(), is(CoreMatchers.nullValue()));
	}

	@Test
	public void testInsertFailed() throws Exception {
		exception.expect(DataIntegrityViolationException.class);

		studentJDBCTemplate.create(0, "OK", 11, 88, null);
		studentJDBCTemplate.create(0, "Fail", 22, 77, null);

	}

	@After
	public void cleanUp() {
		studentJDBCTemplate.delete(100);
		studentJDBCTemplate.delete(0);

	}
}