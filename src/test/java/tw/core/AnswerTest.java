package tw.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_be_return_Answer(){
        String result="1 2 3 4";
        Answer answer=Answer.createAnswer(result);
        assertEquals(answer.toString(),result);
    }
    @Test
    public void should_be_throw_Exception_when_not_number() throws OutOfRangeAnswerException{
        String input="a 2 3 4";
        Answer answer=Answer.createAnswer(input);
        expectedException.expect(NumberFormatException.class);
        expectedException.expectMessage("For input string: \"" + "a" + "\"");
        answer.validate();
    }
    @Test
    public void testrepeated_number() throws OutOfRangeAnswerException {
        String input= "1 2 3 3";
        Answer answer = Answer.createAnswer(input);
        expectedException.expect(OutOfRangeAnswerException.class);
        expectedException.expectMessage("Answer format is incorrect");
        answer.validate();
    }
    @Test
    public void test_should_return_an_OutOfRangeAnswerException_when_give_digit_without_trim() throws OutOfRangeAnswerException {
        String input = "12 3 4";
        Answer answer = Answer.createAnswer(input);
        expectedException.expect(OutOfRangeAnswerException.class);
        expectedException.expectMessage("Answer format is incorrect");
        answer.validate();
    }
    @Test
    public void test_getIndexOfNum_should_be_return_index(){
        String input = "1 2 3 4";
        Answer answer = Answer.createAnswer(input);
        assertTrue(answer.getIndexOfNum("4")==3);
    }
    @Test
    public void test_check_answer_is_1543_return_12(){
        String input = "1 2 3 4";
        Answer answer=Answer.createAnswer(input);
        String testinput="1 5 4 3";
        Answer testanswer=Answer.createAnswer(testinput);

        Record record=new Record();


        System.out.print(answer.check(testanswer).getValue());
        //assertEquals(answer.check(testanswer).getValue().toString(),result);

    }
}