package tw.controllers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import tw.core.Answer;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    GameController gameController;
    ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
    @Before
    public void Setup()throws Exception{
        Answer input=Answer.createAnswer("1 2 3 4");
        RandomIntGenerator randomIntGenerator=new RandomIntGenerator();
        AnswerGenerator answerGenerator=mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(input);
        Game game=new Game(answerGenerator);
        GameView gameView=new GameView();
        gameController=new GameController(game,gameView);
    }
  /*@Test
  public void testshoebegin_should_be_return_printInfo() throws IOException{
      System.setOut(new PrintStream(outputStream));
      gameController.beginGame();
      String result="------Guess Number Game, You have 6 chances to guess!  ------\n";
     // System.out.print(","+result+",");
      assertEquals(outputStream.toString(),result);
  }*/

}