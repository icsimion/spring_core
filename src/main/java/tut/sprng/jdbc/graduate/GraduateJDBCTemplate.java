package tut.sprng.jdbc.graduate;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import tut.sprng.jdbc.specialization.Specialization;

public class GraduateJDBCTemplate implements GraduateDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void create(int id, String name, int age, int score, Specialization specialization) {
		String SQL = "insert into Graduate (id, name, age, score, specId) values (?, ?, ?, ?, ?)";

		Integer specId = specialization == null ? null : specialization.getId();
		jdbcTemplate.update(SQL, id, name, age, score, specId);
		System.out.println("Created Record Name = " + name + " Age = " + age);
	}

	public Graduate getGraduate(int id) {
		String SQL = "select * from graduate where id = ?";
		Graduate graduate = jdbcTemplate.queryForObject(SQL,
				new Object[]{id}, new GraduateMapper());
		return graduate;
	}

	public List<Graduate> listGraduates() {
		String SQL = "select * from graduate";
		List<Graduate> graduates = jdbcTemplate.query(SQL,
				new GraduateMapper());
		return graduates;
	}

	public void delete(Integer id) {
		String SQL = "delete from Graduate where id = ?";
		jdbcTemplate.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
	}

	public void update(Integer id, Integer age) {
		String SQL = "update Graduate set age = ? where id = ?";
		jdbcTemplate.update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id);
	}

}
