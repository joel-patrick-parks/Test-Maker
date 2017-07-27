import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TestClient {
	
	// Loads a test entered by the user
	public static void viewTest(Scanner scan) {
		System.out.println("Enter the name of the test you wish to load:");
		String buf = scan.nextLine();
		String fileLoad = scan.nextLine();
		
		while(fileLoad.equals("")){
			System.out.println("Enter the name of the test you wish to create:");
			fileLoad = scan.nextLine();
		}
		
		File file = new File(fileLoad);
		if(file.exists()){
			try {
				FileReader fileRead = new FileReader(file);
				BufferedReader in = new BufferedReader(fileRead);
				String currentLine;
				while((currentLine = in.readLine()) != null){
					System.out.println(currentLine);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("That file does not exist...");
		}
	}
	
	// Gets user input to create a test
	public static void createTest(Scanner scan){
		try {
			System.out.println("Enter the name of the test you wish to create:");
			String fileSave;
			String buf;
			buf = scan.nextLine();
			fileSave = scan.nextLine();
			
			while(fileSave.equals("")){
				System.out.println("Enter the name of the test you wish to create:");
				fileSave = scan.nextLine();
			}
			
			FileWriter file = new FileWriter(fileSave);
			int numberOfQuestions = 0;
			int count = 0;
			
			// Checks to see if the user entered a number
			System.out.println("Enter the number of questions you wish to create:");
			while(!scan.hasNextInt()){
				System.out.println("Not a number...");
				scan.next();
				System.out.println("Enter the number of questions you wish to create:");
			}
			
			numberOfQuestions = scan.nextInt();
			
			
			BufferedWriter out = new BufferedWriter(file);
			String userInput;
			buf = scan.nextLine();
			
			out.write("------------------------------------------------------\n");
			
			for(int i = 0; i < numberOfQuestions; i++){
				System.out.println("Enter question:");
				userInput = scan.nextLine();
				out.write("Question: " + userInput + "\n");
				System.out.println("Enter answer:");
				userInput = scan.nextLine();
				out.write("Answer: " + userInput + "\n");
			}
			
			out.write("------------------------------------------------------\n");
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int userMain = 0;
		// Creates the main menu
		String[] mainMenu = new String[4];
		mainMenu[0] = "1. Create a test";
		mainMenu[1] = "2. View a test";
		mainMenu[2] = "3. Quit";
		mainMenu[3] = "Please enter a command number:";
		
		int loopTrace = 0;
		
		// Enters loop until user quits
		while(loopTrace != 3){
			for(int i = 0; i < mainMenu.length; i++){
				System.out.println(mainMenu[i]);
			}
			
			// Checks to see if the user entered a number
			while(!scan.hasNextInt()){
				System.out.println("Not a number...");
				scan.next();
				System.out.println("Enter a command number:");
			}
			
			userMain = scan.nextInt();
			
			switch(userMain){
			case 1:
				createTest(scan);
				break;
			case 2:
				viewTest(scan);
				break;
			case 3:
				System.out.println("Goodbye");
				loopTrace = 3;
				break;
			default:
				System.out.println("Invalid command number...");
				break;
			}
		}
	}
}
