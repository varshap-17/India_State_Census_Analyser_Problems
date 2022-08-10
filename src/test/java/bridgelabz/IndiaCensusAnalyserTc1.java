package bridgelabz;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class IndiaCensusAnalyserTc1 {
		public static final String CENSUS_CSV_FILE_PATH="C:\\Users\\VARSHA P\\Desktop\\eclipse-workspace\\CensusAnalyser\\lib\\src\\main\\java\\census.csv";
		
		//This is a Happy Test Case where the records are checked
	
		@Test
	public void ChecktoensuretheNumberofRecordmatchestest() {
		try {
			StateCensusAnalyser censusanalyser=new StateCensusAnalyser();
			int numOfRecords=censusanalyser.loadIndiaCensusdata("CENSUS_CSV_FILE_PATH");
			Assertions.assertEquals(36, numOfRecords);
		}catch(CensusAnalyserException e) {
			e.getStackTrace();
		}
	}

}
