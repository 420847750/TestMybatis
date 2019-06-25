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
			  //����sqlSession�Ĺ���
	        //������ִ��ӳ���ļ���sql��sqlSession
	        SqlSession session = sqlSessionFactory.openSession();
	        /**
	         * ӳ��sql�ı�ʶ�ַ�����
	         * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
	         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
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
