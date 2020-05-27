package com.datamargin.dao;

import com.datamargin.domain.CategoryClickCount;
import com.datamargin.utils.DataUtils;
import com.datamargin.utils.LocalDataUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Component
public class ChannelAnalysisDAO {

    public List<CategoryClickCount> query(){
        List<CategoryClickCount> list = new ArrayList<>();
        //初始化Redis操作对象
        LocalDataUtils dataUtils = new LocalDataUtils();
        //获取Redis查询结果
        Map<String, String> map = dataUtils.query("channelAnalysis_Sum");
        for (Entry<String,String> entry: map.entrySet()){
            CategoryClickCount clickCount = new CategoryClickCount();
            //获取map中的name和value
            String name = entry.getKey();
            long value = Long.parseLong(entry.getValue());
            //将name和value传到domain中
            clickCount.setName(name);
            clickCount.setValue(value);
            //写入list
            list.add(clickCount);
        }
        return list;
    }

//    public static void main(String[] args) {
//        CategoryClickCountDAO dao = new CategoryClickCountDAO();
//        for (CategoryClickCount c : dao.query()){
//            System.out.println(c.getName() + c.getValue());
//        }
//    }
}
