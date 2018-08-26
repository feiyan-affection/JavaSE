package org.westos.iostream;

import java.io.UnsupportedEncodingException;

public class TestEncoding {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = new String(new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad}, "utf-8");
        System.out.println(s);

        String s2 = new String(new byte[]{(byte) 0xd6, (byte) 0xd0}, "gbk");
        System.out.println(s2);
    }
}
