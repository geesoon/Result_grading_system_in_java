import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

class Project {
    static Scanner scnr_key = new Scanner(System.in);
    static String data_filename = "";
    static String result_filename = "";
    static Vector<Student> student = new Vector<Student>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int opr = 0;

        while (opr != 5) {
            System.out.println();
            System.out.println("1. Set data file - " + data_filename);
            System.out.println("2. List data");
            System.out.println("3. List Result");
            System.out.println("4. Save Result - " + result_filename);
            System.out.println("5. Quit");
            System.out.println();
            System.out.print("Choose operation: ");

            try {
                opr = scnr_key.nextInt();
                scnr_key.nextLine();

                if (opr == 1) {
                    student.clear();
                    setDataFile();
                } else if (opr == 2) {
                    listData();
                } else if (opr == 3) {
                    listResult();
                } else if (opr == 4) {
                    saveResult();
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter valid integer number.");
                scnr_key.nextLine();
            }
        }
    }

    public static void setDataFile() throws FileNotFoundException, IOException {
        System.out.println();
        System.out.print("Enter file name: ");
        data_filename = scnr_key.nextLine();
        
        File file = new File(".//" + data_filename);
        Scanner readFile = new Scanner(file);

        int count = 0;
        while(readFile.hasNextLine()){
            readFile.useDelimiter("\t");
            String name = readFile.next();
            readFile.useDelimiter("\t");
            String coursework = readFile.next();
            String finalexam = readFile.nextLine();
            String[] fe = finalexam.split("\t");
            int finalExam = Integer.parseInt(fe[1]);
            int courseWork = Integer.parseInt(coursework);
            Mark mark = new Mark(courseWork, finalExam);
            student.add(count, new Student(name, mark));
            count++;
        }
        readFile.close();
    }

    public static void listData() {
        System.out.println();
        System.out.print("Press ENTER to continue...");
        scnr_key.nextLine();
        for(int i=0; i<student.size(); i++){  
            Student stud = student.get(i);
            stud.printData();
       }
    }

    public static void listResult() {
        System.out.println();
        System.out.print("Press ENTER to continue...");
        scnr_key.nextLine();
        for(int i=0; i<student.size(); i++){
            Student stud = student.get(i);
            stud.printResult();
        }
    }

    public static void saveResult() throws FileNotFoundException, IOException {
        System.out.println(data_filename);
        String[] filesplit =data_filename.split(".txt");
        System.out.println(filesplit[0]);
        result_filename = filesplit[0] + "-result.txt"; 
        FileWriter writeFile = new FileWriter(".//" + result_filename);

        for(int i=0; i<student.size(); i++){
            Student stud = student.get(i);
            writeFile.write(stud.getResult());
        }
        writeFile.close();
    }
}