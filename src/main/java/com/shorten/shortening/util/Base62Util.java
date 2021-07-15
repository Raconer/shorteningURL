package com.shorten.shortening.util;

import java.math.BigInteger;

public class Base62Util {
    final static int RADIX = 62;
    final static String CODEC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String encoding(BigInteger param) {
        StringBuffer sb = new StringBuffer();
        if(param.signum() == 0){
            sb.append(CODEC.charAt(0));
        }else{
            while(param.compareTo(BigInteger.ZERO) > 0) {
                sb.append(CODEC.charAt((param.remainder(BigInteger.valueOf(RADIX)).intValue())));
                param = param.divide(BigInteger.valueOf(RADIX));
            }
        }
        return sb.toString();
    }

    public static BigInteger decoding(String param) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger power = BigInteger.ONE;
        for (int i = 0; i < param.length(); i++) {
            int charAt = CODEC.indexOf(param.charAt(i));
            sum = sum.add(power.multiply(BigInteger.valueOf(charAt)));
            power = power.multiply(BigInteger.valueOf(RADIX));
        }
        return sum;
    }
}