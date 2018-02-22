package first;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PhoneBook {
    public static String help_message = "press H help, A for add contact ,S Search:";

    public static void main(String[] args) {
        System.out.println("-------- \n\n");
        Scanner s = new Scanner(System.in);
        for (; ; ) {
            System.out.print("top of page" + help_message);
            String command = s.nextLine().trim();

            switch (command.toLowerCase()) {
                case "h":
                    System.out.println(help_message);
                    break;
                case "a":
                    System.out.println("Give the following details: Name , Number :");
                    String values = s.nextLine().trim();
                    String[] tmp = values.split(",");
                    while (tmp.length != 2) {
                        System.out.println("wrong Format enter again");
                        values = s.nextLine().trim();
                        tmp = values.split(",");
                    }
                    try {
                        FileWriter fs = new FileWriter("details.csv", true);
                        BufferedWriter out = new BufferedWriter(fs);
                        out.write(values + "\n");
                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "s":
                    System.out.println("Enter name to search : ");

                    String search = s.nextLine().trim();
                    search = search.toLowerCase();
                    try {
                        File f = new File("details.csv");
                        Scanner s2 = new Scanner(f);
                        while (s2.hasNextLine()) {
                            String line = s2.nextLine();
                            if (line.toLowerCase().indexOf(search) >= 0) {
                                System.out.println("\n Result : " + line);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "q":
                    System.out.println("exiting");
                    System.exit(0);
                    break;
                case "db":
                    if(!CheckTable.tableExistFunc()){
                        if(CheckTable.createTable() == 1){
                            System.out.println("Table Created Successfully");
                        }else{
                            System.out.println("Error in Printing Table");
                        }
                    }else {
                        System.out.println("Table Already Exist appending there");
                    }
                    break;
                default:
                    System.out.println("enter correct details");
                    break;
            }
        }

    }

}



/*
*

package first;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PhoneBook {
    public static String help_message = "press H help, A for add contact ,S Search";

    public static void main(String[] args) {
        System.out.println("-------- \n\n");
        Scanner s = new Scanner(System.in);
        for (; ; ) {
            System.out.print("top of page" + help_message);
            String command = s.nextLine().trim();
            if (command.equalsIgnoreCase("H")) {
                System.out.println(help_message);
            } else if (command.equalsIgnoreCase("A")) {
                System.out.println("Give the following details: Name , Number :");
                String values = s.nextLine().trim();
                String [] tmp= values.split(",");
                while(tmp.length != 2){
                    System.out.println("wrong Format enter again");
                    values = s.nextLine().trim();
                    tmp = values.split(",");
                }
                try{
                    FileWriter fs = new FileWriter("details.csv",true);
                    BufferedWriter out = new BufferedWriter(fs);
                    out.write(values + "\n");
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            } else if (command.equalsIgnoreCase("S")) {
                System.out.println("Enter name to search : ");

                String search=s.nextLine().trim();
                search = search.toLowerCase();
                try{
                    File f = new File("details.csv");
                    Scanner s2 = new Scanner(f);
                    while (s2.hasNextLine()){
                        String line= s2.nextLine();
                        if(line.toLowerCase().indexOf(search)>=0){
                            System.out.println("\n Result : "+ line);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            } else if (command.equalsIgnoreCase("Q")) {
                System.out.println("exiting");
                System.exit(0);
            } else {
                System.out.println("enter correct details");
            }

        }
    }

}




*
* */