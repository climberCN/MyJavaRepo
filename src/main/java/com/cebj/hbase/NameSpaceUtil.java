package com.cebj.hbase;


import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * 1.创建、删除、查询、判断是否存在名称空间
 */
public class NameSpaceUtil {
    private static Admin admin;

    static {
        Connection conn = ConnectionUtil.getConn();
        if (conn == null) {
            System.out.println("conn 获取失败");
        }
        try {
            admin = conn.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listNameSpace() {
        NamespaceDescriptor[] nsDesc = null;
        try {
            nsDesc = admin.listNamespaceDescriptors();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (NamespaceDescriptor descriptor : nsDesc) {
            System.out.println(descriptor.getName());
        }
    }

    public static void close() {
        try {
            admin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
