package hbase;

import com.cebj.hbase.TableUtil;
import org.junit.Test;

import java.io.IOException;

public class TableUtilTest {
    @Test
    public void testTableExists() throws IOException {
        System.out.println(TableUtil.tableExists("default2",null));
    }

    @Test
    public void testCreateTable() throws IOException {
        System.out.println(TableUtil.createTable("default2", null, "cf1", "cf2", "test"));
    }

    @Test
    public void testDropTable() throws IOException {
        System.out.println(TableUtil.dropTable("default3", null));
    }
}
