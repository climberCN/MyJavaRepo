package com.cebj.javaBasic.letmedoit;

import com.cebj.javaBasic.mockThis.MerchandiseV2MockThis;

public class LittleSuperMarket {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public MerchandiseV2[] merchandises;
    public int[] merchandiseSold;

    public void init(String superMarketName, String address, int parkingCount,
                     int merchandiseCount, int count) {
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;

        this.merchandises = new MerchandiseV2[merchandiseCount];
        // 统计用的数组
        this.merchandiseSold = new int[merchandises.length];

        // 遍历并给200种商品赋值
        for (int i = 0; i < merchandises.length; i++) {
            // 创建并给商品的属性赋值
            MerchandiseV2 m = new MerchandiseV2();
            m.name = "商品" + i;
            m.count = count;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = m.purchasePrice * (1 + Math.random());
            m.id = "ID" + i;
            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            merchandises[i] = m;
        }
    }

    // 简单的访问成员变量
    public String getSuperMarketName() {
        return superMarketName;
    }

    public String getAddress() {
        return address;
    }

    public int getParkingCount() {
        return parkingCount;
    }

    public double getIncomingSum() {
        return incomingSum;
    }

    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setParkingCount(int parkingCount) {
        this.parkingCount = parkingCount;
    }

    public void setIncomingSum(double incomingSum) {
        this.incomingSum = incomingSum;
    }

    public void setMerchandises(MerchandiseV2[] merchandises) {
        this.merchandises = merchandises;
    }

    public void setMerchandiseSold(int[] merchandiseSold) {
        this.merchandiseSold = merchandiseSold;
    }

    /**
     * 得到利润最高的商品
     * @return 利润最高的商品
     */
    public MerchandiseV2 getBiggestProfitMerchandise() {
        MerchandiseV2 m = null;
        for (int i = 0; i < merchandises.length; i++) {
            if (m == null || m.calculateProfit() < merchandises[i].calculateProfit()) {
                m = merchandises[i];
            }
        }
        return m;
    }

    /**
     * 根据索引获取商品
     * @param index 索引
     * @return
     */
    public MerchandiseV2 getMerchandiseOf(int index) {
        if (index < 0 || index >= merchandises.length) {
            return null;
        }
        return merchandises[index];
    }

    /**
     * 赚钱
     * @param toBeAdded
     */
    public void addIncomingSum(double toBeAdded) {
        this.incomingSum += toBeAdded;
    }

    /**
     * 花钱
     * @param toBeSpent
     * @return  是否成功
     */
    public boolean spendMoney(double toBeSpent) {
        if (toBeSpent > this.incomingSum) {
            return false;
        }
        incomingSum -= toBeSpent;
        return true;
    }
}
