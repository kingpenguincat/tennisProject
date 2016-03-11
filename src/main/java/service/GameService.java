package service;

import bean.Game;
import bean.User;
import dao.GeneralDaoImpl;
import form.GameForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liupeng on 16/3/9.
 */
@Service
public class GameService {
    @Autowired
    private GeneralDaoImpl generalDaoImpl;


    //新建比赛
    public String insertGame(GameForm gameForm) throws Exception{
        Integer i = (Integer) generalDaoImpl.add("game.insertGame", gameForm);
        if(i == 1){
            return String.valueOf(gameForm.getId());
        }else{
            return "0";
        }

    }

    //更新比赛
    public String updateGame(GameForm gameForm) throws Exception{
        Integer i = (Integer) generalDaoImpl.add("game.updateGame", gameForm);
        if(i == 1){
            return String.valueOf(gameForm.getId());
        }else{
            return "0";
        }

    }

    //获取周边的比赛
    public List<Game> getNearByGameInfo(GameForm gameForm) throws Exception{
        return (List<Game>) generalDaoImpl.findForList("game.getNearByHotelInfo", gameForm);

    }
}
