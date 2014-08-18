package com.tatianomnom.choozorro;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * TODO add description
 * TODO remove
 */
public class DBTest {
    public static void main(String[] a)
            throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
                getConnection("jdbc:h2:mem:testdb", "sa", "");

        String stmt = "CREATE TABLE PUBLIC.FOO\n" +
                "(\n" +
                "    id int PRIMARY KEY NOT NULL,\n" +
                "    name varchar2  NOT NULL\n" +
                ");";
        // add application code here
        conn.prepareStatement(stmt).execute();
        conn.close();
    }
}
