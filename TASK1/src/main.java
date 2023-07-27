
import java.math.*;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		int round=0;
		boolean	cont =false;
		Scanner sc=new Scanner(System.in) ;
		do {
			round++;
	
	
		  int randomInt = (int) (Math.random() * 100) + 1;
		  int x = 0;
		  System.out.println("random "+randomInt);
		  int score=0;
		  int attempts=5;
		  
		  do {
		  System.out.println("enter integer from 1 to 100");
		  
			  x= sc.nextInt();
		  
		  
		  if(x==randomInt) {
			  System.out.println(" is correct");
			  score++;
			  break;
		  }else if(x<randomInt){
			  System.out.println("too low");
			  attempts--;
			  System.out.println("you still have "+attempts+ " attempts");
		  }else {
			  System.out.println("too high");
			  attempts--;
			  System.out.println("you still have "+attempts+ " attempts");
		  }
				  
		  }while(attempts!=0);
		  if(attempts==0) {
			  System.out.println("game over ");
		  }
		  System.out.println("your score: "+score +" "+"round: "+round);
		  System.out.println("----------------------------------------");
		  System.out.println("new round ?  (yes/no)");
		  String option = sc.next();
		  if(option.equalsIgnoreCase("yes")) {
			  cont=true;
		  }else {
			  cont=false;
		  }
	} while(cont);
		  
sc.close();
System.out.println("good game");
	}

}
