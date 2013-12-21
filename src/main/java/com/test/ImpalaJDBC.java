package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class ImpalaJDBC {
  private static String driverName = "org.apache.hive.jdbc.HiveDriver";

  /**
 * @param args
 * @throws SQLException
   */
  public static void main(String[] args) throws SQLException {
      if (args.length == 0) {
          System.out.println("Usage: ImpalaJDBC <url>");
          System.out.println("       (secure)   jdbc:hive2://impala-host:21050/;principal=user/test.com@TEST.COM");
          System.out.println("       (insecure) jdbc:hive2://impala-host:21050/;auth=noSasl");
          System.exit(1);
      }

    try {
      Class.forName(driverName);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.setProperty("java.security.auth.login.config","gss-jaas.conf");
    System.setProperty("sun.security.jgss.debug","true");
    System.setProperty("javax.security.auth.useSubjectCredsOnly","false");
    System.setProperty("java.security.krb5.conf","krb5.conf");

    String jdbcUrl = args[0];

    Connection con = DriverManager.getConnection(jdbcUrl);

    System.out.println("Connected!");

    Statement stmt = con.createStatement();

    // show tables
    String sql = "show tables";
    System.out.println("Running: " + sql);
    ResultSet res = stmt.executeQuery(sql);
    while (res.next()) {
      System.out.println(res.getString(1));
    }
//    // describe table
//    sql = "describe " + tableName;
//    System.out.println("Running: " + sql);
//    res = stmt.executeQuery(sql);
//    while (res.next()) {
//      System.out.println(res.getString(1) + "\t" + res.getString(2));
//    }
//
//    // load data into table
//    // NOTE: filepath has to be local to the hive server.  The above table
//    // create matches /etc/passwd
//    String filepath = "/etc/passwd";
//    sql = "load data local inpath '" + filepath + "' into table " + tableName;
//    System.out.println("Running: " + sql);
//    stmt.execute(sql);
//
//    // select * query
//    sql = "select * from " + tableName;
//    System.out.println("Running: " + sql);
//    res = stmt.executeQuery(sql);
//    while (res.next()) {
//      System.out.println(String.valueOf(res.getString(1)) + "\t" + res
//        .getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4) +
//        "\t" + res.getString(5) + "\t" + res.getString(6) + "\t" + res
//        .getString(7));
//    }
//
//    // regular hive query
//    sql = "select count(1) from " + tableName;
//    System.out.println("Running: " + sql);
//    res = stmt.executeQuery(sql);
//    while (res.next()) {
//      System.out.println(res.getString(1));
//    }
  }
}

