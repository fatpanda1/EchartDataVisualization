package com.datamargin.webSocket;

import com.datamargin.dao.FunnelPlotDAO;
import com.datamargin.domain.FunnelPlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FunnelPlotApp {
    @Autowired
    FunnelPlotDAO funnelPlotDAO;

    /**
     * Uv统计
     * @return
     */
    @RequestMapping(value = "funnelPlot", method = RequestMethod.POST)
    public List<FunnelPlot> query() {
        List<FunnelPlot> list = funnelPlotDAO.query();
        return list;
    }
}
