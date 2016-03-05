package controller;

import bean.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AdvertisementService;
import util.RespStatusUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liupeng on 16/3/5.
 */
@Controller
public class AdvertisementController {
    @Autowired
    AdvertisementService advertisementService;


    @RequestMapping("/appAd/getIndexAd")
    @ResponseBody
    public Map getIndexAd(){
        Map map = new HashMap();
        try{
            Advertisement ad = new Advertisement();
            List<Advertisement> ads = advertisementService.getIndexAd(ad);
            RespStatusUtil.success(map);
            map.put("data",ads);
        }catch (Exception e){
            e.printStackTrace();
            RespStatusUtil.error("信息获取失败",map);

        }
        return map;
    }

    @RequestMapping("/appAd/getUserInfoAd")
    @ResponseBody
    public Map getUserInfoAd(){
        Map map = new HashMap();
        try{
            Advertisement ad = new Advertisement();
            List<Advertisement> ads = advertisementService.getUserInfoAd(ad);
            RespStatusUtil.success(map);
            map.put("data",ads);
        }catch (Exception e){
            e.printStackTrace();
            RespStatusUtil.error("信息获取失败",map);

        }
        return map;
    }

}
