package com.hello.way.project.biz.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/*
*  <p>
*  封装http请求相关请求方式
*  支持httpGet，httpGetStream，httpGetByte 数据返回格式
*  支持post json，post formData，post file 多种请求方式
*  <p>
*  @author way
*  @version 1.0,2019年11月26日
*/

public class OkHttpUtils {
    public final static int CONNECT_TIMEOUT = 60;
    public final static int READ_TIMEOUT = 60;
    public final static int WRITE_TIMEOUT = 60;
    public static OkHttpClient mOkHttpClient =
            new OkHttpClient.Builder()
                    //设置读取超时时间
                    .readTimeout(READ_TIMEOUT,TimeUnit.SECONDS)
                    //设置写的超时时间
                    .writeTimeout(WRITE_TIMEOUT,TimeUnit.SECONDS)
                    //设置连接超时时间
                    .connectTimeout(CONNECT_TIMEOUT,TimeUnit.SECONDS)
                    //设置请求头
                    //.addInterceptor(new RequestInterceptor())
                    .build();
    private static final String CHARSET_NAME = "UTF-8";
    public static final MediaType JSON_TYPE
            = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");

    private static Logger logger = LoggerFactory.getLogger(OkHttpUtils.class);

    /**
     * 不开启异步线程。
     * @param request
     * @return
     * @throws IOException
     */
    public static Response execute(Request request) throws IOException {
        return mOkHttpClient.newCall(request).execute();
    }
    /**
     * 开启异步线程访问网络
     * @param request
     * @param responseCallback
     */
    public static void enqueue(Request request, Callback responseCallback){
        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }
    /**
     * 开启异步线程访问网络, 且不在意返回结果（实现空callback）
     * @param request
     */
    public static void enqueue(Request request){
        mOkHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    /**
     * get获取服务器数据
     * @param url 请求url
     * @return String 返回数据
     * @throws IOException
     */
    public static String httpGetRequest(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            String responseUrl = response.body().string();
            return responseUrl;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * get获取服务器文件流数据
     * @param url 请求url
     * @return String 返回数据
     * @throws IOException
     * @param url
     * @return
     * @throws IOException
     */
    public static InputStream httpGetStream(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            InputStream inputStream = response.body().byteStream();
            return inputStream;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


    public static byte[] httpGetByte(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            byte[] bytes = response.body().bytes();
            return bytes;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * post获取服务器数据
     * @param url
     * @param paramJson
     * @return
     * @throws IOException
     */
    public static String httpPostRequest(String url, String paramJson) throws IOException{
        RequestBody formBody = RequestBody.create(JSON_TYPE, paramJson);
        // Create Request (same)
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Response response = mOkHttpClient.newCall(request).execute();
        if(response.isSuccessful()) {
            String result = response.body().string();
            return result;
        }
        else{
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 1: post json获取服务器数据（支持一般json请求）
     * @param url
     * @param param
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static<T> T httpPostJsonData( String url,Object param,Class<T> clazz) throws IOException {
        RequestBody jsonBody = RequestBody.create(JSON_TYPE, JSON.toJSONString(param));
        // Create Request (same)
        Request request = new Request.Builder()
                .url(url)
                .post(jsonBody)
                .build();
        Response response = mOkHttpClient.newCall(request).execute();
        try {
            response.header("Access-Control-Allow-Origin", "*");
            String result = response.body().string();
            if(response.isSuccessful()){
                JSONObject json = JSON.parseObject(result);
                return json.toJavaObject(clazz);
            }
            else{
                throw new IOException("Unexpected code " + response);
            }

        }finally {
            if(response!=null){
                response.close();
            }
        }
    }


    /**
     * 2: post formData获取服务器数据（支持formData请求）
     * @param url
     * @param heardersMap
     * @param paramsMap
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static<T> T httpPostFormData( String url,Map<String, String> heardersMap,Map<String, String> paramsMap,Class<T> clazz) throws IOException {
        // 设置请求头
        Request.Builder requestBuilder = new Request.Builder();
        for(Map.Entry<String, String> entry : heardersMap.entrySet()) {
            requestBuilder.addHeader(entry.getKey(), entry.getValue());
        }
        // 设置请求体
        MultipartBody.Builder multipartBody = new MultipartBody.Builder();
        for(Map.Entry<String, String> entry : paramsMap.entrySet()) {
            multipartBody.addFormDataPart(entry.getKey(), entry.getValue());
        }
        // 设置为formData类型
        multipartBody.setType(MultipartBody.FORM);
        RequestBody fromBody =multipartBody.build();

        // Create Request (same)
        Request request = new Request.Builder()
                .url(url)
                .post(fromBody)
                .build();
        Response response = mOkHttpClient.newCall(request).execute();
        try {
            response.header("Access-Control-Allow-Origin", "*");
            String result = response.body().string();
            if(response.isSuccessful()){
                JSONObject json = JSON.parseObject(result);
                return json.toJavaObject(clazz);
            }
            else{
                throw new IOException("Unexpected code " + response);
            }

        }finally {
            if(response!=null){
                response.close();
            }
        }
    }


    /**
     * 3: post file获取服务器数据(支持file等一般文件上传）
     * @param url
     * @param paramsMap
     * @param file
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static<T> T httpPostFileData( String url,Map<String, String> paramsMap,File file,Class<T> clazz) throws IOException {
        // 设置请求体
        MultipartBody.Builder multipartBody = new MultipartBody.Builder();
        for(Map.Entry<String, String> entry : paramsMap.entrySet()) {
            multipartBody.addFormDataPart(entry.getKey(), entry.getValue());
        }
        // 设置为formData类型
        multipartBody.setType(MultipartBody.FORM);
        RequestBody fromBody =multipartBody.build();

        // 文件请求体
        RequestBody fileBody=RequestBody.create(OkHttpUtils.MEDIA_TYPE_MARKDOWN, file);
        if(file!=null) {
            multipartBody.addFormDataPart("file", file.getName(),fileBody);

        }
        // Create Request (same)
        Request request = new Request.Builder()
                .url(url)
                .post(fromBody)
                .build();
        Response response = mOkHttpClient.newCall(request).execute();
        try {
            response.header("Access-Control-Allow-Origin", "*");
            String result = response.body().string();
            if(response.isSuccessful()){
                JSONObject json = JSON.parseObject(result);
                return json.toJavaObject(clazz);
            }
            else{
                throw new IOException("Unexpected code " + response);
            }

        }finally {
            if(response!=null){
                response.close();
            }
        }
    }



    /**
     * 通用方式：发送heardersMap与formdata等业务参数（支持formdata，json，file等请求方式）
     * @param entity
     * @return
     * @throws IOException
     */
    public static String httpPostData(OkHttpEntity entity){
        // 设置请求头
        Request.Builder requestBuilder = new Request.Builder();
        for(Map.Entry<String, String> entry : entity.getHeardersMap().entrySet()) {
            requestBuilder.addHeader(entry.getKey(), entry.getValue());
        }
        // 设置请求体
        MultipartBody.Builder multipartBody = new MultipartBody.Builder();
        for(Map.Entry<String, String> entry : entity.getParamsMap().entrySet()) {
            multipartBody.addFormDataPart(entry.getKey(), entry.getValue());
        }
        // 文件请求体
        RequestBody fileBody=RequestBody.create(OkHttpUtils.MEDIA_TYPE_MARKDOWN, entity.getFile());
        if(entity.getFile()!=null) {
            multipartBody.addFormDataPart("file", entity.getFile().getName(),fileBody);

        }
        // 设置请求类型，默认formData,传输为自定义类型（JSON类型传输json即可）
        multipartBody.setType(MultipartBody.FORM);
        RequestBody body =multipartBody.build();
        if(entity.getRequestType()!=null) {
            body = RequestBody.create(MediaType.parse(entity.getRequestType()), entity.getParamsJson());
            if(entity.getRequestType().equals("json")){
                body = RequestBody.create(entity.getParamsJson(),JSON_TYPE);
            }
        }
        // 设置请求URL
        logger.info("调用第三方服务地址:{},参数:{},", entity.getUrl(), JSONObject.toJSONString(entity));
        Request request = requestBuilder.addHeader("Access-Control-Allow-Origin", "*")
                .url(entity.getUrl())
                .post(body)
                .build();

        // 执行响应结果
        String result=null;
        Response response=null;
        try {
            response= OkHttpUtils.mOkHttpClient.newCall(request).execute();
            response.header("Access-Control-Allow-Origin", "*");
            result= response.body().string();
        } catch (Exception e) {
            logger.error("调用第三方服务地址异常:{},",e.getMessage());
        } finally {
            if(response!=null){
                response.close();
            }
        }
        return result;
    }

    //请求实体
    public class OkHttpEntity {
        // 请求头
        Map<String, String> heardersMap;
        // FormData内容请求体
        Map<String, String> paramsMap;
        // JSON内容请求体
        String paramsJson;
        // 文件请求体
        private File file;
        // 请求URL
        String url;
        // 请求类型，默认formData，可以设置json等其他类型
        String requestType;

        public Map<String, String> getHeardersMap() {
            return heardersMap;
        }

        public void setHeardersMap(Map<String, String> heardersMap) {
            this.heardersMap = heardersMap;
        }

        public Map<String, String> getParamsMap() {
            return paramsMap;
        }

        public void setParamsMap(Map<String, String> paramsMap) {
            this.paramsMap = paramsMap;
        }

        public String getParamsJson() {
            return paramsJson;
        }

        public void setParamsJson(String paramsJson) {
            this.paramsJson = paramsJson;
        }

        public File getFile() {
            return file;
        }

        public void setFile(File file) {
            this.file = file;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getRequestType() {
            return requestType;
        }

        public void setRequestType(String requestType) {
            this.requestType = requestType;
        }
    }
}
