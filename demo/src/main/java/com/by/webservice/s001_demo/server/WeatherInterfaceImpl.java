package com.by.webservice.s001_demo.server;

import javax.jws.WebService;

@WebService     //@WebService表示该类是一个服务类，需要发布其中的public的方法
public class WeatherInterfaceImpl implements WeatherInterface {

    @Override
    public String queryWeather(String cityName) {
        System.out.println("获取城市名"+cityName);
        String weather="暴雨";
        return weather;
    }

}