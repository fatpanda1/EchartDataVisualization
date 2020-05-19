package com.datamargin.dao;

import com.datamargin.domain.CategoryClickCount;
import com.datamargin.domain.PvCount;
import com.datamargin.utils.DataUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.Map.Entry;

@Component
public class PvCountDAO {

    public List<PvCount> query(){
        List<PvCount> list = new ArrayList<>();
        //初始化Redis操作对象
        DataUtils dataUtils = new DataUtils();
        //获取Redis查询结果
        Map<String, String> map = dataUtils.query("pvCount1");
        for (Entry<String,String> entry: map.entrySet()){
            PvCount pvCount = new PvCount();

            //获取map中的name和value
            String time = entry.getKey();
            long count = Long.parseLong(entry.getValue());

            //将name和value传到domain中
            pvCount.setTime(time);
            pvCount.setCount(count);
            //写入list
            list.add(pvCount);
            System.out.println(pvCount.getTime());
        }
        Collections.sort(list);
        return list;
    }

//    public static void main(String[] args) {
//        CategoryClickCountDAO dao = new CategoryClickCountDAO();
//        for (CategoryClickCount c : dao.query()){
//            System.out.println(c.getName() + c.getValue());
//        }
//    }
}
