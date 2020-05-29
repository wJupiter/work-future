package com.wf.workfuture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.iotdb.jdbc.IoTDBSQLException;

/**
 * Created by wangfeng 11:17 2020/5/21
 **/
public class IotJdbcTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.iotdb.jdbc.IoTDBDriver");
        try (Connection connection = DriverManager
            .getConnection("jdbc:iotdb://127.0.0.1:6667/", "root", "root");
            Statement statement = connection.createStatement()) {
            try {
                statement.execute("SET STORAGE GROUP TO root.sg1");
                statement.execute(
                    "CREATE TIMESERIES root.sg1.d1.s1 WITH DATATYPE=INT64, ENCODING=RLE, COMPRESSOR=SNAPPY");
                statement.execute(
                    "CREATE TIMESERIES root.sg1.d1.s2 WITH DATATYPE=INT64, ENCODING=RLE, COMPRESSOR=SNAPPY");
                statement.execute(
                    "CREATE TIMESERIES root.sg1.d1.s3 WITH DATATYPE=INT64, ENCODING=RLE, COMPRESSOR=SNAPPY");
            } catch (IoTDBSQLException e) {
                System.out.println(e.getMessage());
            }

            for (int i = 0; i <= 100; i++) {
                statement.addBatch(
                    "insert into root.sg1.d1(timestamp, s1, s2, s3) values(" + i + "," + 1 + "," + 1
                        + "," + 1 + ")");
            }
            statement.executeBatch();
            statement.clearBatch();

            ResultSet resultSet = statement.executeQuery("select * from root where time <= 10");
            outputResult(resultSet);
            resultSet = statement.executeQuery("select count(*) from root");
            outputResult(resultSet);
            resultSet = statement.executeQuery(
                "select count(*) from root where time >= 1 and time <= 100 group by ([0, 100), 20ms, 20ms)");
            outputResult(resultSet);
        } catch (IoTDBSQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void outputResult(ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            System.out.println("--------------------------");
            final ResultSetMetaData metaData = resultSet.getMetaData();
            final int columnCount = metaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                System.out.print(metaData.getColumnLabel(i + 1) + " ");
            }
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; ; i++) {
                    System.out.print(resultSet.getString(i));
                    if (i < columnCount) {
                        System.out.print(", ");
                    } else {
                        System.out.println();
                        break;
                    }
                }
            }
            System.out.println("--------------------------\n");
        }
    }
}
