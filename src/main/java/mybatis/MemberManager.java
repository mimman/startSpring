package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mimman.member.repository.RegisterRequest;

public class MemberManager {
	private static SqlSessionFactory sqlFactory;
	static{
		try{
			Reader reader = 
				Resources.getResourceAsReader("mybatis/sqlmapConfig.xml");
			
			sqlFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		catch(IOException err){
			throw new RuntimeException("SqlSessionFactory 인스턴스 생성 실패 : " + err);
		}
	}
	
	public static void MemberWrite(RegisterRequest req){
		System.out.println("memberwrite 통과" + req.getEmail());
		SqlSession session = sqlFactory.openSession();
		session.insert("MemberWrite",req); //write 라는 아이디를 매핑한다.  
		System.out.println("mapping 통과");
		session.commit(); //update, insert는 commit을 해줘야 한다
	}
}
