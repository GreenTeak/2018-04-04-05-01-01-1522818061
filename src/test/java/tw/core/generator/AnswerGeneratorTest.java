package tw.core.generator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.exception.OutOfRangeAnswerException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_be_return_1234() throws OutOfRangeAnswerException{
        AnswerGenerator answerGenerator;
        RandomIntGenerator randomIntGenerator=mock(RandomIntGenerator.class);
        String result="1 2 3 4";
        when(randomIntGenerator.generateNums(9,4)).thenReturn(result);
        answerGenerator=new AnswerGenerator(randomIntGenerator);
        assertEquals(answerGenerator.generate().toString(),result);
   }
    @Test
    public void should_be_return_not_number() throws OutOfRangeAnswerException{
        AnswerGenerator answerGenerator;
        RandomIntGenerator randomIntGenerator=mock(RandomIntGenerator.class);
        String result="a 2 3 4";
        when(randomIntGenerator.generateNums(9,4)).thenReturn(result);
        answerGenerator=new AnswerGenerator(randomIntGenerator);
        expectedException.expect(NumberFormatException.class);
        expectedException.expectMessage("For input string: \"" + "a" + "\"");
        answerGenerator.generate();
    }
    @Test
    public void  testrepeated_number()throws OutOfRangeAnswerException{
        AnswerGenerator answerGenerator;
        RandomIntGenerator randomIntGenerator=mock(RandomIntGenerator.class);
        String result="1 2 3 3";
        when(randomIntGenerator.generateNums(9,4)).thenReturn(result);
        answerGenerator=new AnswerGenerator(randomIntGenerator);
        expectedException.expect(OutOfRangeAnswerException.class);
        expectedException.expectMessage("Answer format is incorrect");
        answerGenerator.generate();
    }
    @Test
    public void testnot_between_0_to_9() throws OutOfRangeAnswerException{
        AnswerGenerator answerGenerator;
        RandomIntGenerator randomIntGenerator=mock(RandomIntGenerator.class);
        String result="12 3 4";
        when(randomIntGenerator.generateNums(9,4)).thenReturn(result);
        answerGenerator=new AnswerGenerator(randomIntGenerator);
        expectedException.expect(OutOfRangeAnswerException.class);
        expectedException.expectMessage("Answer format is incorrect");
        answerGenerator.generate();
    }
}

