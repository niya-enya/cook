package top.durandal.util;

import top.durandal.statictext.StaticText;

import java.util.Random;

public final class MakeOrderNumber {

    public static String getOrderNumber() {
        String allNum = "0123456789";
        Random random = new Random();
        StringBuffer orderNumber = new StringBuffer();
        for (int i = 0; i < StaticText.ORDER_LENGTH; i++) {
            int number = random.nextInt(10);
            orderNumber.append(allNum.charAt(number));
        }
        return orderNumber.toString();
    }
}
