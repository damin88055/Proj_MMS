package mms.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

//Oracle DB로 필요한 SQL구문을 전송하는 클래스 구현
public class MemberDAO {

	Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MemberDAO(Connection con) {
		this.con = con;
	}

	public int insertNewMember(Member newMember) {

		String sql = "insert into mms_member(id,name,addr,nation,email,age) values(member_id_seq.nextval,?,?,?,?,?)";
		int insertCount = 0;
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, newMember.getName());
			pstmt.setString(2, newMember.getAddr());
			pstmt.setString(3, newMember.getNation());
			pstmt.setString(4, newMember.getEmail());
			pstmt.setInt(5, newMember.getAge());

			insertCount = pstmt.executeUpdate();


		} catch (SQLException e) {
		}finally {
			JdbcUtil.close(pstmt);
		}

		return insertCount;
	}
//2.
	public ArrayList<Member> selectMemberList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> memberList = new ArrayList<Member>();
		String sql = "select * from mms_member";
		Member member = null;
		try {
			pstmt = con.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String nation = rs.getString("nation");
				String email = rs.getString("email");
				int age = rs.getInt("age");
						
				member = new Member(name, addr, nation, email, age);
				
				memberList.add(member);
			
			}

		} catch (SQLException e) {
			
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			
		}
		return memberList;
		
		

	}
	//3.update 할 때 특정 회원 정보 보기

	public Member selectOldMember(String name) {

		Member oldMember = null;

		String sql = "select * from mms_member where name=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				String name2 = rs.getString("name");
				String addr = rs.getString("addr");
				String nation = rs.getString("nation");
				String email = rs.getString("email");
				int age = rs.getInt("age");
						
				oldMember = new Member(name2, addr, nation, email, age);
			}

			return oldMember;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return oldMember;
		}		
	}

	//4. 회원정보 수정
	public int updateMember(Member updateMember) {
		int updateCount = 0;
		
		PreparedStatement pstmt;
		
		String sql = "update mms_member set addr=?, nation=?, email=?, age=? where name = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateMember.getNation());
			pstmt.setString(2, updateMember.getAddr());
			pstmt.setString(3, updateMember.getEmail());
			pstmt.setInt(4, updateMember.getAge());
			pstmt.setString(5, updateMember.getName());
			
			updateCount = pstmt.executeUpdate();
			
			return updateCount;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return updateCount;
		}
	}

	public int deleteMember(String name) {

		String sql = "delete from mms_member where name=?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			count = pstmt.executeUpdate();
			return count;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return count;
		}
	}

}
