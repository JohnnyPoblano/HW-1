/*
**  John Gumm
**  CIS279
**  HW1
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HW1 {

    public static void main(String args[]) {
        File file = new File("HW1_Students.txt");

        // Arraylists for holding student data
        ArrayList<Integer> studentNums = new ArrayList<Integer>();
        ArrayList<String> studentNames = new ArrayList<String>();
        ArrayList<Double> studentGrades = new ArrayList<Double>();

        // Import student data
        try {
           
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()) {

                // Get student number
                String studentNumStr = scanner.nextLine();
                int studentNum = Integer.parseInt(studentNumStr);
                studentNums.add(studentNum);

                // Get student name
                String studentName = scanner.nextLine();
                studentNames.add(studentName);

                // Get student grade
                String studentGradeStr = scanner.nextLine();
                double studentGrade = Double.parseDouble(studentGradeStr);
                studentGrades.add(studentGrade);

            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Get average grade
        double totalGrade = 0;
        for (int i = 0; i < studentGrades.size(); i++) {
            totalGrade += studentGrades.get(i);
        }
        double averageGrade = totalGrade / studentGrades.size();

        // Get standard deviation
        double stDev = 0;
        for (int i = 0; i < studentGrades.size(); i++) {
            stDev += Math.pow(studentGrades.get(i) - averageGrade, 2);
        }
        
        stDev = (stDev) / (studentGrades.size()-1);
        stDev = Math.sqrt(stDev);

        // Print table header
        System.out.printf("\nGroup average: %-8.1f Standard deviation: %3.5f\n\n", averageGrade, stDev);
        System.out.println("                                            Relative to               Letter");
        System.out.println("Student                 Score               Average                   Grade\n");
    }
}