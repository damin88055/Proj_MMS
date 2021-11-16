package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberRemoveService;
import mms.member.util.ConsoleUtil;

public class MemberRemoveAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil cu = new ConsoleUtil();
		String str = "삭제할 회원 정보를 입력하세요";
		String name = cu.getName(str, sc);
		
		MemberRemoveService mrs = new MemberRemoveService();
		boolean isSuccess = mrs.removeMember(name);
		
		if(isSuccess) {
			cu.printRemoveSuccessMessage(name);
		}
		else {
			cu.printRemoveFailMessage(name);
		}
		
		
	}
}
