package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberModifyService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberModifyAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {

		ConsoleUtil cu = new ConsoleUtil();
		String str = "수정할 회원 정보를 입력하세요";
		String name = cu.getName(str, sc);
		
		
		MemberModifyService mms = new MemberModifyService();
		Member oldMember = mms.getOldMember(name);

		if (oldMember != null) {
			Member updateMember = cu.getUpdateMember(sc, oldMember);
			boolean isSuccess = mms.modifyMember(updateMember);
			
			if(isSuccess) {
				cu.printModifySuccessMessage(updateMember);
			}
			else {
				cu.printModifyFailMessage(updateMember);
			}
		}
		else {
			System.out.println("수정할 회원이 존재하지 않음.\n");
		}

	}
}
