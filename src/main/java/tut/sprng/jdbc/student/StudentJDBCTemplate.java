package tut.sprng.jdbc.student;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import tut.sprng.jdbc.specialization.Specialization;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void create(int id, String name, int age, int score, Specialization specialization) {
		String SQL = "insert into Student (id, name, age, score, specId) values (?, ?, ?, ?, ?)";

		Integer specId = specialization == null ? null : specialization.getId();
		jdbcTemplate.update(SQL, id, name, age, score, specId);
		System.out.println("Created Record Name = " + name + " Age = " + age);
	}

	public Student getStudent(int id) {
		String SQL = "select * from student where id = ?";
		Student student = jdbcTemplate.queryForObject(SQL,
				new Object[]{id}, new StudentMapper());
		return student;
	}

	public List<Student> listStudents() {
		String SQL = "select * from student";
		List<Student> students = jdbcTemplate.query(SQL,
				new StudentMapper());
		return students;
	}

	public void delete(Integer id) {
		String SQL = "delete from Student where id = ?";
		jdbcTemplate.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
	}

	public void update(Integer id, Integer age) {
		String SQL = "update Student set age = ? where id = ?";
		jdbcTemplate.update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id);
	}

}
