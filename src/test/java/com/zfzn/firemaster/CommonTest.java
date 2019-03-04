package com.zfzn.firemaster;

import com.zfzn.firemaster.domain.TcpDataPack;
import com.zfzn.firemaster.util.Checksum;
import com.zfzn.firemaster.util.Checksum0;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.zip.DataFormatException;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 静态方法测试
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-14 21:47
 */
public class CommonTest {
    public static void main(String[] args) throws DataFormatException {
        /*ByteBuf byteBuf= Unpooled.copiedBuffer("404001462323",UTF_8);
        while (byteBuf.isReadable()){
            System.out.print(byteBuf.readByte()+"    ");
        }*/
        /*ByteBuf byteBuf= Unpooled.copiedBuffer("1234567890",UTF_8);
        System.out.println(byteBuf.copy(0,6).writeBytes(new byte[]{48,51}).toString(UTF_8));*/
//        mtst(Unpooled.copiedBuffer("404001000101203A091A090C790300000000385B0100000030000202010101280A000200020020202020202020202020202020202020202020202020202020202020202000023A091A090C462323",UTF_8));
        ctst(Unpooled.copiedBuffer("404001000101233A091A090C385B01000000790300000000000003AB2323",UTF_8));
    }

    public static void ctst(ByteBuf byteBuf){
        if(new Checksum(byteBuf).passing()){
            System.out.println("OK");
        }else{
            System.out.println("KO");
        }
    }
    public static void mtst(ByteBuf byteBuf){
        if (new Checksum(byteBuf).passing()) {
            // 确认回答
//            ctx.writeAndFlush(byteBuf.copy(0,48).writeBytes(new byte[]{48,48,48,48,48,51}));
            ByteBuf res=byteBuf.copy(0,24);
            ByteBuf add1=byteBuf.copy(24,12);
            ByteBuf add2=byteBuf.copy(36,12);
            res.writeBytes(add2);
            res.writeBytes(add1);
            res.writeBytes(new byte[]{48,48,48,48,48,51});

            System.out.println(res.toString(UTF_8));

            int len=res.readableBytes();
            byte sum=(byte)(new Checksum0(res.copy(4,len-4)).sum());
            String sumHex=Integer.toString(sum,16);
            char[] arr=sumHex.toCharArray();
            for(int i=0;i<arr.length;i++){
                int n=(int)arr[i];
                res.writeByte(n);
            }
            res.writeBytes(new byte[]{52,48,52,48});
            System.out.println(res.toString(UTF_8));

            TcpDataPack dataPack = new TcpDataPack();
            // original
            dataPack.setOriginal(byteBuf.toString(UTF_8));
            // 得到起始符号
            {
                String low = byteBuf.readBytes(2).toString(UTF_8);
                String high = byteBuf.readBytes(2).toString(UTF_8);
                dataPack.setBeginSign(high + low);
            }
            // 获取流水号
            {
                String low = byteBuf.readBytes(2).toString(UTF_8);
                String high = byteBuf.readBytes(2).toString(UTF_8);
                dataPack.setSerialNumber(high + low);
            }
            // 获取主版本号
            dataPack.setMainVersionNo(Integer.parseInt(byteBuf.readBytes(2).toString(UTF_8), 16));
            // 获取用户版本号
            dataPack.setUserVersionNo(Integer.parseInt(byteBuf.readBytes(2).toString(UTF_8), 16));
            // 获取时间
            dataPack.setTime(DateUtils.bufToDate(byteBuf));
            // 获取源地址
            {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 6; i++) {
                    builder.insert(0, byteBuf.readBytes(2).toString(UTF_8));
                }
                dataPack.setSourceAddress(builder.toString());
            }
            // 获取目标地址
            {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 6; i++) {
                    builder.insert(0, byteBuf.readBytes(2).toString(UTF_8));
                }
                dataPack.setTargetAddress(builder.toString());

            }
            // 获取应用数据单元长度
            int dataLength = 0;
            {
                String low = byteBuf.readBytes(2).toString(UTF_8);
                String high = byteBuf.readBytes(2).toString(UTF_8);
                dataLength = Integer.parseInt(high + low, 16);
                dataPack.setDataLength(dataLength);
            }
            // 获取命令
            {
                String commandStr = byteBuf.readBytes(2).toString(UTF_8);
                dataPack.setCommand(Integer.parseInt(commandStr, 16));
            }
            // 获取应用数据单元
            dataPack.setData(byteBuf.readBytes(2 * dataLength).copy());
            // 获取校验和
            dataPack.setChecksum(byteBuf.readBytes(2).toString(UTF_8));
            // 得到结束符号
            {
                String low = byteBuf.readBytes(2).toString(UTF_8);
                String high = byteBuf.readBytes(2).toString(UTF_8);
                dataPack.setEndSign(high + low);
            }

        } else {
            // 否认回答
            ByteBuf res=byteBuf.copy(0,24);
            ByteBuf add1=byteBuf.copy(24,36);
            ByteBuf add2=byteBuf.copy(36,48);
            res.writeBytes(add2).writeBytes(add1).writeBytes(new byte[]{48,48,48,48,48,54});
            byte sum=(byte)new Checksum(res).sum();
            res.writeBytes(new byte[]{sum}).writeBytes(new byte[]{52,48,52,48});

        }
    }
}