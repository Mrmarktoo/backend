package com.example.demo;

import com.example.demo.bean.Student;
import com.example.demo.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author marktoo
 * @since 2020/1/31
 */
public class TestApp {
    public static void main(String[] args) throws IOException {
        // 读取mybatis-config.xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 初始化mybatis，创建SqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建Session实例
        SqlSession session = sqlSessionFactory.openSession();

        // 获得xml映射文件中定义的操作语句
        Student p = session.selectOne("com.example.demo.mapper.StudentMapper.findById", 1l);
        System.out.println(p);

        // 获得mapper接口的代理对象
        StudentMapper pm = session.getMapper(StudentMapper.class);
        // 直接调用接口的方法，查询id为1的Peson数据
        Student p2 = pm.findById(1l);
        // 打印Peson对象
        System.out.println(p2);
//        // 打印Person对象关联的Card对象
//        System.out.println(p2.getCard());

        // 提交事务
        session.commit();
        // 关闭Session
        session.close();
    }
}
