package hbase;

import com.cebj.hbase.DataUtil;
import org.apache.hadoop.hbase.client.Result;
import org.junit.Test;

import java.io.IOException;

public class DataUtilTest {
    @Test
    public void test1() throws IOException {
        DataUtil.putData("default1", null, "a1", "cf1", "age", "18");
    }

    @Test
    public void test2() throws IOException {
        Result result = DataUtil.getData("t1", "ns1", "a1", "cf1", "age");
        DataUtil.parseResult(result);
    }

    @Test
    public void test3() throws IOException {
        DataUtil.delData("t1", "ns1", "a1", "cf1", "age");
    }
}
