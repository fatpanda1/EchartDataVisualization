package com.datamargin.dao;

import com.datamargin.domain.FunnelPlot;
import com.datamargin.utils.LocalDataUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class FunnelPlotDAO {
    public List<FunnelPlot> query(){
        List<FunnelPlot> list = new ArrayList<>();
        //初始化Redis操作对象
        LocalDataUtils dataUtils = new LocalDataUtils();
        //获取Redis查询结果
        Map<String, String> map = dataUtils.query("FunnelPlotCount");
        for (Map.Entry<String,String> entry: map.entrySet()){
            FunnelPlot funnelPlot = new FunnelPlot();

            //获取map中的name和value
            String behavior = entry.getKey();
            long count = Long.parseLong(entry.getValue());

            //将name和value传到domain中
            funnelPlot.setBehavior(behavior);
            funnelPlot.setCount(count);
            //写入list
            list.add(funnelPlot);
        }
        Collections.sort(list);
        return list;
    }
}
