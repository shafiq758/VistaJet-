package Bystored;

import java.util.Scanner;

public class ChoiceMaker {
	
	int one= 1;
	int two= 2;
	int Choice;
public void choice () throws InterruptedException
{
	ServerLoader a =new ServerLoader();
	

System.out.println("Enter Your Choice:"+"\n" +"1: Firefox"+"2: Chrome");

Scanner scanner = new Scanner (System.in);
Choice=scanner.nextInt();


if (one==Choice){
a.beforeTest();

}
else if (two==Choice){
	
	//a.beforeWebdriver();
}
}
}
