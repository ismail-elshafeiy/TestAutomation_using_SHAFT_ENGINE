package examples.database;

import com.shaft.db.DatabaseActions;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.testng.annotations.Test;

import java.sql.ResultSet;

public class TestDataBase {
	@Test
	public void test_mySQLConnection() {
		// SHOW VARIABLES WHERE Variable_name = 'port'
		// SHOW VARIABLES WHERE Variable_name = 'hostname'
		// https://mistik.trispects.net/phpMyAdmin/index.php?db=&token=4b28aec76eeaa64cca5d16ac6fb833a3&old_usr=dewidar

		DatabaseActions dbActions = new DatabaseActions(DatabaseActions.DatabaseType.MY_SQL, "https://mistik.trispects.net/phpMyAdmin/index.php?", "3306", "school_database", "dewidar", "1234567890mo");
		ResultSet queryResult = dbActions.executeSelectQuery("SELECT * FROM `account`");
		Validations.assertThat().object(DatabaseActions.getResult(queryResult))
				.contains("")
				.perform();
	}
}
