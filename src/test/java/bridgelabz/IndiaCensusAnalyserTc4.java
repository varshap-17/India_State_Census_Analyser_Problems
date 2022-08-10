package bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class IndiaCensusAnalyserTc4 {
	public static final String INVALID_DELIMITER_FILE_PATH="C:\\Users\\VARSHA P\\Desktop\\eclipse-workspace\\CensusAnalyser\\lib\\src\\main\\Delimeter.csv";
	
	//This is a Sad Test Case to verify if the file delimiter is incorrect then exception is raised.
	
	@Test
	void coorectbutDelimiterIncorrectReturnsCustomExceptiontest() {
		StateCensusAnalyser censusanalyser=new StateCensusAnalyser();
		ExpectedException exceptionRule=ExpectedException.none();
		exceptionRule.expect(CensusAnalyserException.class);
		try {
			censusanalyser.loadIndiaCensusdata(INVALID_DELIMITER_FILE_PATH);
		}catch(CensusAnalyserException e) {
		
		Assertions.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
	}
}
}
