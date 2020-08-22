package com.dian.cloud_demo.eureka_client4.service.impl;

import com.dian.cloud_demo.eureka_client4.service.CityDataService;
import com.dian.cloud_demo.eureka_client4.utils.XmlBuilder;
import com.dian.cloud_demo.eureka_client4.vo.City;
import com.dian.cloud_demo.eureka_client4.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Description: 城市服务 实现
 * @Author: Liu Guo Dian
 * @Date: 2020/8/4 17:35
 * @Version: 1.0
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        //读取xml
        Resource resource= new ClassPathResource("citylist.xml");
        BufferedReader br =new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer buffer =new StringBuffer();
        String line = "";
        while ( (line =br.readLine()) != null){
            buffer.append(line);
        }
        br. close() ;
        //xml转对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToOject(CityList.
                class, buffer.toString());
        return cityList.getCityList();
    }

    public static void main(String[] args) {
        try {
            Resource resource= new ClassPathResource("citylist.xml");
            BufferedReader br =new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
            StringBuffer buffer =new StringBuffer();
            String line = "";

            while ( (line =br.readLine()) != null){
                buffer.append(line);
            }
            br. close() ;
            //xml转对象
            CityList cityList = (CityList) XmlBuilder.xmlStrToOject(CityList.
                    class, buffer.toString());
            System.out.println("===============");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
