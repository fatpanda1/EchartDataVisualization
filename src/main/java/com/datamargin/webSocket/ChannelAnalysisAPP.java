package com.datamargin.webSocket;

import com.datamargin.dao.ChannelAnalysisDAO;
import com.datamargin.domain.CategoryClickCount;
import com.datamargin.domain.FunnelPlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChannelAnalysisAPP {
    @Autowired
    ChannelAnalysisDAO channelAnalysisDAO;

    /**
     * 渠道统计
     * @return
     */
    @RequestMapping(value = "channelAnalysis", method = RequestMethod.POST)
    public List<CategoryClickCount> query() {
        List<CategoryClickCount> list = channelAnalysisDAO.query();
        return list;
    }
}
