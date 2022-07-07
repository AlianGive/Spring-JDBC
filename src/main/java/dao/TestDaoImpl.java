package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import user.MyUser;

import java.util.List;
@Repository("testDao")
public class TestDaoImpl implements TestDao{
    //使用jdbc模板
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int updata(String sql, Object[] param) {

        return jdbcTemplate.update(sql,param);
    }

    @Override
    public List<MyUser> query(String sql, Object[] param) {
        RowMapper<MyUser> rowMapper=new BeanPropertyRowMapper<MyUser>(MyUser.class);
        return jdbcTemplate.query(sql,rowMapper,param);

    }
}
