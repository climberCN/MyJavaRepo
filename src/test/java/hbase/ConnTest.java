package hbase;

import com.cebj.hbase.ConnectionUtil;
import com.cebj.hbase.NameSpaceUtil;
import org.apache.hadoop.hbase.TableName;
import org.junit.Test;

public class ConnTest {
    @Test
    public void test1() {
        System.out.println(ConnectionUtil.getConn());
    }

    @Test
    public void test2() {
        NameSpaceUtil.listNameSpace();
    }
}
