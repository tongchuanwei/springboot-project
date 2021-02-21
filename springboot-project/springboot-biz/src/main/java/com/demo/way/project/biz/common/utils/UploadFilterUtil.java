package com.demo.way.project.biz.common.utils;

/**
 * @author ：way
 * @date ：Created in 2019/11/26 19:59
 * @description：文件下载过滤器
 */
public class UploadFilterUtil {

    public static String contentType(String fileName) {
        String fix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        if (fix.endsWith("bin")) {
            return "application/octet-stream";
        }
        if (fix.endsWith("zip")) {
            return "application/x-compressed";
        }
        if (fix.endsWith("log")) {
            return "text/xml";
        } else if (fix.endsWith("doc")) {
            return "application/msword";
        } else if (fix.endsWith("txt")) {
            return "text/plain";
        } else if (fix.endsWith("xls")) {
            return "application/vnd.ms-excel";
        } else if (fix.endsWith("mp3")) {
            return "audio/mpeg";
        }
        if (fix.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        }
        if (fix.equalsIgnoreCase("gif")) {
            return "image/gif";
        }
        if (fix.equalsIgnoreCase("jpeg") || fix.equalsIgnoreCase("jpg") || fix.equalsIgnoreCase("png")) {
            return "image/jpeg";
        }
        if (fix.equalsIgnoreCase("html")) {
            return "text/html";
        }
        if (fix.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        }
        if (fix.equalsIgnoreCase("pptx") || fix.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (fix.equalsIgnoreCase("docx")) {
            return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        }
        if (fix.equalsIgnoreCase("pdf")) {
            return "application/pdf";
        }
        if (fix.equalsIgnoreCase("xlsx")) {
            return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        }
        if (fix.equalsIgnoreCase("xml")) {
            return "text/xml";
        }
        return "application/x-compressed";
    }
}
