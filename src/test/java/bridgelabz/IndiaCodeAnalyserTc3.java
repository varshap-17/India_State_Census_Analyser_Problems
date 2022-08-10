package bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class IndiaCodeAnalyserTc3 {
	private static final String WRONG_STATE_CSV_FILEPATH="C:\\Users\\VARSHA P\\Desktop\\eclipse-workspace\\CensusAnalyser\\lib\\src\\main\\code.txt";
	@Test
	void whenCorrectbuttypeIncorrectReturnsCustomExceptiontest() {
		StateCodeAnalyser codeanalyser=new StateCodeAnalyser();
		ExpectedException exceptionRule=ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            codeanalyser.loadIndiaStateCode(WRONG_STATE_CSV_FILEPATH);
        }
        catch (CensusAnalyserException e)
        {
            Assertions.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
        }
	}

}
