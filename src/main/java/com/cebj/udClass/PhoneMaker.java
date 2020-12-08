package com.cebj.udClass;

public class PhoneMaker {
    public static void main(String[] args) {
        Phone p = new Phone();
        p.hasFigurePrintUnlocker = true;
        p.price = 4999;

        p.screen = new Screen();
        p.screen.producer = "三星";
        p.screen.size = 14;

        p.mainboard = new Mainboard();
        p.mainboard.year = 2020;
        p.mainboard.model = "a8657";

        p.mainboard.cpu = new CPU();
        p.mainboard.cpu.spped = 3.16;
        p.mainboard.cpu.producer = "微软";

        p.mainboard.memory = new Memory();
        p.mainboard.memory.capcacity = 16;
        p.mainboard.memory.producer = "三星";

        p.mainboard.storage = new Storage();
        p.mainboard.storage.capacity = 512;
        p.mainboard.storage.producer = "东芝";
    }
}
