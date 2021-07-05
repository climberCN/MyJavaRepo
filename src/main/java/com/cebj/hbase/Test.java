package com.cebj.hbase;

import com.cebj.flink.demo.BatchWordCount;

import java.io.IOException;

public class Test {
    public BatchWordCount bw1;
    public BatchWordCount bw2;
    public BatchWordCount bw3;
    public BatchWordCount bw4;

    public Test(String file) {
        bw1 = new BatchWordCount();
        bw2 = new BatchWordCount();
        bw3 = new BatchWordCount();
        bw4 = new BatchWordCount();
    }
    public static void main(String[] args) throws IOException {
        Test t = new Test("D:\\VMware\\readme.txt");
        System.out.println(t.bw1);
        System.out.println(t.bw2);
        System.out.println(t.bw3);
        System.out.println(t.bw4);
    }
}
