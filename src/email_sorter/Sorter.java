package email_sorter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Sorter {

	
	public static void main(String[ ]args){
		
		String fileName = "src/email_sorter/applicants.txt";
		String fileName2 = "src/email_sorter/interviewees.txt";
		BufferedReader buffer;
		BufferedReader buffer2;
		try {
			FileReader reader = new FileReader(fileName);
			buffer = new BufferedReader(reader);
			
			FileReader reader2 = new FileReader(fileName2);
			buffer2 = new BufferedReader(reader2);
			
			List<String> rejectionList = new ArrayList<String>();
			List<String> interviewList = new ArrayList<String>();
			
			String line = null;
			while( (line = buffer.readLine()) != null){
				rejectionList.add(line.toLowerCase());
			}
			System.out.println("The applicantList size was " + rejectionList.size());
			
			while( (line = buffer2.readLine()) != null){
				interviewList.add(line.toLowerCase());
			}
			System.out.println("The interviewList size was " + interviewList.size());
			
			for(int i = 0; i < interviewList.size(); i++){
				if(rejectionList.contains(interviewList.get(i))){
					rejectionList.remove(interviewList.get(i));
				}
			}
			
			System.out.println("The size of the rejection list is " + rejectionList.size());
			
			for(int i = 0; i < rejectionList.size(); i++){
				System.out.println(rejectionList.get(i));
			}
			
			buffer.close();
			buffer2.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("a file was not found");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
