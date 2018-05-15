package tw.core;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Before;
import org.junit.Test;
import tw.validator.InputValidator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    InputValidator inputValidator;
    @Before
    public void setup() throws Exception{
      inputValidator=new InputValidator();
    }
    @Test
    public void should_be_return_false_when_size_not_4(){
        String Inputfalse="1 2 3";
        String InputTrue="1 2 3 4";
        assertFalse(inputValidator.validate(Inputfalse));
        assertTrue(inputValidator.validate(InputTrue));
    }
    @Test
    public void should_be_return_differ_4(){
        String Inputfalse="1 1 2 3";
        String InputTrue="1 2 3 4";
        assertFalse(inputValidator.validate(Inputfalse));
        assertTrue(inputValidator.validate(InputTrue));
    }
}
