package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */
public class GameTest {
    Game game;
    @Before
    public void Setup()throws Exception{
        Answer input=Answer.createAnswer("1 2 3 4");
        RandomIntGenerator randomIntGenerator=new RandomIntGenerator();
        AnswerGenerator answerGenerator=mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(input);
        game=new Game(answerGenerator);
    }
    @Test
    public void test_should_be_return_4A0B_when_1234(){
        String input= "1 2 3 4";
        Answer answer = Answer.createAnswer(input);
        assertEquals(game.guess(answer).getResult(),"4A0B");
   }
   @Test
    public void test_should_be_return_1A2B_when_1325(){
       String input= "1 3 2 5";
       Answer answer = Answer.createAnswer(input);
       assertEquals(game.guess(answer).getResult(),"1A2B");
   }
   @Test
    public void test_should_be_return_0A0B_when_5678(){
       String input= "5 6 7 8";
       Answer answer = Answer.createAnswer(input);
       assertEquals(game.guess(answer).getResult(),"0A0B");
   }
   @Test
    public void testcheckStatus_should_be_return_fail_when_size_greater_6(){
       String[] result={"1 3 2 4","1 2 4 6","1 3 2 5","5 6 7 8","1 4 3 2","1 4 5 6"};
       int i=0;
       while (i<result.length) game.guess(Answer.createAnswer(result[i++]));
       assertEquals(game.checkStatus(),"fail");
   }
   @Test
   public void testcheckStatus_should_be_return_SUCCESS_when_1234(){
       String input= "1 2 3 4";
       Answer answer = Answer.createAnswer(input);
       game.guess(answer);
       assertEquals(game.checkStatus(),"success");
   }
   @Test
    public void testcheckStatus_should_be_return_CONTINUE_when_size_2(){
       String[] result={"1 3 2 4","1 2 4 6"};
       int i=0;
       while (i<result.length) game.guess(Answer.createAnswer(result[i++]));
       assertEquals(game.checkStatus(),"continue");
   }
   @Test
    public void testcheckCoutinue_should_be_return_false_when_size_6(){
       String[] result={"1 3 2 4","1 2 4 6","1 3 2 5","5 6 7 8","1 4 3 2","1 4 5 6"};
       int i=0;
       while (i<result.length) game.guess(Answer.createAnswer(result[i++]));
       assertFalse(game.checkCoutinue());
   }
}
