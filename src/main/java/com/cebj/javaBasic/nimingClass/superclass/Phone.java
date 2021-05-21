package com.cebj.javaBasic.nimingClass.superclass;

public class Phone extends MerchandiseV2 {
    // 给Phone增加新的属性和方法
    private double screenSize;
    // 这里定义了一个接口引用。匿名类就是用来创建接口或者抽象类的实例的。
    private UnitSpec cpu;
    private UnitSpec memoryG;
    private int storageG;
    private String brand;
    private String os;
    private double speed;
    // 匿名类带来的好处就是，有的地方，我们定义一个类但发现其实只用了一次。没有好多位置去用这个类
    // 那我们再费力去定义一个类其实不太方便，最好就是直接new一个匿名类的对象。

    // 这里我们new了一个接口UnitSpec，在new实例时，语法是new ClassName(args...);
    // 但由于这是一个接口，接口是不能直接new的，因为其没有具体的方法，我们需要实现了该方法，
    // 然后再new对象。匿名类new UnitSpec()后面的大括号中的内容，其实就是一个类，其实现了接口
    // UnitSpec。
    // 可以看到该类是没有名字的，所以叫匿名类。new的是接口，实现它的这个匿名类虽然可以定义
    // 成员变量，但是不能定义构造函数，所以对于实现接口的匿名类，其在new时，就不能传递参数了
    // 实现接口的匿名类也不能implements和extends，只能实现接口
    private UnitSpec anywhere = new UnitSpec() {
        private String test;

        @Override
        public double getNumSpec() {
            return Phone.this.speed;
        }

        @Override
        public String getProducer() {
            return "here";
        }
    };

    // 这里UnitSpecAbs是抽象类，该抽象类中定义了构造函数，因此在new时可以传参数,这参数用来进行初始化赋值
    // 与匿名类实现接口类似，实现抽象类时也需要实现抽象类的抽象方法，即大括号里的实现部分。
    // 其该匿名类也是没有名字的，没有名字就不能implements，不能extends，只能继承抽象类
    private UnitSpecAbs anyWhere = new UnitSpecAbs(1.2, "default") {
        @Override
        public double getNumSpec() {
            return Math.max(Phone.this.speed, this.getSpec());
        }

        @Override
        public String getProducer() {
            return this.getProducerStr();
        }
    };

    // 注意，上述两个匿名类，其实本质是成员内部类。其内部拥有外部类的this指针：Phone.this。
    // 借助这个指针可以访问外部类的private属性和方法

    // 这里我们还是使用匿名类实现了UnitSpec接口。但需要注意，相比之前的位置，这里我们用了
    // private static UnitSpec anywhereStatic，用了static关键字。
    // 所以这里的匿名类本质是静态内部类。其虽然可以访问外部类的private属性和方法，但其内部不存在
    // 指向外部对象的引用，不想成员内部类一样，其拥有Phone.this引用。
    private static UnitSpec anywhereStatic = new UnitSpec() {
        @Override
        public double getNumSpec() {
            return Math.random();
        }

        @Override
        public String getProducer() {
            return "here";
        }
    };


    public Phone(

            String name, String id, int count, double soldPrice, double purchasePrice,
            double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os
    ) {

        double localCPUHZ = cpuHZ;

//        localCPUHZ = Math.random();

        this.screenSize = screenSize;
        // >> TODO 可以像平常的类一样使用局部内部类
        this.speed = cpuHZ;
        // 实际用的比较多的是匿名类和静态内部类（为了单例），成员内部类和局部内部类用的比较少
        // 由于该匿名类实际定义在方法中，所以其本质是一个局部内部类
        // 局部内部类有Phone.this引用，可以轻松访问外部类对象的private属性和方法
        this.cpu = new UnitSpec() {
            @Override
            public double getNumSpec() {
                return Math.max(Phone.this.speed, Math.max(cpuHZ, localCPUHZ));
            }

            @Override
            public String getProducer() {
                return "here";
            }
        };

        this.storageG = storageG;
        this.brand = brand;
        this.os = os;

        this.setName(name);
        this.setId(id);
        this.setCount(count);
        this.setSoldPrice(soldPrice);
        this.setPurchasePrice(purchasePrice);
    }

    public void describePhone() {
        System.out.println("此手机商品属性如下");
        describe();
        System.out.println("手机厂商为" + brand + "；系统为" + os + "；硬件配置如下：\n" +
                "屏幕：" + screenSize + "寸\n" +
                "cpu信息：" + cpu + " \n" +
                "内存" + memoryG.getNumSpec() + "Gb\n" +
                "存储空间" + storageG + "Gb\n");
    }

    public UnitSpec getCpu() {
        return cpu;
    }

    public void setCpu(UnitSpec cpu) {
        this.cpu = cpu;
    }

    public UnitSpec getMemoryG() {
        return memoryG;
    }

    public void setMemoryG(UnitSpec memoryG) {
        this.memoryG = memoryG;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getStorageG() {
        return storageG;
    }

    public void setStorageG(int storageG) {
        this.storageG = storageG;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
