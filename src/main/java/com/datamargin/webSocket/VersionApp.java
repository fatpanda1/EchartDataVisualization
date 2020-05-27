package com.datamargin.webSocket;

import com.datamargin.dao.CategoryClickCountDAO;
import com.datamargin.domain.CategoryClickCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@CrossOrigin
public class VersionApp {

    @Autowired
    CategoryClickCountDAO categoryClickCountDAO;

    /**
     * 水果统计
     * @return
     */
    @RequestMapping(value = "clickCount", method = RequestMethod.POST)
    public List<CategoryClickCount> query() {
        List<CategoryClickCount> list = categoryClickCountDAO.query();
        return list;
    }

    @RequestMapping(value = "echart", method = RequestMethod.GET)
    public ModelAndView echart() {
        return new ModelAndView("categaryechart");
    }


    @RequestMapping(value = "liuliang", method = RequestMethod.GET)
    public ModelAndView liuliang() {
        return new ModelAndView("liuliang");
    }

    @RequestMapping(value = "yingxiao", method = RequestMethod.GET)
    public ModelAndView yingxiao() {
        return new ModelAndView("yingxiao");
    }

}
