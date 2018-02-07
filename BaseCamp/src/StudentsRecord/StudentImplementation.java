package StudentsRecord;

import java.util.ArrayList;

public class StudentImplementation {

	public static void main(String[] args) {

		ArrayList<Student> arrayList = new ArrayList<Student>();
		StudentInsertData sd=new StudentInsertData();
		StudentFetchDetails sf=new StudentFetchDetails();
		sd.setDtails(arrayList);
		sf.searchDetails(arrayList);

	}

}
