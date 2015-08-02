package tut.sprng.jdbc.graduate;


import org.hamcrest.CoreMatchers;
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
@ContextConfiguration(locations = {"classpath*:**/GraduateJDBCTemplateIT-context.xml"})
public class GraduateJDBCTemplateIT {

	@Autowired
	private GraduateJDBCTemplate graduateJDBCTemplate;

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

		graduateJDBCTemplate.create(100, "Success", 33, 99, null);

		String SQL = "select * from graduate where id = ?";
		Graduate graduate = jdbcTemplate.queryForObject(SQL,
				new Object[]{100}, new GraduateMapper());

		assertThat(graduate, is(notNullValue()));

		assertThat(graduate.getName(), is("Success"));
		assertThat(graduate.getAge(), is(33));
		assertThat(graduate.getScore(), is(99));
		assertThat(graduate.getSpecialization(), is(CoreMatchers.nullValue()));
	}

	@Test
	public void testInsertFailed() throws Exception {
		exception.expect(DataIntegrityViolationException.class);

		graduateJDBCTemplate.create(0, "OK", 11, 88, null);
		graduateJDBCTemplate.create(0, "Fail", 22, 77, null);

	}
}