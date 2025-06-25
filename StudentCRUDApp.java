import java.util.ArrayList;
import java.util.Scanner;

class Learner {
    private int rollNo;
    private String fullName;
    private int score;

    public Learner(int rollNo, String fullName, int score) {
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.score = score;
    }

    public int getRollNo() { return rollNo; }

    public void setRollNo(int rollNo) { this.rollNo = rollNo; }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    @Override
    public String toString() {
        return "[Roll No: " + rollNo + ", Name: " + fullName + ", Score: " + score + "]";
    }
}

public class StudentCRUDApp {
    static ArrayList<Learner> records = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n===== Student CRUD Menu =====");
            System.out.println("1. Insert Record");
            System.out.println("2. Display All Records");
            System.out.println("3. Modify Record");
            System.out.println("4. Remove Record");
            System.out.println("5. Quit");
            System.out.print("Select an option: ");
            option = input.nextInt();
            input.nextLine(); // Clear buffer

            switch (option) {
                case 1: insertRecord(); break;
                case 2: displayRecords(); break;
                case 3: modifyRecord(); break;
                case 4: removeRecord(); break;
                case 5: System.out.println("Thank you! Exiting..."); break;
                default: System.out.println("Invalid choice, try again.");
            }
        } while (option != 5);
    }

    static void insertRecord() {
        System.out.print("Enter Roll Number: ");
        int roll = input.nextInt();
        input.nextLine();
        System.out.print("Enter Full Name: ");
        String name = input.nextLine();
        System.out.print("Enter Score: ");
        int score = input.nextInt();

        records.add(new Learner(roll, name, score));
        System.out.println("Record inserted successfully.");
    }

    static void displayRecords() {
        if (records.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("----- Student Records -----");
        for (Learner l : records) {
            System.out.println(l);
        }
    }

    static void modifyRecord() {
        System.out.print("Enter Roll Number to modify: ");
        int roll = input.nextInt();
        input.nextLine();
        for (Learner l : records) {
            if (l.getRollNo() == roll) {
                System.out.print("Enter New Name: ");
                l.setFullName(input.nextLine());
                System.out.print("Enter New Score: ");
                l.setScore(input.nextInt());
                System.out.println("Record updated.");
                return;
            }
        }
        System.out.println("Record not found.");
    }

    static void removeRecord() {
        System.out.print("Enter Roll Number to delete: ");
        int roll = input.nextInt();
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getRollNo() == roll) {
                records.remove(i);
                System.out.println("Record deleted.");
                return;
            }
        }
        System.out.println("Record not found.");
    }
}
