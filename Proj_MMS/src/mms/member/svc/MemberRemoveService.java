package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberRemoveService {

	Connection conn = null;
	
	public boolean removeMember(String name) {

		conn = JdbcUtil.getConnection();
		MemberDAO dao = new MemberDAO(conn);
		int count = dao.deleteMember(name);
		
		if(count > 0) {
			return true;
		}
		
		return false;		
	}

}
