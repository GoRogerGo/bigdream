package com.roger.bigdream.deepmind;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.*;

public class FindPhoneNumRegistrationLocation {

    private final static Set<String> citySet = new HashSet<String>(Lists.<String>newArrayList("广州", "武汉", "深圳", "成都", "佛山", "西安", "苏州", "昆明", "杭州", "长沙", "宁波", "无锡", "南昌", "福州", "东莞", "南宁", "合肥", "厦门"));

    private final static String uri = "http://www.ip138.com:8080/search.asp?action=mobile&mobile=";

    private static Map<String, Set<String>> result = new HashMap<String, Set<String>>();


    public static void main(String[] args) {
        String fileName = "/Users/roger/Documents/cityNumRegion.txt";
        List<String> numList = getNumListFromFile(fileName);
        if (CollectionUtils.isNotEmpty(numList)) {
            for (String num : numList) {
                try {
                    doGet(uri, num);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(JSON.toJSONString(result));
            //{"南昌":["1557914","1557915","1557912","1550791","1557913","1557910","1557911","1557918","1557916","1557917"]}
        }
    }

    private static List<String> getNumListFromFile(String fileName) {
        List<String> numList = Lists.newArrayList();
        File file = new File(fileName);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String num = "";
                while (StringUtils.isNotEmpty(num = bufferedReader.readLine())) {
                    numList.add(num);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return numList;
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

    private static void analyseResult(String entityStr, String num) {
        int index = entityStr.indexOf("市");
        if (index > 0) {
            String cityName = entityStr.substring(index - 2, index);
            if (citySet.contains(cityName)) {
                if (null == result.get(cityName)) {
                    result.put(cityName, new HashSet<String>());
                }
                Set<String> cityNum = result.get(cityName);
                cityNum.add(num);
            }
        } else {
            System.err.println(num);
        }

    }
}
