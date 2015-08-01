package tut.sprng.jdbc.specialization;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecializationMapper implements RowMapper<Specialization> {
	public Specialization mapRow(ResultSet rs, int rowNum) throws SQLException {
		Specialization specialization = new Specialization();
		specialization.setId(rs.getInt("id"));
		specialization.setName(rs.getString("name"));
		specialization.setDescription(rs.getString("description"));
		return specialization;
	}
}