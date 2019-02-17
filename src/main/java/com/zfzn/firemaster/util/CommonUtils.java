package com.zfzn.firemaster.util;

import io.netty.buffer.ByteBuf;

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
     * 计算校验和
     *
     * @param byteBuf
     * @return
     */
    public static int calc(ByteBuf byteBuf) {
        int sum = 0;
        while (byteBuf.readableBytes() >= 2) {
            sum += Integer.parseInt(byteBuf.readBytes(2).toString(UTF_8),16);
        }
        return sum;
    }
}
