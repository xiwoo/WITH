package com.posco.test;

import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemService {

	Scanner scanner = new Scanner(System.in);
	Logger logger = LoggerFactory.getLogger(MemService.class);
	ArrayList<MemVO> memList = new ArrayList<MemVO>();
	MemVO mvo;
	String input;
	int index;

	public void memMain(){
		String input;
		while(true){
			input = memStart();
			String result = memRepeat(input);
			if(result != null && result.equals("exit"))break;
		}
	}

	public String memStart(){
		System.out.println("---------------멤버조회/멤버등록/멤버수정/멤버삭제/exit---------------");
		input = scanner.nextLine();
		return input;
	}

	public String memRepeat(String input){

		String result = null;

		if(input.equals("멤버조회")){
			if(!memList.isEmpty()){
				memSelect();
			}else{
				System.out.println("등록된 회원이 없습니다---------------");
			}
			//			logger.info("index = "+index+" com Login");
		}else if(input.equals("멤버등록")){
			memInsert();
		}else if(input.equals("멤버수정")){
			if(!memList.isEmpty()){
				memUpdate();
			}else{
				System.out.println("등록된 회원이 없습니다---------------");
			}
		}else if(input.equals("멤버삭제")){
			if(!memList.isEmpty()){
				memDelete();
			}else{
				System.out.println("등록된 회원이 없습니다---------------");
			}
		}else if(input.equals("exit")){
			result = "exit";
		}else{
			System.out.println("정확한 값을 입력하시오---------------");
		}
		return result;
	}

	public void memSelect(){

		System.out.println("---------------리스트/조회---------------");
		input = scanner.nextLine();
		if(input.equals("리스트")){
			for(int i=0;i<memList.size();i++){
				index = i+1;
				System.out.println("-------------------------------------");
				System.out.println("사용자 번호:"+ index);
				System.out.println("사용자 명:"+ memList.get(i).getMemName());
				System.out.println("사용자 전화번호:"+ memList.get(i).getMemPhone());
				System.out.println("사용자 직업:"+ memList.get(i).getMemJob());
				System.out.println("사용자 이메일:"+ memList.get(i).getMemEmail());
				System.out.println("-------------------------------------");
			}
		}else if(input.equals("조회")){
			System.out.println("---------------사용자 명을 입력하시오---------------");
			String memName = scanner.nextLine();

			for(int i=0;i<memList.size();i++){

				if(memList.get(i).getMemName().equals(memName)){
					System.out.println("-------------------------------------");
					System.out.println("사용자 번호:"+ index);
					System.out.println("사용자 명:"+ memList.get(i).getMemName());
					System.out.println("사용자 전화번호:"+ memList.get(i).getMemPhone());
					System.out.println("사용자 직업:"+ memList.get(i).getMemJob());
					System.out.println("사용자 이메일:"+ memList.get(i).getMemEmail());
					System.out.println("-------------------------------------");
					break;
				}else{
					index = i+1;
					if(index == memList.size()){
						System.out.println("정확한 사용자 명을 입력하시오---------------");
					}
				}

			}

		}else{
			System.out.println("정확한 값을 입력하시오---------------");
		}

	}
	public void memInsert(){
		mvo = new MemVO();
		System.out.print("사용자 명: ");
		input = scanner.next();
		mvo.setMemName(input);
		System.out.println();
		System.out.print("사용자 전화번호: ");
		input = scanner.next();
		mvo.setMemPhone(input);
		System.out.println();
		System.out.print("사용자 직업: ");
		input = scanner.next();
		mvo.setMemJob(input);
		System.out.println();
		System.out.print("사용자 이메일: ");
		input = scanner.next();
		mvo.setMemEmail(input);
		System.out.println();
		System.out.println("---------------사용자 등록 완료---------------");

		memList.add(mvo);
	}
	public void memUpdate(){
		System.out.println("---------------수정할 사용자 명을 입력하시오---------------");
		input = scanner.nextLine();

		for(int i=0;i<memList.size();i++){

			if(memList.get(i).getMemName().equals(input)){
				System.out.println("---------------수정할 내용을 입력하시오---------------");
				System.out.println("---------------name/phone/job/email---------------");
				input = scanner.nextLine();
				if(input.equals("name")){
					System.out.print("수정할 이름: ");
					input = scanner.next();
					memList.get(i).setMemName(input);
					System.out.println();
					System.out.println("---------------Update Success!---------------");
					break;
				}else if(input.equals("phone")){
					System.out.print("수정할 전화번호: ");
					input = scanner.next();
					memList.get(i).setMemPhone(input);
					System.out.println();
					System.out.println("---------------Update Success!---------------");
					break;
				}else if(input.equals("job")){
					System.out.print("수정할 직업: ");
					input = scanner.next();
					memList.get(i).setMemJob(input);
					System.out.println();
					System.out.println("---------------Update Success!---------------");
					break;
				}else if(input.equals("email")){
					System.out.print("수정할 이메일: ");
					input = scanner.next();
					memList.get(i).setMemEmail(input);
					System.out.println();
					System.out.println("---------------Update Success!---------------");
					break;
				}else{
					System.out.println("정확한 값을 입력하시오---------------");
				}

				break;
			}else{
				index = i+1;
				if(index == memList.size()){
					System.out.println("정확한 사용자 명을 입력하시오---------------");
				}
			}
		}

	}
	public void memDelete(){
		System.out.println("---------------수정할 사용자 명을 입력하시오---------------");
		input = scanner.nextLine();

		for(int i=0;i<memList.size();i++){

			if(memList.get(i).getMemName().equals(input)){

				System.out.println("---------------사용자를 찾았습니다---------------");
				System.out.println("---------------정말 삭제하시겠습니까?---------------");
				System.out.println("---------------Y/N---------------");
				input = scanner.nextLine();
				if(input.equals("Y")){
					memList.remove(i);
					System.out.println("---------------데이터를 삭제하였습니다---------------");
				}else if(input.equals("N")){
					System.out.println("---------------취소하였습니다---------------");
				}else{
					System.out.println("정확한 값을 입력하시오---------------");
				}

			}else{
				index = i+1;
				if(index == memList.size()){
					System.out.println("정확한 사용자 명을 입력하시오---------------");
				}
			}
		}
	}


}
