import java.util.*;

public class Main {

    static ArrayList<Employee> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    static void addTemporary() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Hours Worked: ");
        int hours = sc.nextInt();

        System.out.print("Rate per Hour: ");
        double rate = sc.nextDouble();

        list.add(new TemporaryEmployee(id, name, hours, rate));
        System.out.println("Temporary Employee Added!");
    }

    
    static void addPermanent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Basic Salary: ");
        double basic = sc.nextDouble();

        System.out.print("Bonus: ");
        double bonus = sc.nextDouble();

        list.add(new PermanentEmployee(id, name, basic, bonus));
        System.out.println("Permanent Employee Added!");
    }

    
    static void displayAll() {
        for (Employee e : list) {
            e.display();  
            System.out.println("----------------");
        }
    }

    
    static Employee search(int id) {
        for (Employee e : list) {
            if (e.getEmpId() == id) return e;
        }
        return null;

    }
    static void updateSalary() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee e = search(id);

        if (e == null) {
            System.out.println("Employee not found!");
            return;
        }

        if (e instanceof TemporaryEmployee) {
            System.out.print("New Hours: ");
            int h = sc.nextInt();
            System.out.print("New Rate: ");
            double r = sc.nextDouble();

            
            list.remove(e);
            list.add(new TemporaryEmployee(id, e.name, h, r));
        } else if (e instanceof PermanentEmployee) {
            System.out.print("New Basic Salary: ");
            double b = sc.nextDouble();
            System.out.print("New Bonus: ");
            double bo = sc.nextDouble();

            list.remove(e);
            list.add(new PermanentEmployee(id, e.name, b, bo));
        }

        System.out.println("Salary Updated!");
    }

    
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1.Add Temp 2.Add Perm 3.Display 4.Search 5.Update 6.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: addTemporary(); break;
                case 2: addPermanent(); break;
                case 3: displayAll(); break;
                case 4:
                    System.out.print("Enter ID: ");
                    Employee e = search(sc.nextInt());
                    if (e != null) e.display();
                    else System.out.println("Not found");
                    break;
                case 5: updateSalary(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid");
            }
        }
    }
}