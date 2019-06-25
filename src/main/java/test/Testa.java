package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.zzz.entity.User;
import cn.zzz.mapper.UserMapper;

public class Testa {

	@Test
	public void test() {
		try {
			 String resource="mybatis_config.xml";
			Reader resourceAsReader =Resources.getResourceAsReader(resource);
			
			SqlSessionFactory sqlSessionFactory  =new SqlSessionFactoryBuilder().build(resourceAsReader);
			  //构建sqlSession的工厂
	        //创建能执行映射文件中sql的sqlSession
	        SqlSession session = sqlSessionFactory.openSession();
	        /**
	         * 映射sql的标识字符串，
	         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
	         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        UserMapper mapper =session.getMapper(UserMapper.class);
	        User user =mapper.getUser(1);
	        System.out.println(user.toString());
	        session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
