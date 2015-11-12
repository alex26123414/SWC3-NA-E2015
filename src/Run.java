
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex-Lenovo
 */
public class Run {

    public static void main(String[] args) {
        printMenu();

        Exam swc3 = new Exam("Prog", new GregorianCalendar(2015, 11, 21));
        Exam swd3 = new Exam("Design", new GregorianCalendar(2015, 11, 14));

        Student th = new Student("Thomas", 12_07_90_2727);
        Student alice = new Student("Alice", 12_10_94_1012);
        Student ben = new Student("Benjamin", 23_10_95_1235L);

        HashMap<Exam, Set<Grade>> exmaMap = new HashMap<>();

        Set<Grade> setSWC = new TreeSet<>();
        setSWC.add(new Grade(13, swc3, ben));
        setSWC.add(new Grade(12, swc3, th));
        setSWC.add(new Grade(null, swc3, alice));

        Set<Grade> setSWD = new TreeSet<>();
        setSWD.add(new Grade(12, swd3, ben));
        setSWD.add(new Grade(10, swc3, th));

        exmaMap.put(swd3, setSWD);
        exmaMap.put(swc3, setSWC);

        printTable(exmaMap);
    }

    private static void printTable(HashMap<Exam, Set<Grade>> exmaMap) {
        System.out.printf("%-20s%-30s%-20s\n", "Exam", "Student", "Grade");
        for (Map.Entry<Exam, Set<Grade>> entrySet : exmaMap.entrySet()) {
            Exam exam = entrySet.getKey();
            Set<Grade> grades = entrySet.getValue();
            String ex = String.format("%-20s", exam);
            for (Grade grade : grades) {
                System.out.printf("%-20s%-30s%-20s\n", ex, grade.getStudent(), grade);
                ex = "";
            }
            System.out.printf("%35s\n", String.format("===== AVG %.2f =====", avgExam(grades)));
        }
    }

    private static double avgExam(Set<Grade> grades) {
        double avg = 0;
        int count = 0;
        for (Grade grade : grades) {
            if (grade.getGrade() != null) {
                avg += grade.getGrade();
                count++;
            }
        }
        return avg / count;
    }

    private static void printMenu() {
        System.out.println("Choose an action");
        System.out.println("1 - Add new Student");
        System.out.println("2 - Add new Exam");
        System.out.println("3 - Add new Grade");
        System.out.println("4 - Show");
        System.out.println("Your action is: ");

        Scanner in = new Scanner(System.in);
        int action = in.nextInt();
        switch (action) {
            case 1:
                addStudent();
                break;
            case 2:
                addExam();
                break;
            case 3:
                addGrade();
                break;
            case 4:
                show();
                break;
            default:
                //TODO print username
                System.out.println("Thomas or Emil, read the instruction pls!");
                break;
        }
    }

    private static void addStudent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Stud info?");
        System.out.print("-->  name = ");
        String name = in.next();
        System.out.println("--> cpr = ");
        long cpr = in.nextLong();

        Student s = new Student(name, cpr);
        System.out.println(s);
    }

    private static void addExam() {
        Scanner in = new Scanner(System.in);
        System.out.println("Exam info?");
        System.out.print("-->  name = ");
        String name = in.next();
        System.out.println("--> date(DDMMYYYY) = ");
        String date = in.next();

        //012345678
        //DDMMYYYY
        int dd = Integer.parseInt(date.substring(0, 2));
        int mm= Integer.parseInt(date.substring(2, 4));
        int yyyy= Integer.parseInt(date.substring(4, 8));
        Exam e = new Exam(name, new GregorianCalendar(yyyy, mm-1, dd));
        System.out.println(e);
    }

    //TODO
    private static void addGrade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //TODO
    private static void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
