package bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class IndiaCodeAnalyserTc5 {
	private static final String INVALID_HEADER_CODE_FILEPATH="C:\\Users\\VARSHA P\\Desktop\\eclipse-workspace\\CensusAnalyser\\lib\\src\\main\\Invalid_Header.csv";
	
	@Test
	void CorrectbutCsvHeaderIncorrectReturnsCustomExceptiontest() {
		StateCodeAnalyser codeanalyser=new StateCodeAnalyser();
		ExpectedException exceptionRule=ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            codeanalyser.loadIndiaStateCode(INVALID_HEADER_CODE_FILEPATH);
        }catch(CensusAnalyserException e) {
        	Assertions.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
        }
	}
}
