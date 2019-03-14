package com.zfzn.firemaster.util;

import io.netty.buffer.ByteBuf;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 通用工具类
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-03 17:12
 */
public class CommonUtils {
    private static final byte[] H0 = new byte[]{0, 0, 0, 0};
    private static final byte[] H1 = new byte[]{0, 0, 0, 1};
    private static final byte[] H2 = new byte[]{0, 0, 1, 0};
    private static final byte[] H3 = new byte[]{0, 0, 1, 1};
    private static final byte[] H4 = new byte[]{0, 1, 0, 0};
    private static final byte[] H5 = new byte[]{0, 1, 0, 1};
    private static final byte[] H6 = new byte[]{0, 1, 1, 0};
    private static final byte[] H7 = new byte[]{0, 1, 1, 1};
    private static final byte[] H8 = new byte[]{1, 0, 0, 0};
    private static final byte[] H9 = new byte[]{1, 0, 0, 1};
    private static final byte[] HA = new byte[]{1, 0, 1, 0};
    private static final byte[] HB = new byte[]{1, 0, 1, 1};
    private static final byte[] HC = new byte[]{1, 1, 0, 0};
    private static final byte[] HD = new byte[]{1, 1, 0, 1};
    private static final byte[] HE = new byte[]{1, 1, 1, 0};
    private static final byte[] HF = new byte[]{1, 1, 1, 1};

    private static final Pattern PATTERN = Pattern.compile("^[A-F0-9]+$");


    /**
     * 十六进制字符串转二进制
     *
     * @param hexStr 十六进制字符串
     * @return 01数字
     */
    public static byte[] hexToBin(String hexStr) throws DataFormatException {
        hexStr = hexStr.toUpperCase();
        Matcher matcher = PATTERN.matcher(hexStr);
        if (!matcher.matches()) {
            throw new DataFormatException();
        }
        char[] hexChars = hexStr.toCharArray();
        byte[] bytes = new byte[hexChars.length * 4];
        for (int i = 0; i < hexChars.length; i++) {
            switch (hexChars[i]) {
                case '0':
                    System.arraycopy(H0, 0, bytes, i * 4, 4);
                    break;
                case '1':
                    System.arraycopy(H1, 0, bytes, i * 4, 4);
                    break;
                case '2':
                    System.arraycopy(H2, 0, bytes, i * 4, 4);
                    break;
                case '3':
                    System.arraycopy(H3, 0, bytes, i * 4, 4);
                    break;
                case '4':
                    System.arraycopy(H4, 0, bytes, i * 4, 4);
                    break;
                case '5':
                    System.arraycopy(H5, 0, bytes, i * 4, 4);
                    break;
                case '6':
                    System.arraycopy(H6, 0, bytes, i * 4, 4);
                    break;
                case '7':
                    System.arraycopy(H7, 0, bytes, i * 4, 4);
                    break;
                case '8':
                    System.arraycopy(H8, 0, bytes, i * 4, 4);
                    break;
                case '9':
                    System.arraycopy(H9, 0, bytes, i * 4, 4);
                    break;
                case 'A':
                    System.arraycopy(HA, 0, bytes, i * 4, 4);
                    break;
                case 'B':
                    System.arraycopy(HB, 0, bytes, i * 4, 4);
                    break;
                case 'C':
                    System.arraycopy(HC, 0, bytes, i * 4, 4);
                    break;
                case 'D':
                    System.arraycopy(HD, 0, bytes, i * 4, 4);
                    break;
                case 'E':
                    System.arraycopy(HE, 0, bytes, i * 4, 4);
                    break;
                case 'F':
                    System.arraycopy(HF, 0, bytes, i * 4, 4);
                    break;
            }
        }
        return bytes;
    }

    /**
     * 将int型数组转为若干8位二进制数组
     *
     * @param numArr
     * @return
     */
    public static byte[] byteArrayTo8BinArray(byte[] numArr) {
        int numLen = numArr.length << 3;
        byte[] binArr = new byte[numLen];
        for (int i = 0; i < numArr.length; i++) {
            byte[] binArr0 = intTo8BinArray(numArr[i]);
            // 将binArr0的元素复制到binArr相应的位置
            System.arraycopy(binArr0, 0, binArr, i << 3, 8);
        }
        return binArr;
    }

    /**
     * 将一个int转化为8位二进制
     *
     * @param num
     * @return
     */
    public static byte[] intTo8BinArray(int num) {
        byte[] binArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            binArr[7 - i] = (byte) (num & 1);
            num = num >> 1;
        }
        return binArr;
    }

    /**
     * 将byte[]数组转为int[]
     *
     * @param byteArr
     * @return
     */
    private static byte[] intArrayToByteArray(int[] byteArr) {
        byte[] intArr = new byte[byteArr.length];
        for (int i = 0; i < byteArr.length; i++) {
            intArr[i] = (byte) byteArr[i];
        }
        return intArr;
    }


    /**
     * 将一个int转化为2位16进制的String
     *
     * @param nt
     * @return
     */
    public static String intTo2Hex(int nt) {
        String hex = Integer.toHexString(nt);
        if (hex.length() % 2 != 0) {
            hex = "0" + hex;
        }
        return hex;
    }

    /**
     * 将int转化为16进制的字节数组
     *
     * @param n
     * @return
     */
    public static byte[] intToHexBytes(int n) {
        return CommonUtils.intTo2Hex(n).getBytes(UTF_8);
    }

    /**
     * 将一个int转化为2位16进制的String
     * 低位在前，高位在后
     *
     * @param nt
     * @return
     */
    public static String intTo4Hex(int nt) {
        String hex = Integer.toHexString(nt);
        if (hex.length() % 2 != 0) {
            hex = "0" + hex;
        }
        if (hex.length() == 4) {
            String high = hex.substring(0, 2);
            String low = hex.substring(2, 4);
            hex = low + high;
        } else if (hex.length() == 2) {
            hex = hex + "00";
        }
        return hex;
    }

    /**
     * 计算校验和
     *
     * @param buf
     * @return
     */
    private static int countSum(ByteBuf buf) {
        int sum = 0;
        while (buf.readableBytes() >= 2) {
            sum += Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
        }
        return sum;
    }
}
