package dao;

import user.MyUser;

import java.util.List;

public interface TestDao {
    public int updata(String sql,Object[] param);
    public List<MyUser> query(String sql,Object[] param);
}
