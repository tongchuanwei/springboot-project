package com.demo.way.project.biz.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @Author: way
 * @Date: 2019-10-18 17:52
 */
public class GzipUtils {

    /**
     * 使用gzip进行压缩
     */
    public static String compress(String primStr) {
        if (primStr == null || primStr.length() == 0) {
            return primStr;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(primStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzip != null) {
                try {
                    gzip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new sun.misc.BASE64Encoder().encode(out.toByteArray());
    }

    /**
     * 使用gzip进行解压缩
     */
    public static String uncompress(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream ginzip = null;
        byte[] compressed = null;
        String decompressed = compressedStr;
        try {
            compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
            in = new ByteArrayInputStream(compressed);
            ginzip = new GZIPInputStream(in);

            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ginzip != null) {
                try {
                    ginzip.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            try {
                out.close();
            } catch (IOException e) {
            }
        }
        return decompressed;
    }

    public static void main(String[] args) {
        String s = "{\"bizOrderNo\":\"HA1185039588194209793\",\"bizType\":\"BATTERY_PULL_EMPTY\",\"carrier\":{\"userName\":\"王战东\",\"userNo\":\"50ce6ced37bc44dabbee25867d9e499a\",\"userTel\":\"18858102101\"},\"consignee\":{\"userName\":\"王战东\",\"userNo\":\"50ce6ced37bc44dabbee25867d9e499a\",\"userTel\":\"18858102101\"},\"creator\":{\"userName\":\"王战东\",\"userNo\":\"50ce6ced37bc44dabbee25867d9e499a\",\"userTel\":\"18858102101\"},\"endAddress\":{\"addressType\":\"WAREHOUSE\",\"latitude\":\"120.118296\",\"longitude\":\"30.286867\"},\"items\":[{\"extraMap\":{\"BATTERY_ITEM_LIST\":\"[{\\\"itemId\\\":1184768554781057025,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768554781057027,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768554785251329,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768554793639938,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768554797834241,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768554797834242,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768554806222850,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768554814611457,\\\"itemType\\\":1,\\\"num\\\":1}]\"},\"itemId\":124,\"itemType\":1,\"num\":1},{\"extraMap\":{\"BATTERY_ITEM_LIST\":\"[{\\\"itemId\\\":1184768555812855810,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768555817050114,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768555829633027,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768555833827331,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768555838021634,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768555842215939,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768555846410242,\\\"itemType\\\":1,\\\"num\\\":1},{\\\"itemId\\\":1184768555850604545,\\\"itemType\\\":1,\\\"num\\\":1}]\"},\"itemId\":161,\"itemType\":1,\"num\":1}],\"requestId\":\"LC2764000439304192\",\"shipper\":{\"userName\":\"王战东\",\"userNo\":\"50ce6ced37bc44dabbee25867d9e499a\",\"userTel\":\"18858102101\"},\"startAddress\":{\"addressType\":\"OTHER\",\"latitude\":\"120.118296\",\"longitude\":\"30.286867\"}}";
        System.out.println(s.length());
        String compressS = GzipUtils.compress(s);
        System.out.println(compressS.length());
    }
}
