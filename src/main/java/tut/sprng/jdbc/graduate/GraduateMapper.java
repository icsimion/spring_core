package tut.sprng.jdbc.graduate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GraduateMapper implements RowMapper<Graduate> {
	public Graduate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Graduate student = new Graduate();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setAge(rs.getInt("age"));
		student.setScore(rs.getInt("score"));
		return student;
	}
}