package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberAddService {
	
	public boolean addMember(Member newMember) throws Exception {
		boolean isInsertSuccess = false;
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDao = new MemberDAO(con);
		int insertCount = memberDao.insertNewMember(newMember);
		if(insertCount > 0) {
			JdbcUtil.commit(con);
			isInsertSuccess = true;
		}else {
			JdbcUtil.rollback(con);
		}
		return isInsertSuccess;
	}

}
