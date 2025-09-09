import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
class Employee{
	int id;
	String name;
	int age;
	String address;
	String phone;
	String aadhar;
	String degree;
	String bankAccount;
	String sex;
	String qualification;
	int experience;
	Employee(int id,String name,int age,String address,String phone,String aadhar,String degree,String bankAccount,String sex,String qualification,int experience) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.address=address;
		this.phone=phone;
		this.aadhar=aadhar;
		this.degree=degree;
		this.bankAccount=bankAccount;
		this.sex=sex;
		this.qualification=qualification;
		this.experience=experience;
	}
	void display(){
		System.out.println("\nEmployee Details");
		System.out.println("Id:"+id);
		System.out.println("Name:"+name);
		System.out.println("Age:"+age);
		System.out.println("Address:"+address);
		System.out.println("Phone:"+phone);
		System.out.println("Aadhar:"+aadhar);
		System.out.println("Degree:"+degree);
		System.out.println("Bankaccount:"+bankAccount);
		System.out.println("Sex:"+sex);
		System.out.println("Qualification:"+qualification);
		System.out.println("Experience:"+experience);
	}
	void update(String name,int age,String address,String phone,String aadhar,String degree,String bankAccount,String sex,String qualification,int experience) {
		this.name=name;
		this.age=age;
		this.address=address;
		this.phone=phone;
		this.aadhar=aadhar;
		this.degree=degree;
		this.bankAccount=bankAccount;
		this.sex=sex;
		this.qualification=qualification;
		this.experience=experience;
	}
}
public class EmployeeManagementSystem{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Employee> employees = new ArrayList<>();
	static final String ADMIN_ID = "admin123";
	static final String ADMIN_PASSWORD = "pass123";
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Admin ID:");
		String id=sc.nextLine();
		System.out.println("Enter a Password");
		String pass=sc.nextLine();
		if(id.equals("admin") && pass.equals("8769")) {
			System.out.println("Login Successfully");
			loadEmployees();
			while(true){
				System.out.println("\nEmployee Management Menu");
				System.out.println("1.Create Employee");
				System.out.println("2.Add Employee");
				System.out.println("3.Update Employee");
				System.out.println("4.Delete Employee");
				System.out.println("5.Display Employee");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					createEmployee();
				case 2:
					addEmployee();
					break;
				case 3:
					updateEmployee();
					break;
				case 4:
					deleteEmployee();
					break;
				case 5:
					displayEmployee();
					break;
				}
			}
		}else{
			System.out.println("Access Denied");
		}
	}
	static void loadEmployees(){
		employees.add(new Employee(8000,"Kannan",21,"Pudukkottai","9293939393","1234-5678-1111", "B.E EEE", "AC00112233", "Male", "Graduate", 5));
		employees.add(new Employee(8001,"Kishore",21,"Karaikudi","9293939396","1234-5678-2222", "B.E ECE", "AC00222244", "Male", "Graduate", 3));
		employees.add(new Employee(8001,"Sivamani",21,"Karaikudi","9293939386","1234-5678-3333", "B.E ECE", "AC00442244", "Male", "Graduate", 4));
		employees.add(new Employee(8001,"Sri Rishan",21,"Kallal","9293935396","1234-5678-4444", "B.E ECE", "AC001552244", "Male", "Graduate", 2));
	}
	static void createEmployee(){
		if(employees.isEmpty()){
			System.out.println("Employee is already exists");
			return;
		}
		System.out.println("Creating Employee Record");
		Employee emp=getEmployeeInput();
		employees.add(emp);
		System.out.println("Employee Created Successfully");
		emp.display();
	}
	static void addEmployee(){
		employees.add(getEmployeeInput());
		System.out.println("Employee Added Successfully");
	}
	static void updateEmployee(){
		System.out.println("Enter Employee Id to Update");
		int updateId=sc.nextInt();
		sc.nextLine();
		for(Employee emp:employees){
			if(emp.id==updateId){
				System.out.println("Enter New Details:");
				Employee updated=getEmployeeInput(updateId);
				emp.update(updated.name,updated.age,updated.address,updated.phone,updated.aadhar,updated.degree,updated.bankAccount,updated.sex,updated.qualification,updated.experience);
				System.out.println("Employee Update Successfully:");
				return;
			}
		}
		System.out.println("Employee Not Found!");
	}
	static void deleteEmployee(){
		System.out.println("Enter Employee Id to Delete:");
		int DeleteId=sc.nextInt();
		sc.nextLine();
		Iterator<Employee>iterator=employees.iterator();
		while(iterator.hasNext()){
			Employee emp=iterator.next();
			int deleteId=sc.nextInt();
			if(emp.id==deleteId){
				iterator.remove();
				System.out.println("Employee Delete Successfully:");
				return;
			}
		}
		System.out.println("Employee not found");
	}
	static void displayEmployee(){
    if (employees.isEmpty()){
        System.out.println("No Employee Found");
    }else{
        System.out.println("Enter Employee Id to Display: ");
        int searchId=sc.nextInt();
        sc.nextLine();
        if(searchId==0){
            for (Employee emp : employees) {
                emp.display();
            }
        }else{
            boolean found=false;
            for(Employee emp:employees){
                if (emp.id==searchId){
                    emp.display();
                    found=true;
                    break;
                }
            }
            if(found){
                System.out.println("Employee with ID:"+searchId);
            }
        }
    }
}
	static Employee getEmployeeInput(){
		System.out.println("Enter Employee Id:");
		int id=sc.nextInt();
		sc.nextLine();
		return getEmployeeInput(id);
	}
	static Employee getEmployeeInput(int Id){
		System.out.println("Enter Name:");
		String name=sc.nextLine();
		System.out.println("Enter Age:");
		int age=sc.nextInt();
		System.out.println("Enter Address:");
		String address=sc.nextLine();
		System.out.println("Enter Phone:");
		String phone=sc.nextLine();
		System.out.println("Enter Aadhar:");
		String aadhar=sc.nextLine();
		System.out.println("Enter Degree:");
		String degree=sc.nextLine();
		System.out.println("Enter Bankaccount:");
		String bankaccount=sc.nextLine();
		System.out.println("Enter Sex:");
		String sex=sc.nextLine();
		System.out.println("Enter Qualification:");
		String qualification=sc.nextLine();
		System.out.println("Enter Experience:");
		int experience=sc.nextInt();
		sc.nextLine();
		return new Employee(Id,name,age,address,phone,aadhar,degree,bankaccount,sex,qualification,experience);
	}
}