package controller;

import bean.Game;
import form.GameForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.GameService;
import util.DistanceCompare;
import util.Maps;
import util.RespStatusUtil;

import java.util.*;

/**
 * Created by liupeng on 16/3/9.
 */
@Controller
public class GameController {
    @Autowired
    private GameService gameService;
    @RequestMapping("/gameController/insertGame")
    @ResponseBody
    public Map InsertGame(GameForm gameForm){
        Map map = new HashMap();
        System.out.print("新建比赛");
        try{
            String result = gameService.insertGame(gameForm);
            if(result!="0"){
                RespStatusUtil.success(map);
            }else{
                RespStatusUtil.error("新建比赛失败",map);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return map;
    }
    @RequestMapping("/gameController/updateGame")
    @ResponseBody
    public Map UpdateGame(GameForm gameForm){
        Map map = new HashMap();
        System.out.print("更新比赛");
        try{
            String result = gameService.updateGame(gameForm);
            if(result!="0"){
                RespStatusUtil.success(map);
            }else{
                RespStatusUtil.error("更新比赛失败",map);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return map;
    }

    @RequestMapping("/gameController/getGameInfoOrderByDistance")
    @ResponseBody
    public Map getNearbyHotelList(GameForm gameForm){
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(gameForm.getOrderBy());
        String page = String.valueOf(gameForm.getPage());
        if(gameForm.getOrderBy().equals("distance")){
            System.out.println("获取用户附近的酒店~~~");

            try{
                List<Game> games = gameService.getNearByGameInfo(gameForm);

                if(null != games && games.size() > 0){


                    Integer pageNum = 1;
                    boolean flag = true;
                    if(page != null && !"-1".equals(page)){
                        Integer intPage = Integer.parseInt(page);
                        pageNum = intPage;
                    }
                    if(page != null && "-1".equals(page)){
                        flag = false;
                    }
                    /**
                     *  分页
                     * */
                    // fan hui shu zhi
                    Double u1 = Double.parseDouble(gameForm.getLng());//用户经度
                    Double u2 = Double.parseDouble(gameForm.getLat());//用户纬度

                    //获取各个比赛与用户当前位置的距离    distance
                    for(Game g:games){

                        Double lon1 = (Double) g.getLng();//酒店经度
                        Double lat1 = (Double) g.getLat();//酒店纬度

                        Double dou = Maps.getDistatce(u1, u2, lon1, lat1);

                        g.setDistance(dou);
                    }
                    DistanceCompare distanceCompare = new DistanceCompare();
                    Collections.sort(games, distanceCompare);

                    List<Game> dataList = new ArrayList<Game>();
                    if(flag){
                        if((pageNum-1) * 6 < games.size()){
                            int sum = pageNum*6 > games.size() ? games.size() :pageNum*6;
                            for(int num = (pageNum-1) * 6; num < sum ; num++){
                                dataList.add(games.get(num));
                            }
                        }

                    }else{
                        dataList = games;
                    }

                    map.clear();
                    RespStatusUtil.success(map);
                    map.put("data", dataList);
                    map.put("count", games.size());
                }else{
                    map.clear();
                    RespStatusUtil.success(map);
                    map.put("data", games);
                    map.put("count", games.size());
                }


            }catch(Exception e){
                map.clear();
                RespStatusUtil.error("获取附近比赛失败", map);
                System.out.println("获取附近比赛失败~~~");
                e.printStackTrace();
            }

            System.out.println("获取附近比赛结束~~~");
            return map;
        }else if(gameForm.getOrderBy().equals("champion")){
            try{
                List<Game> games = gameService.getNearByGameInfo(gameForm);
                if(null != games && games.size() > 0){


                    Integer pageNum = 1;
                    boolean flag = true;
                    if(page != null && !"-1".equals(page)){
                        Integer intPage = Integer.parseInt(page);
                        pageNum = intPage;
                    }
                    if(page != null && "-1".equals(page)){
                        flag = false;
                    }
                    List<Game> dataList = new ArrayList<Game>();
                    if(flag){
                        if((pageNum-1) * 6 < games.size()){
                            int sum = pageNum*6 > games.size() ? games.size() :pageNum*6;
                            for(int num = (pageNum-1) * 6; num < sum ; num++){
                                dataList.add(games.get(num));
                            }
                        }

                    }else{
                        dataList = games;
                    }

                    map.clear();
                    RespStatusUtil.success(map);
                    map.put("data", dataList);
                    map.put("count", games.size());
                }else{
                    map.clear();
                    RespStatusUtil.success(map);
                    map.put("data", games);
                    map.put("count", games.size());
                }


            }catch(Exception e){
                map.clear();
                RespStatusUtil.error("获取比赛失败", map);
                System.out.println("获取比赛失败~~~");
                e.printStackTrace();
            }
            return map;
        }else if(gameForm.getOrderBy().equals("time")){
            return map;
        }else{
            System.out.println("啥都没做");
            return map;
        }

    }






}
