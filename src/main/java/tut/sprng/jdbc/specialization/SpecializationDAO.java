package tut.sprng.jdbc.specialization;

import javax.sql.DataSource;
import java.util.List;

public interface SpecializationDAO {
	/**
	 * This is the method to be used to initialize
	 * database resources ie. connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create
	 * a record in the Specialization table.
	 */
	public void create(int id, String name, String description);

	/**
	 * This is the method to be used to list down
	 * a record from the Specialization table corresponding
	 * to a passed specialization id.
	 */
	public Specialization getSpecialization(Integer id);

	/**
	 * This is the method to be used to list down
	 * all the records from the Specialization table.
	 */
	public List<Specialization> listSpecializations();

	/**
	 * This is the method to be used to delete
	 * a record from the Specialization table corresponding
	 * to a passed specialization id.
	 */
	public void delete(Integer id);

	/**
	 * This is the method to be used to update
	 * a record into the Specialization table.
	 */
	public void update(Integer id, String description);
}
