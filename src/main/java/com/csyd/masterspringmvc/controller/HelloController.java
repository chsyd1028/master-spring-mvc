package com.csyd.masterspringmvc.controller;

import com.alibaba.fastjson.JSONObject;
import com.csyd.masterspringmvc.po.ActS;
import com.csyd.masterspringmvc.po.Movie;
import com.csyd.masterspringmvc.po.Playlinks;
import com.csyd.masterspringmvc.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ChengShanyunduo
 * 2018/1/17
 */
@Controller
public class HelloController {

    private String movieUrl =  "http://op.juhe.cn/onebox/movie/video?key=APPKEY&q=QUERY";

    @RequestMapping("/")
    public String home(){
        return "searchPage";
    }

    @RequestMapping("/result")
    public String hello(@RequestParam String search, Model model, RedirectAttributes redirectAttributes){

        String url = movieUrl.replace("APPKEY", HttpClientUtil.APP_KEY).replace("QUERY", search);

        //JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject jsonObject = HttpClientUtil.doGetStr(url);

        if (Objects.isNull(jsonObject.getString("result"))){
            redirectAttributes.addFlashAttribute("error", jsonObject.getString("reason"));
            return "redirect:/";
        }

        Movie movie = jsonObject.toJavaObject(Movie.class);

        List<ActS> acts = Arrays.asList(movie.getResult().getAct_s());
        Map<String, Object> result = new HashMap<>();
        result.put("title", movie.getResult().getTitle());
        result.put("desc", movie.getResult().getDesc());
        result.put("cover", movie.getResult().getCover());
        result.put("tag", movie.getResult().getTag());
        Playlinks playlinks = movie.getResult().getPlaylinks();

        model.addAttribute("acts", acts);
        model.addAttribute("search", search);
        model.addAttribute("result", result);
        model.addAttribute("playlinks", playlinks);


        return "resultPage";
    }

    @RequestMapping(value = "/postSearch", method = RequestMethod.POST)
    public String postSearch(HttpServletRequest request, RedirectAttributes redirectAttributes){
        String search = request.getParameter("search");
        if (search.toLowerCase().contains("struts")){
            redirectAttributes.addFlashAttribute("error", "请重新输入");
            return "redirect:/";
        }
        redirectAttributes.addAttribute("search", search);
        return "redirect:result";
    }
}
