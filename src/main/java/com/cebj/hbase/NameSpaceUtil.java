package com.cebj.hbase;


import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.NamespaceNotFoundException;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.创建、删除、查询、判断是否存在名称空间
 */
public class NameSpaceUtil {
    private static Connection conn = ConnectionUtil.getConn();

    public static List<String> listNameSpace() {
        Admin admin = null;
        List<String> ret = null;
        try {
            admin = conn.getAdmin();
            ret = new ArrayList<String>();
            for (NamespaceDescriptor nameSpace : admin.listNamespaceDescriptors()) {
                ret.add(nameSpace.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                admin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static boolean createNameSpace(String name) {
        Admin admin = null;
        try {
            admin = conn.getAdmin();
            NamespaceDescriptor nsDes = NamespaceDescriptor.create(name).build();
            admin.createNamespace(nsDes);
            throw new IOException();
//            return true;
        } catch (IOException e) {
            return false;
        } finally {
            System.out.println("++++++++++++++++++++++");
            System.out.println("执行了finally");
            try {
                admin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delNameSpace(String name) {
        Admin admin = null;
        try {
            admin = conn.getAdmin();
            admin.deleteNamespace(name);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                admin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isNameSpaceExists(String name) {
        Admin admin = null;
        try {
            admin = conn.getAdmin();
            admin.getNamespaceDescriptor(name);
        } catch (NamespaceNotFoundException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
