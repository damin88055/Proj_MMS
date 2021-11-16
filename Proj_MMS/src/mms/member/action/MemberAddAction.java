package mms.member.action;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;

import mms.member.svc.MemberAddService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil cu = new ConsoleUtil();
		Member newMember = cu.getNewMember(sc);
		
		MemberAddService memberAddActionService = new MemberAddService();
		
		boolean isAddSuccess = memberAddActionService.addMember(newMember);
		
		if(isAddSuccess) {
			cu.printAddSuccessMessage(newMember);
		}else {
			cu.printAddFailMessage(newMember);
		}
		
		
	}
}
