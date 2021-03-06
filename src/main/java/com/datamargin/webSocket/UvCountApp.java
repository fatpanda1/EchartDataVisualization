package com.datamargin.webSocket;

import com.datamargin.dao.UvCountDAO;
import com.datamargin.domain.UvCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UvCountApp {
    @Autowired
    UvCountDAO uvCountDAO;

    /**
     * Uv统计
     * @return
     */
    @RequestMapping(value = "uvCount", method = RequestMethod.POST)
    public List<UvCount> query() {
        List<UvCount> list = uvCountDAO.query();
        return list;
    }
}
