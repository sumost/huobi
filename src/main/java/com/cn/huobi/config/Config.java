package com.cn.huobi.config;

import com.cn.huobi.config.model.Person;
import com.cn.huobi.redis.service.RedisHashService;
import com.cn.huobi.redis.service.RedisListService;
import com.cn.huobi.redis.service.RedisStrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 开发者 liaoliping
 * date：2017/12/29
 * time：22:47
 */
@Controller
public class Config {

    @Autowired
    private RedisStrService redisStrService;
    @Autowired
    private RedisHashService redisHashService;
    @Autowired
    private RedisListService redisListService;

    @RequestMapping("/config")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("name", "123123");
        map.addAttribute("bookTitle", "aasdasd");
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        return "welcome";
    }

    /**
     * @return 当前系统关注的货币
     */
    @ResponseBody
    @RequestMapping("/currency")
    public List<String> getCurrencyList(){
        List<String> currencyList = redisListService.range("currencyList");
        return currencyList;
    }

    /**
     * @return 当前系统关注的货币
     */
    @ResponseBody
    @RequestMapping("/user")
    public List<String> getUser(){
        List<String> user = redisListService.range("userEmail");
        return user;
    }




}
