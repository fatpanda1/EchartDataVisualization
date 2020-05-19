package com.datamargin.webSocket;

import com.datamargin.dao.PvCountDAO;
import com.datamargin.domain.CategoryClickCount;
import com.datamargin.domain.PvCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PvCountApp {
    @Autowired
    PvCountDAO pvCountDAO;

    /**
     * Pv统计
     * @return
     */
    @RequestMapping(value = "pvCount", method = RequestMethod.POST)
    public List<PvCount> query() {
        List<PvCount> list = pvCountDAO.query();
        return list;
    }
}
