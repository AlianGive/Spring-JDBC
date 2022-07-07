package test;


import dao.CodeTransaction;
import dao.TransactionTemplateDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;
import service.TestService;
import service.TestServiceImpl;

public class Test {

    public static void main(String args[]){
        ApplicationContext appCon=new ClassPathXmlApplicationContext("applicationContext.xml");
        /*CodeTransaction ct= (CodeTransaction) appCon.getBean( "codeTransaction");
        System.out.println(ct.test());
        TransactionTemplateDao Tt= (TransactionTemplateDao) appCon.getBean("transactionTemplateDao");
        System.out.println(Tt.test());*/
        TestService ts=(TestService) appCon.getBean("testService");
        ts.test();
    }
}
