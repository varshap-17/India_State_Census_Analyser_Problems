package bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class IndiaCodeAnalyserTc4 {
	private static final String INVALID_STATE_CODE_CSV_DELIMITER_FILE_PATH="C:\\Users\\VARSHA P\\Desktop\\eclipse-workspace\\CensusAnalyser\\lib\\src\\main\\Delimeter.csv"; 
	@Test
	void CorrectbutDelimiterIncorrectReturnsCustomExceptiontest() {
		StateCodeAnalyser codeanalyser=new StateCodeAnalyser();
		ExpectedException exceptionRule=ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            codeanalyser.loadIndiaStateCode(INVALID_STATE_CODE_CSV_DELIMITER_FILE_PATH);
        }catch(CensusAnalyserException e) {
        	Assertions.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
        }
	}

}
