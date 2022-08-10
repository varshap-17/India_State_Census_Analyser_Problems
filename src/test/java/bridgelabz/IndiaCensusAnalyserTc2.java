package bridgelabz;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class IndiaCensusAnalyserTc2 {
	private static final String WRONG_CSV_FILE_PATH="C:\\Users\\VARSHA P\\Desktop\\eclipse-workspace\\CensusAnalyser\\lib\\src\\main\\java\\census.csv";
	
	//This is a Sad Test Case to verify if the exception is raised.
	
	@Test
	void ifincorrectReturnCustomExceptiontest() {
		StateCensusAnalyser censusanalyser=new StateCensusAnalyser();
	
		ExpectedException exceptionRule=ExpectedException.none();
		exceptionRule.expect(CensusAnalyserException.class);
		try {
			censusanalyser.loadIndiaCensusdata(WRONG_CSV_FILE_PATH);
		}catch(CensusAnalyserException e) {
			Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
		}
	}

}
