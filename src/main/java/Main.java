import base.MyConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MyConnection connection = new MyConnection();
//        connection.create("EHB 1005MS", "Ibanez", "electric bass", 5);
//        connection.create("RBX375", "Yamaha", "electric bass", 5);
        connection.update(2, "RBX375", "Yamaha", "electric bass", 5);

//        connection.delete(2, 3, 4, 5);
        System.out.println(connection.read());

    }
}
