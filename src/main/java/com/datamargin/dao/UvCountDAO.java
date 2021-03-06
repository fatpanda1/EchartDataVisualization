package com.datamargin.dao;

import com.datamargin.domain.UvCount;
import com.datamargin.utils.LocalDataUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Component
public class UvCountDAO {

    public List<UvCount> query(){
        List<UvCount> list = new ArrayList<>();
        //初始化Redis操作对象
        LocalDataUtils dataUtils = new LocalDataUtils();
        //获取Redis查询结果
        Map<String, String> map = dataUtils.query("UvCount");
        for (Entry<String,String> entry: map.entrySet()){
            UvCount uvCount = new UvCount();

            //获取map中的name和value
            long time = Long.parseLong(entry.getKey());
            long count = Long.parseLong(entry.getValue());

            //将name和value传到domain中
            uvCount.setTime(time);
            uvCount.setCount(count);
            //写入list
            list.add(uvCount);
        }
        Collections.sort(list);
        return list;
    }
}
