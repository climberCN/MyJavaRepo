package com.cebj.hbase;


import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 1.创建表和删除表，判断表是否存在
 */
public class TableUtil {
    private static Logger logger = LoggerFactory.getLogger(TableUtil.class);
    private static Connection conn = ConnectionUtil.getConn();

    // 验证表名是否合法并返回
    private static TableName checkTableName(String tableName, String nsName) {
        // org.apache.commons.lang.StringUtils用来对字符串检查非常方便
        // 不仅排除了null还排除了空字符串，空白格（空格、Tab）
        if (StringUtils.isBlank(tableName)) {
            logger.error("表名错误：tableName: [{}], namespace: [{}]", tableName, nsName);
            return null;
        }
        return TableName.valueOf(nsName, tableName);
    }

    public static boolean tableExists(String tableName, String nsName) throws IOException {
        // 检查表名
        // TableName是一个不可变类，即final修饰的。其代表了一个表名称，格式是库名：表名
        // checkTableName()这个函数很巧妙，既对参数进行了检查，还创建了TableName对象，减少了我们每个函数中的代码行数
        TableName tn = checkTableName(tableName, nsName);
        // checkTableName()，用来检查传入的表名和ns名，如果合法，返回TableName用来判断表是否存在
        // 如果不合法就返回null，所以对于可能返回null的函数，我们要对null做检查。
        // 如果返回值为null要有相应的处理机制。
        if (tn == null) {
            return false;
        }
        Admin admin = conn.getAdmin();
        boolean tableExists = admin.tableExists(tn);
        admin.close();
        return tableExists;
    }

    // 我们传入的参数，除了表名，ns名，还有可变参数：列族名s
    public static boolean createTable(String tableName, String nsName, String... cfs) throws IOException {
        TableName tn = checkTableName(tableName, nsName);
        if (tn == null) {
            return false;
        }
        // 列族数量至少为1个。
        if (cfs.length < 1) {
            logger.error("创建表失败：tableName: [{}], namespace: [{}]", tableName, nsName);
            logger.error("失败原因：列族个数少于1");
            return false;
        }

        Admin admin = conn.getAdmin();
        // HTableDescriptor是一个表描述器，为什么需要这个东西？因为我们创建表，表的属性很多，分隔符，压缩格式，是否自动切分region，ergion切分策略等
        // 有了这个描述器就很方便，所有的配置都可以考Descriptor来解决
        HTableDescriptor hTableDescriptor = new HTableDescriptor(tn);
        HColumnDescriptor tmp = null;
        // 创建表还需要HColumnDescriptor，这是列族描述器，而不是列。
        for (String cf : cfs) {
            tmp = new HColumnDescriptor(cf);
            hTableDescriptor.addFamily(tmp);
        }
        admin.createTable(hTableDescriptor);
        admin.close();
        return true;
    }

    public static boolean dropTable(String tableName, String nsName) throws IOException {
        // 检查表名
        TableName tn = checkTableName(tableName, nsName);
        if (tn == null) {
            logger.error("创建表失败：tableName: [{}], nsName: [{}], 表名不合法", tableName, nsName);
            return false;
        }
        // 检查表是否存在,要删除表前提是表存在
        if (!tableExists(tableName, nsName)) {
            logger.error("创建表失败：tableName: [{}], nsName: [{}], 该表不存在", tableName, nsName);
            return false;
        }

        Admin admin = conn.getAdmin();
        // 删除之前需要先禁用表
        try {
            admin.disableTable(tn);
            admin.deleteTable(tn);
            return true;
        } catch (IOException e) {
            logger.error("删除表失败：tableName: [{}], naName: [{}], [{}]", tableName, nsName, e.toString());
            return false;
        } finally {
            admin.close();
        }
    }
}
