package com.cebj.hbase;


import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 1.数据的增删改查
 */
public class DataUtil {
    private static Logger logger = LoggerFactory.getLogger(DataUtil.class);
    private static Connection conn = ConnectionUtil.getConn();

    private static TableName checkTableName(String tableName, String nsName) {
        if (StringUtils.isBlank(tableName)) {
            logger.error("表名错误：tableName: [{}], namespace: [{}]", tableName, nsName);
            return null;
        }
        return TableName.valueOf(nsName, tableName);
    }

    private static Table getTable(String tableName, String nsName) throws IOException {
        TableName tn = checkTableName(tableName, nsName);
        if (tn == null) {
            return null;
        }
        return conn.getTable(tn);
    }

    // 增和改都是1个API
    public static boolean putData(String  tableName, String nsName, String rowkey, String cf, String column, String value) throws IOException {
        Table table = getTable(tableName, nsName);
        if (table == null) {
            logger.error("获取table失败：tableName: [{}], nsName: [{}]", tableName, nsName);
            return false;
        }
        // 对于数据插入，Put代表插入一条数据，Put构造函数定义了插入的rowkey
        Put put = new Put(Bytes.toBytes(rowkey));
        // 插入的数据则需要put.addColumn()来定义，addColumn()实际上是插入一个cell，
        // 如果我们要插入多个cell可以对addColumn()使用链式调用
        put.addColumn(Bytes.toBytes(cf), Bytes.toBytes(column), Bytes.toBytes(value));
        try {
            table.put(put);
            return true;
        } catch (IOException e) {
            logger.error("插入数据失败：rowkey: [{}], cf: [{}], column: [{}], value: [{}]", rowkey, cf, column, value);
            logger.error(e.toString());
            return false;
        } finally {
            table.close();
        }
    }

    public static Result getData(String tableName, String nsName, String rowkey, String cf, String column) throws IOException {
        Table table = getTable(tableName, nsName);
        if (table == null) {
            logger.error("获取table失败：tableName: [{}], nsName: [{}]", tableName, nsName);
            return null;
        }
        // get可以读取一行，可以读取一个列族，也可以读取一个列，具体看我们对Get进行了怎样的配置
        // 如果只是new Get(Bytes.toBytes(rowkey))那就得到完整的一行数据，如果addFamily，那就得到该行的某个列族的所有数据
        // 但不沦怎样，我们得到的都是某个的某几列的信息，只不过addFamily()，或addColumn()对一整行的列进行了筛选。
        Get get = new Get(Bytes.toBytes(rowkey));
        get.addFamily(Bytes.toBytes(cf));
        get.addColumn(Bytes.toBytes(cf), Bytes.toBytes(column));
        try {
            Result result = table.get(get);
            return result;
        } catch (IOException e) {
            logger.error("查询数据失败：[{}]", e.toString());
            return null;
        } finally {
            table.close();
        }
    }

    public static void parseResult(Result result) {
        if (result == null) {
            return;
        }
        for (Cell cell : result.rawCells()) {
            System.out.println("列族：" + Bytes.toString(CellUtil.cloneFamily(cell)) +
                    "列名:" + Bytes.toString(CellUtil.cloneQualifier(cell)) +
                    "值：" + Bytes.toString(CellUtil.cloneValue(cell)));
        }
    }

    // delete "表名","rowkey",[列族],[列],[ts]
    public static boolean delData(String tableName, String nsName, String rowkey, String cf, String column) throws IOException {
        Table table = getTable(tableName, nsName);
        if (table == null) {
            logger.error("删除失败，未获取到表 tableName: [{}], nsName: [{}]", tableName, nsName);
            return false;
        }
        Delete del = new Delete(Bytes.toBytes(rowkey));
        // 注意：addColumn()只是删除该cell最新的version
        del.addColumn(Bytes.toBytes(cf), Bytes.toBytes(column));
        // 而addColumns()才是删除该cell的所有version
        del.addColumns(Bytes.toBytes(cf), Bytes.toBytes(column));
        try {
            table.delete(del);
            return true;
        } catch (IOException e) {
            logger.error("删除表失败，tableName: [{}], nsName: [{}]; [{}]", tableName, nsName, e.toString());
            return false;
        } finally {
            table.close();
        }
    }
}
