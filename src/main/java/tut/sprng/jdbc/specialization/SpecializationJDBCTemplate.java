package tut.sprng.jdbc.specialization;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecializationJDBCTemplate implements SpecializationDAO {
	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void create(int id, String name, String description) {
		String sql = "insert into specialization (id, name, description) VALUES (:id, :name, :description)";

		Map parameters = new HashMap();
		parameters.put("id", id);
		parameters.put("name", name);
		parameters.put("description", description);

		this.namedParameterJdbcTemplate.update(sql, parameters);
		System.out.println("Created Record Name = " + name);
	}

	public Specialization getSpecialization(Integer id) {
		String SQL = "SELECT * FROM specialization WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));

		Specialization employee = (Specialization) namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, new SpecializationMapper());
		return employee;
	}

	public List<Specialization> listSpecializations() {
		String SQL = "select * from specialization";
		List<Specialization> specializations = namedParameterJdbcTemplate.query(SQL,
				new SpecializationMapper());
		return specializations;
	}

	public void delete(Integer id) {
		String SQL = "delete from specialization where id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Deleted Specialization with id = " + id);
	}

	public void update(Integer id, String description) {
		String SQL = "update specialization set description = :description WHERE id = :id";
		Map parameters = new HashMap();
		parameters.put("id", id);
		parameters.put("description", description);
		SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Updated Specialization with id = " + id);

	}

}