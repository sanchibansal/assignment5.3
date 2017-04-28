import java.util.*;
abstract class Employee{
	
	int empId;
	String empName;
	int total_leaves;
	double total_salary;
	public abstract void calculate_balance_leaves();
	public abstract boolean avail_leave(int no_of_leaves, char type_of_leave);
	public abstract void calculate_salary();
}
class PermanentEmp extends Employee{			//extends abstract class
	int paid_leave, sick_leave, casual_leave;
	double basic, hra,pfa;
	public PermanentEmp(int empId, String empName, int basic) {
		// TODO Auto-generated constructor stub
		this.empId=empId;
 		this.empName=empName;
 		this.basic = basic;
 		paid_leave=10;
 		sick_leave=4;
 		casual_leave=5;
 		total_leaves= (paid_leave+ sick_leave+ casual_leave);
 				// different type of leaves are set to each employee
	}

		 @Override
			public void calculate_balance_leaves() {	//prints balance leaves of a permanent employee
		 		System.out.println("Total available leaves are: "+(paid_leave+sick_leave+casual_leave));
		 			}
		 @Override
		 	public boolean avail_leave(int no_of_leaves, char type_of_leave) {	
		 		if (type_of_leave=='p'){
		 			if(paid_leave-no_of_leaves>=0){
		 				total_leaves-=no_of_leaves;
		 				paid_leave-=no_of_leaves;
		 				return true;
		 		}
		 			else { System.out.println("You can't get leave!! ");
		 				return false;
		 			}
		 		}
		 		else if(type_of_leave=='s'){
		 		if(sick_leave-no_of_leaves>=0){
		 				total_leaves-=no_of_leaves;
		 				sick_leave-=no_of_leaves;
		 				return true;
		 			}
		 			else{ System.out.println("You can't get leave!! ");
		 			return false;
		 		}
		 		}
		 		else if(type_of_leave=='c'){
		 			if(casual_leave-no_of_leaves>=0){
		 				casual_leave-=no_of_leaves;
		 				total_leaves-=no_of_leaves;
		 				return true;
					}
		 				
		 			else{ System.out.println("You can't get leave!! ");
		 			return false;
		 		}
		 		}
		 		System.out.println("You can't get leave!! ");
		 	return false;
		 	}
		 
		 	@Override
		public void calculate_salary() {		//calculates the salary
		 		pfa = .12*basic;
		 		hra = .5 *basic;
		 		total_salary = basic + (.5 *basic)-(.12*basic);
		 		System.out.println("Total salary of "+this.empName+ "'s is :"+ total_salary);
		 		
		 	}
		 	void print_leave_details(){		//prints leave details of the employee
		 		System.out.println("PermenantEmp [paid_leave=" + paid_leave + ", sick_leave=" + sick_leave + ",  casual_leave="+ casual_leave + "]");
		 	}
		 	
		 }

class TemporaryEmp extends Employee{		//extends abstract class
	int paid_leave, sick_leave, casual_leave;
	double basic, hra,pfa;
	public TemporaryEmp(int empId, String empName, double total_salary) {
		 		this.empId=empId;
		 		this.empName=empName;
		 		this.total_salary=total_salary;
		 		this.total_leaves=14;
		 		// there is only 14 leaves available for the Temporary employees 
		 	}
		 	@Override
		 public	void calculate_balance_leaves() {
		 		System.out.println("Total available leaves are:"+total_leaves);
		 		
		 	}
		 
		 	@Override
		 	public boolean avail_leave(int no_of_leaves, char type_of_leave) {
		 		if (no_of_leaves<=total_leaves){
		 			total_leaves-=no_of_leaves;
		 			return true;
		 		}
		 		else{
		 			System.out.println("You can't get leave!! ");
		 			return false;
		 		}
		 	}
		 
		 	@Override
		 	public void calculate_salary() {			// calculates the total salary
		 		double total_sal = total_salary + (.5 *total_salary)-(.12*total_salary);
		 		System.out.println("Total salary of "+this.empName+ "'s is :"+ total_sal);
		 		
			}
			
		 } 
public class Assignment5_3 {
	 	public static void main(String[] args) {
	 		Scanner g= new Scanner(System.in);
	 		System.out.println("enter employee name ");
	 		String name =g.next();
	 		System.out.println("enter type of employee \npress1 for permanent \npress 2 for temporary");
	 		int a=g.nextInt();
	 		System.out.println("enter number of leaves ");
	 		int k=g.nextInt();
	 		switch(a){
	 		case 1:{
	 		PermanentEmp p= new PermanentEmp(11, name, 5000);
	 		
	 		System.out.println("enter type of leave \nenter p for paid leave \nenter c for casual leave \nenter s for sick leave");
	 		char h=g.next().charAt(0);
	 		
	 		p.avail_leave(k, h);
	 		p.print_leave_details();
	 		p.calculate_salary();
	 		p.calculate_balance_leaves();
	 	
	 		break;
	 		}
	 		
	 		case 2:{
	 		TemporaryEmp t = new TemporaryEmp(12, name, 20000);
	 		
	 		t.avail_leave(k, 'p');
	 		t.calculate_salary();
	 		t.calculate_balance_leaves();
	 		
	 		break;
	 		}
	 		
	 	}
	 
	 }
	 	}