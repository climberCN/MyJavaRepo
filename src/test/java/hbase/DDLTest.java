package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;

public class DDLTest {
    private static final Configuration conf = HBaseConfiguration.create();
    private static final TableName tn = TableName.valueOf("myns1:tb4");

    @Test
    public void createTableTest() throws IOException {
//        conf.addResource("core-site.xml");
        conf.addResource("hbase-site.xml");
        Connection conn = ConnectionFactory.createConnection(conf);
        Admin admin = conn.getAdmin();

        HTableDescriptor tableDesc = new HTableDescriptor(tn);
        HColumnDescriptor cf1 = new HColumnDescriptor("cf1");
        HColumnDescriptor cf2 = new HColumnDescriptor("cf2");
        HColumnDescriptor cf3 = new HColumnDescriptor("cf3");
        tableDesc.addFamily(cf1);
        tableDesc.addFamily(cf2);
        tableDesc.addFamily(cf3);
        admin.createTable(tableDesc);
        System.out.println("表创建完成");

        admin.close();
        conn.close();
    }
}
