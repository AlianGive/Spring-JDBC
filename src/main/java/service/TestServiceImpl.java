package service;

import dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("testService")
@Transactional(rollbackFor = {Exception.class})
public class TestServiceImpl implements TestService{
    @Autowired
    private TestDao testDao;
    public void test(){
        String deleteSql="delete from user";
        String saveSql="insert into user values(?,?)";
        Object param[]={"小红","123"};
        testDao.updata(deleteSql,null);
        testDao.updata(saveSql,param);
        testDao.updata(saveSql,param);//重复事物回滚
    }
}
