package com.cebj.hbase;

import org.apache.hadoop.hbase.client.Connection;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) throws IOException {
        Connection conn = ConnectionUtil.getConn();
        System.out.println(conn.toString());
    }
}
