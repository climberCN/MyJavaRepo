package com.cebj.javaBasic.interfaceWithDefaultMethod;

import com.cebj.javaBasic.interfaceWithDefaultMethod.supermarket.ExpireDateMerchandise;
import com.cebj.javaBasic.interfaceWithDefaultMethod.supermarket.GamePointCard;

import java.util.Date;

public class UseInterface {
    public static void main(String[] args) {
        Date produceDate = new Date();
        Date expireDate = new Date(produceDate.getTime() + 365L * 24 * 3600 * 1000);

        GamePointCard gamePointCard = new GamePointCard(
                "手机001", "Phone001", 100, 1999, 999,
                produceDate, expireDate
        );

    }
}
