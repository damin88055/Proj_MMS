package mms.member.ui;

import java.util.Scanner;

import mms.member.action.Action;
import mms.member.action.MemberAddAction;
import mms.member.action.MemberListAction;
import mms.member.action.MemberModifyAction;
import mms.member.action.MemberRemoveAction;
import mms.member.controller.MemberController;

//3. 사용자가 메뉴를 선택할수 있는 화면을 구성해 주는 클래스

public class MemberUI {
	public static void main(String[] args) {
		
		System.out.println("Pull 연습 ");
		System.out.println("Commit-push 연습1 ");
		System.out.println("slave branch 연습1 ");
		
		
		boolean isStop = false;
		MemberController memberController = new MemberController();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("====회원관리 프로그램====");
			System.out.println("1.회원등록");
			System.out.println("2.회원목록보기");
			System.out.println("3.회원정보수정");
			System.out.println("4.회원정보삭제");
			System.out.println("5.프로그램종료");
			System.out.print("메뉴번호 : ");
			int menu = sc.nextInt();
			Action action = null;
			switch(menu) {
			case 1:
				action = new MemberAddAction();
				break;
			case 2:
				action = new MemberListAction();
				break;
			case 3:
				action = new MemberModifyAction();
				break;
			case 4:
				action = new MemberRemoveAction();
				break;
			case 5:
				isStop = true;
				break;
				
			default:
				break;
			}
 
			if(action != null) {
				memberController.processRequest(action, sc);
				
			}
 
		} while (!isStop);
	}
}
