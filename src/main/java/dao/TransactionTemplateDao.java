package dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import user.MyUser;

import java.util.List;

@Repository("transactionTemplateDao")
public class TransactionTemplateDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TransactionTemplate transactionTemplate;
    String massage=" ";
    public String test(){
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public String doInTransaction(TransactionStatus status) {
                ApplicationContext appCon=new ClassPathXmlApplicationContext("applicationContext.xml");
                TestDao td=(TestDao) appCon.getBean("testDao");
                String message="执行成功，没有回滚";
                try {
                    String selectSql = "select *from user";
                    List<MyUser> list = td.query(selectSql, null);
                    for (MyUser mu : list)
                        System.out.println(mu);
                    String insertSql = "insert into user values(?,?)";
                    Object param1[] = {"张三", "123"};
                    td.updata(insertSql, param1);
                    massage="事物执行";
                }
                catch(Exception e){
                    massage="事物回滚";
                    e.printStackTrace();
                }
                return massage;
            }
        });
        return massage;
    }
}
