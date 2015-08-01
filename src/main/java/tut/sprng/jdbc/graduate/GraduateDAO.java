package tut.sprng.jdbc.graduate;

import tut.sprng.jdbc.specialization.Specialization;

import javax.sql.DataSource;
import java.util.List;

public interface GraduateDAO {
	/**
	 * This is the method to be used to initialize
	 * database resources ie. connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create
	 * a record in the Graduate table.
	 */
	public void create(int id, String name, int age, int score, Specialization specialization);

	/**
	 * This is the method to be used to list down
	 * a record from the Graduate table corresponding
	 * to a passed graduate id.
	 */
	public Graduate getGraduate(int id);

	/**
	 * This is the method to be used to list down
	 * all the records from the Graduate table.
	 */
	public List<Graduate> listGraduates();

	/**
	 * This is the method to be used to delete
	 * a record from the Graduate table corresponding
	 * to a passed graduate id.
	 */
	public void delete(Integer id);

	/**
	 * This is the method to be used to update
	 * a record into the Graduate table.
	 */
	public void update(Integer id, Integer age);
}