package at.technikum.DataAccessLayer;

import at.technikum.interfaces.DataAccessLayer;

import java.sql.Connection;

public class DALFactory {

    private static boolean useMock = false;

    public static void useMock() {
        useMock = true;
    }

    public static DataAccessLayer getDAL() {
        if(useMock) {
            return new DALMockImpl();
        } else {
            Database db = new Database();
            Connection connection = db.connect();
            return new DALImpl(connection);
        }
    }
}