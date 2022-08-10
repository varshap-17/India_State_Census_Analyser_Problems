package bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
class IndiaCodeAnalyserTc2 {
	private static final String WRONG_STATE_CODE_CSV_FILE_PATH="C:\\Users\\VARSHA P\\Desktop\\eclipse-workspace\\CensusAnalyser\\lib\\src\\main\\java\\StateCode.csv";
	
	@Test
	void ifIncorrectReturnCustomExceptiontest() {
		StateCodeAnalyser codeanalyser=new StateCodeAnalyser();
		ExpectedException exceptionRule=ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            codeanalyser.loadIndiaStateCode(WRONG_STATE_CODE_CSV_FILE_PATH);
        }
        catch (CensusAnalyserException e)
        {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
	}

}
