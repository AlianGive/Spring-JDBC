package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import user.MyUser;

import java.util.List;
@Component
public class CodeTransaction {
    @Autowired
    public DataSourceTransactionManager txManager;
    public String test(){
        TransactionDefinition tf=new DefaultTransactionDefinition();
        TransactionStatus ts=txManager.getTransaction(tf);
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
            txManager.commit(ts);
        }
        catch(Exception e){
            txManager.rollback(ts);
            message="事物回滚";
            e.printStackTrace();
        }

        return message;

    }
}
