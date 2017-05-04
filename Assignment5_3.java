import java.util.*;
abstract class Employee{		//abstract class
	int empId;
	String empName;
	int total_leaves;
	double total_salary;
	public abstract void calculate_balance_leaves();
	public abstract boolean avail_leave(int no_of_leaves, char type_of_leave);
	public abstract void calculate_salary();
}
class PermanentEmp extends Employee{		//PermanentEmp inherits class Employee
    int PAID_LEAVE, SICK_LEAVE, CASUAL_LEAVE;
	double basic, hra,pfa;
	public PermanentEmp(int empId, String empName, int basic) {	
		// TODO Auto-generated constructor stub
		this.empId=empId;
 		this.empName=empName;
 		this.basic = basic;
 		PAID_LEAVE=10;
 		SICK_LEAVE=4;
 		CASUAL_LEAVE=5;
 		total_leaves= PAID_LEAVE+ SICK_LEAVE+ CASUAL_LEAVE;
 		// different type of leaves are set to each employee
	}
@Override
    public void calculate_balance_leaves() {		//calculating balance leaves
		 		System.out.println("Total available leaves are: "+(PAID_LEAVE+SICK_LEAVE+CASUAL_LEAVE));
    }
@Override
	public boolean avail_leave(int no_of_leaves, char type_of_leave) {
	     if (type_of_leave=='p'){
		 	if(PAID_LEAVE-no_of_leaves>=0){
		 		total_leaves-=no_of_leaves;
		 		PAID_LEAVE-=no_of_leaves;
		 		return true;
		 	}
		 	else {
		 		System.out.println("You can't get leave!! ");
		 		return false;
		 	}
	     }
		 else if(type_of_leave=='s'){
		 	if(SICK_LEAVE-no_of_leaves>=0){
		 		total_leaves-=no_of_leaves;
		 		SICK_LEAVE-=no_of_leaves;
		 		return true;
		 	}
		 	else{
		 		System.out.println("You can't get leave!! ");
		 		return false;
		 	}
		 }
		 else if(type_of_leave=='c'){
		 	if(CASUAL_LEAVE-no_of_leaves>=0){
		 		CASUAL_LEAVE-=no_of_leaves;
		 		total_leaves-=no_of_leaves;
		 		return true;
			}
		 	else{
		 		System.out.println("You can't get leave!! ");
		 		return false;
		 	}
		 }
		 System.out.println("You can't get leave!! ");
		 return false;
		 }
		 @Override
      public void calculate_salary() {		//calculating salary
		 pfa = .12*basic;
		 hra = .5 *basic;
		 total_salary = basic + (.5 *basic)-(.12*basic);
		 System.out.println("Total salary of "+this.empName+ "'s is :"+ total_salary);
	  }
	  void print_leave_details(){		//calculating leave details
		 System.out.println("PermenantEmp [paid_leave=" + PAID_LEAVE + ", sick_leave=" + SICK_LEAVE + ", casual_leave="
		 				+ CASUAL_LEAVE + "]");
		 }
}
class TemporaryEmp extends Employee{		//TemporaryEmp inherits class Employee
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
	public	void calculate_balance_leaves() {		//calculating balance leaves
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
    public void calculate_salary() {			//calculating salary
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
	 		    p.avail_leave(k, h);		//calling methods of permanent employee
	 		    p.print_leave_details();
	 		    p.calculate_salary();
	 		    p.calculate_balance_leaves();
                            break;
	 		}
	 		case 2:{
	 		    TemporaryEmp t = new TemporaryEmp(12, name, 20000);
	 		    t.avail_leave(k, 'p');
	 		    t.calculate_salary();		//calling methods of temporary employee
	 		    t.calculate_balance_leaves();
	 		    break;
	 		}
	 		
	 	}
	 
	 }
}