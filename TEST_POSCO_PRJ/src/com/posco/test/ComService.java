package com.posco.test;

import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComService {

	Scanner scanner = new Scanner(System.in);
	Logger logger = LoggerFactory.getLogger(ComService.class);
	ArrayList<ComVO> comList = new ArrayList<ComVO>();
	ComVO cvo;
	MemService mservice;
	String input;
	int index;

	public String conStart(){
		System.out.println("---------------로그인/가입/exit---------------");
		input = scanner.nextLine();
		return input;
	}

	public String conRepeat(String input){
		mservice = new MemService();
		String result = null;
		if(input.equals("로그인")){
			if(!comList.isEmpty()){
				login();
				if(index > -1){
					mservice.memMain();
				}
			}else{
				System.out.println("회원이 없어요...---------------");
			}
		}else if(input.equals("가입")){
			ComVO cvo = signIn();
			comList.add(cvo);
		}else if(input.equals("exit")){
			result = "exit";
		}else{
			System.out.println("정확한 값을 입력하시오---------------");
		}
		return result;
	}

	public void login(){

		System.out.println("---------------사용자 명을 입력하시오---------------");
		String comName = scanner.nextLine();
		if(!comList.isEmpty()){
			for(int i=0;i<comList.size();i++){

				if(comList.get(i).getComName().equals(comName)){
					System.out.println("---------------전화번호를 입력하시오---------------");
					String comPhone = scanner.nextLine();
					if(comList.get(i).getComPhone().equals(comPhone)){
						System.out.println("---------------Login success!---------------");
						System.out.println();
						index = i+1;
						System.out.println("---------------"+index+"번째 사용자님 접속---------------");
						index = i;
						break;
					}else{
						System.out.println("사용자명과 전화번호가 맞지 않습니다---------------");
						index = -1;
					}
				}else{
					index = i+1;
					if(index == comList.size()){
						System.out.println("정확한 사용자 명을 입력하시오---------------");
						index = -1;
					}
				}

			}
		}else{
			System.out.println("사용자는 없소");
		}

	}

	public ComVO signIn(){

		ComVO cvo = new ComVO();
		System.out.println("---------------사용자 명을 입력하시오---------------");
		input = scanner.nextLine();
		cvo.setComName(input);
		System.out.println("---------------전화번호를 입력하시오---------------");
		input = scanner.nextLine();
		cvo.setComPhone(input);

		System.out.println("---------------Sign in success!---------------");
		System.out.println();
		return cvo;
	}



}
