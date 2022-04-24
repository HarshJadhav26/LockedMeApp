package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;



public class LockedMeMainApp {
	
	static final String errorMessage = "Some error occurred. Please contact the admininstration.";
	static final String projectFilePath = "C:\\Users\\gk\\Desktop\\LockedMeApp\\1-File Path\\";
	public static void main(String[] args) 
	{
		int in = 1;
		Scanner sc = new Scanner(System.in);		
			do 
			{
				try 
				{
					displayMenu();
					System.out.println("Slect One Option");
					in=Integer.parseInt(sc.nextLine());
					switch(in) 
					{
						case 1 : getAllFiles();
						break;
						case 2 : createFiles();
						break;
						case 3 : deleteFiles();
						break;
						case 4 : searchFiles();
						break;
						case 5 : System.exit(0); 
						break;
						default: System.out.println("Invalid  Option, Try Again"); 
						break;	
					}
				}
				catch (NumberFormatException Ex) 
				{
					System.out.println("Please enter Numbers only");
				}
					}
						while(in > 0);
			sc.close();
		}
	public static void displayMenu() 
	{
		System.out.println("************************************************************************");
		System.out.println("\t\tWelcome To LockedMe.Com Application");
		System.out.println("************************************************************************");
		System.out.println("");
		System.out.println("\t\t1. Display all existing files");
		System.out.println("\t\t2. Create a new file");
		System.out.println("\t\t3. Delete an existing file");
		System.out.println("\t\t4. Search an existing file");
		System.out.println("\t\t5. Exit");
		System.out.println("************************************************************************");
		System.out.println("\t\tDeveloped by :- Harsh Jadhav");
		System.out.println("************************************************************************");
	}
	
	public static void getAllFiles() 
	{
		try 
		{
			File folder = new File(projectFilePath);
			File[] listOfFiles = folder.listFiles();
			
			if(listOfFiles.length > 0)
				
				for(var l:listOfFiles) 
				{
					System.out.println(l.getName());
				}
			else 
			{
				System.out.println("No Files Exist In The Directory");
			}
		}
		catch(Exception Ex) 
		{
			System.out.println("ErrorMessage in getAllFiles"+Ex.getMessage());
		}
	}
	
	public static void createFiles() 
	{
		Scanner sc = new Scanner(System.in);
		try {

			String fileName;
			System.out.println("Enter file name");
			fileName = sc.nextLine();

			FileWriter myWriter = new FileWriter(projectFilePath + fileName + ".txt");
			
			
			System.out.println("Write Content to store in file");
			String line = sc.nextLine();
			myWriter.write(line + "\n");

			myWriter.close();
			System.out.println(fileName + ".txt" + " " +"Created Successfully");

		} catch (Exception Ex) {
			System.out.println("errorMessage in createFiles ==> " + Ex.getStackTrace());
		}
	}
	
	public static void deleteFiles()
	{

		Scanner sc = new Scanner(System.in);
		try {
			String fileName;

			System.out.println("Enter the final name to be deleted: ");
			fileName = sc.nextLine();
			File file = new File(projectFilePath + fileName + ".txt");

			if (file.exists()) {
				file.delete();
				System.out.println("File deleted successfully: " + fileName+ ".txt");
			} else
				System.out.println("File do not exist");

		} catch (Exception Ex) {
			System.out.println(errorMessage);
		}
	}
	
public static void searchFiles()
{
	Scanner sc= new Scanner(System.in);

	try
	{
		String fileName;

		System.out.println("Enter the final name to be searched: ");

		fileName=sc.nextLine();

		File folder = new File(projectFilePath);
		File[] listofFiles = folder.listFiles();

		LinkedList<String> filenames = new LinkedList<String>();

		for(var l:listofFiles)
			filenames.add(l.getName());

			if(filenames.contains (fileName+ ".txt"))
				System.out.println("File is available");

			else
				System.out.println("File is not available");
	} 
	catch(Exception Ex)
	{
		System.out.println(errorMessage); 
	} 
}

}



