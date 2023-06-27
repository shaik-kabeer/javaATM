// the main class
package test;
import macess.*;
import java.util.*;

public class BankMainClass {

	public static void main(String[] args) {
  Scanner s = new Scanner (System.in);
  int count=0;
  pqr: 
	  while (true) {
		  System.out.println("enter the pin no:");
		  int PinNo =s.nextInt();
		  CheckPinNo cpn =new CheckPinNo();
		  boolean k = cpn.verify(PinNo);
		  if (k)
{   System.out.println("====choice =====");
System.out.println("1.withdraw\n2.deposit\n3.check balance ");
			  System.out.println("enter the choice :");
			  switch(s.nextInt())
			  {
			  case 1 :
				  System.out.println("enter the amount:");
				 int a1=s.nextInt();
				 if(a1>0&&a1%100==0)
				 {
					 Withdraw wd = new Withdraw();
					 wd.process(a1);;
					 
				 }else
				 {
					 System.out.println("invaild amt..");
					 
				 }
				 break pqr;
				 
			  case 2:
				  System.out.println("enter the amt :");
				  int a2 =s.nextInt();
				  if (a2>0&&a2%100==0)
				  {
					  Deposit dp =new Deposit();
					  dp.process(a2);
					  
				  }
				  else {
					  System.out.println("invalid amt...");
				  }	  
	
				  break pqr ;
				  
			  
}	  }
			  
			  
			  else { 
				  System.out.println("invalid pinNo...");
				  count++;
				  
			  }
			  if (count==3)
			  {
				  System.out.println("transaction blocked ....");
				  break;
				  
				  
				  
				  
			  }
				  
			  }
	  
				  
}} 
// the balance class
package macess;

public class Balance {
	public double bal = 2000 ;
	public double getBalance()	{
		return bal;
		
	}

}
// the pin check clss
package macess;

public class CheckPinNo {
	public boolean verify(int PinNo) {
		return switch (PinNo) {
		case 1111 : yield true;
		case 2222 : yield true;
		case 3333 : yield true ;
		default :yield false;
		
		 };
	}

}
// the deposit clss
package macess;

public class Deposit implements Transaction  {
public void process (int amt) {
	System.out.println("amt deposited ;"+amt);
	b.bal=b.bal+amt;
	System.out.println("balance amt:"+b.getBalance());
	System.out.println("transaction completed...");
	
}
	
}
//the transaction class
package macess;

public interface Transaction {
	public static final Balance b = new Balance();
	public abstract void process (int amt);
	
}
// the withdraw class
package macess;

 public class Withdraw implements Transaction {
 public void process (int amt){
if (amt<b.bal) {
	

	 System.out.println("amt withdrawn :"+amt);
 b.bal=b.bal-amt ;
System.out.println("balance amt:"+b.getBalance());
System.out.println("transaction completed...");
}
else
{System.out.println ("in suffient fund...");

}
 }
 }



