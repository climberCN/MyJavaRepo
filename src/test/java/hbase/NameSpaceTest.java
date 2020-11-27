package hbase;

import com.cebj.hbase.NameSpaceUtil;
import org.junit.After;
import org.junit.Test;

import java.util.List;

public class NameSpaceTest {
    @Test
    public void test1() {
        List<String> strings = NameSpaceUtil.listNameSpace();
        for (String ns : strings) {
            System.out.println(ns);
        }
    }

    @Test
    public void test2() throws InterruptedException {
        boolean ret = NameSpaceUtil.createNameSpace("test");
        System.out.println("返回值为：" + ret);
        test1();
    }

    @Test
    public void test3() {
        System.out.println(NameSpaceUtil.isNameSpaceExists("test"));
    }

    @Test
    public void test4() throws InterruptedException {
        NameSpaceUtil.delNameSpace("ns1");
        test1();
    }
}
