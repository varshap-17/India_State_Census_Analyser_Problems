package bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class IndiaCensusAnalyserTc3 {
	 public static final String WRONG_CSV_FILE_TYPE_PATH="C:\\Users\\VARSHA P\\Desktop\\eclipse-workspace\\CensusAnalyser\\lib\\src\\main\\census.txt";
	
	 //This is a Sad Test Case to verify if the type is incorrect then exception is raised.
	 
	 @Test
	void whencorrextbuttypeIncorrectReturnsCustomExceptiontest() {
		StateCensusAnalyser censusanalyser=new StateCensusAnalyser();
		ExpectedException exceptionRule=ExpectedException.none();
		exceptionRule.expect(CensusAnalyserException.class);
		try {
			censusanalyser.loadIndiaCensusdata(WRONG_CSV_FILE_TYPE_PATH);
		}catch(CensusAnalyserException e) {
			Assertions.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
		}
	}

}
