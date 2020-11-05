package com.cebj.hbase;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * 1.帮我们创建和关闭Connection对象
 * 2.如何在HBase中创建一个Configuration对象：可以直接使用HBaseConfiguration.create()，返回的Configuration
 */
public class ConnectionUtil {
    // 这个Configuration是hadoop的Configuration
    private static Configuration conf;
    private static Connection conn;

    static {
        //可以使用这种方式创建Configuration，也可以使用HBaseConfiguration.create()来创建Configuration
        // 差别在于HBaseConfiguration.create()中，调用了addResource("hbase-site.xml"),我们不需要再调用了
        // 我们要连接自己的hbase，那就必须把自己的hbase的相关信息告诉Connection
//        conf = new Configuration();
//        conf.addResource("hbase-site.xml");
        conf = HBaseConfiguration.create();
        try {
            conn = ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        if (conn != null) {
            return conn;
        }
        try {
            conn = ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn) throws IOException {
        if (conn != null) {
            conn.close();
        }
    }
}
