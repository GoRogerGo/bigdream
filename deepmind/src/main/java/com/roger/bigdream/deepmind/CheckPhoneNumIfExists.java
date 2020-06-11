package com.roger.bigdream.deepmind;

import com.google.common.collect.Lists;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckPhoneNumIfExists {

    private final static String uri = "https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?cb=jQuery110204369165651745437_1525885207186&resource_name=guishudi&_=1525885207349&query=";

    private final static List<String> cityList = Lists.<String>newArrayList("1557914", "1557915", "1557912", "1550791", "1557913", "1557910", "1557911", "1557918", "1557916", "1557917");

    public static void main(String[] args) {
        for (String cityNumCode : cityList) {
            for (Integer i = 0; i < 10; i++) {
                String phoneNum = cityNumCode.concat("0").concat(i.toString()).concat("67");
                try {
                    doGet(uri, phoneNum);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for (Integer i = 10; i < 100; i++) {
                String phoneNum = cityNumCode.concat(i.toString()).concat("67");
                try {
                    doGet(uri, phoneNum);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void doGet(String uri, String phoneNum) throws ClientProtocolException, IOException {
        //创建CloseableHttpClient
        HttpClientBuilder builder = HttpClientBuilder.create();
        CloseableHttpClient client = builder.build();
        //执行
        HttpUriRequest httpGet = new HttpGet(uri.concat(phoneNum));
        CloseableHttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String entityStr = EntityUtils.toString(entity, "gb2312");
            analyseResult(entityStr, phoneNum);
        }
    }

    private static void analyseResult(String entityStr, String phoneNum) {
        if (entityStr.indexOf("存在") > 0) {
            System.out.println(phoneNum);
        }
    }
}
