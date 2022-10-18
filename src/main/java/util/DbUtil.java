package util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis ORM 설정 세팅
 * */
public class DbUtil {
	// 최초에 단 한 번 생성하고 싱글톤으로 사용하기 위해 static으로 static 필드로 생성
	private static SqlSessionFactory factory;
	
	/**
	 * SqlSessionFactoryBuilder를 이용해 SqlSessionFactory 생성
	 * */
	static {
		try {
			/**
			 * 환경 설정 문서 위치 저장
			 * 환경 설정한 xml 파일과 이름이 같으면 네이밍은 마음대로 해도 무관
			 * */
			String resource = "config/myBatisConfig.xml";
			
			/**
			 * 환경 설정 문서를 Reader로 읽어옴
			 * */
			Reader reader = Resources.getResourceAsReader(resource);
			
			/**
			 * Reader로 읽은 환경 설정 문서로 SqlSessionFactory 생성
			 * */
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // static 종료
	
	/**
	 * SqlSession 객체를 리턴해주는 메소드 작성 - JDBC의 Connection과 동일한 역할
	 * : SqlSession은 CRUD 작업을 할 때마다 새롭게 생성하고 닫음
	 *   commit 또는 rollback을 이용해 transaction 처리를 함
	 *   자동 커밋X - DML(insert, update, delete) 작업 시 반드시 commit 또는 rollback 필수
	 * */
	public static SqlSession getSession() {
		// SqlSessionFactory에서 SqlSession을 열어 리턴해줌
		return factory.openSession();
	}
	
	/**
	 * 닫기 기능(DQL: select 전용)
	 * */
	public static void sessionClose(SqlSession session) {
		if(session != null) {
			session.close();
		}
	}
	
	/**
	 * 닫기 기능(DML:insert, update, delete 전용)
	 * @param: boolean state가 true인 경우 commit(), false인 경우 rollback()
	 * */
	public static void sessionClose(SqlSession session, boolean state) {
		if(session != null) {
			if(state) session.commit();
			else session.rollback();
			
			session.close();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(" ***** 시작 ***** ");
		SqlSession session = DbUtil.getSession();
		System.out.println("session = " + session);
	}
	
}
