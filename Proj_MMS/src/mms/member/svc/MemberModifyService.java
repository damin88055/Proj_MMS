package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberModifyService {

	Connection con = null;
	
	//수정할 이름을 불러올 때 Member 정보 가져오기
	public Member getOldMember(String name) {
		
		Member oldMember = null;

		con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		oldMember = memberDAO.selectOldMember(name);
		
		JdbcUtil.close(con);
		return oldMember;
	}

	public boolean modifyMember(Member updateMember) {
		boolean isModifySuccess = false;
		con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		
		int updateCount = memberDAO.updateMember(updateMember);

		if (updateCount > 0) {
			isModifySuccess = true;
			JdbcUtil.commit(con);
		}else{
			JdbcUtil.rollback(con);
			return isModifySuccess;
		}
		return isModifySuccess;
	}

}
