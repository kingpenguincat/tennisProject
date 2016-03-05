package service;

import bean.Advertisement;
import bean.User;
import dao.GeneralDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liupeng on 16/3/5.
 */
@Service
public class AdvertisementService {
    @Autowired
    private GeneralDaoImpl generalDaoImpl;

    //获取首页广告
    public List<Advertisement> getIndexAd(Advertisement ad) throws Exception {
        return (List<Advertisement>) generalDaoImpl.findForList("advertisement.getIndexAd",ad);
    }

    //获取首页广告
    public List<Advertisement> getUserInfoAd(Advertisement ad) throws Exception {
        return (List<Advertisement>) generalDaoImpl.findForList("advertisement.getUserInfoAd",ad);
    }


}
