package com.hello.way.project.biz.common.utils;

import java.io.*;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 *
 */
public abstract class Utils {

	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static Boolean isEmpty(String str) {
		if(null == str || "".equals(str)){
			return true;
		}
		return false;
	}
	
	public synchronized static String md5(byte[] source) {
		String s = null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };// 用来将字节转换成16进制表示的字符
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest();// MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2];// 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16
			// 进制需要 32 个字符
			int k = 0;// 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) {// 从第一个字节开始，对 MD5 的每一个字节// 转换成 16
				// 进制字符的转换
				byte byte0 = tmp[i];// 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];// 取字节中高 4 位的数字转换,// >>>
				// 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf];// 取字节中低 4 位的数字转换

			}
			s = new String(str);// 换后的结果转换为字符串

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return s;
	}
	 
	public static String bytes2kb(long bytes) {  
        BigDecimal filesize = new BigDecimal(bytes);  
        BigDecimal megabyte = new BigDecimal(1024 * 1024);  
        float returnValue = filesize.divide(megabyte, 2, BigDecimal.ROUND_UP)  
                .floatValue();  
        if (returnValue > 1) {
			return (returnValue + "MB");
		}
        BigDecimal kilobyte = new BigDecimal(1024);  
        returnValue = filesize.divide(kilobyte, 2, BigDecimal.ROUND_UP)  
                .floatValue();  
        return (returnValue + "KB");  
    }  
	
	/** 
     * 获得指定文件的byte数组 
     */  
    public static byte[] getBytes(File file){  
        byte[] buffer = null;
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		try {
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];  
            int n;  
            while ((n = fis.read(b)) != -1) {  
                bos.write(b, 0, n);  
            }  

            buffer = bos.toByteArray();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
        return buffer;  
    }
}
