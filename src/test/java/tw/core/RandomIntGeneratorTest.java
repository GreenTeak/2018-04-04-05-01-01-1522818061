package tw.core;


import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    RandomIntGenerator randomIntGenerator;
    @Before
    public void Setup() throws Exception{
        randomIntGenerator=new RandomIntGenerator();
    }
   @Test
    public void should_be_return_size_4(){
        String[] result=randomIntGenerator.generateNums(9,4).split(" ");
        assertEquals(result.length,4);
   }
   @Test
    public void should_be_return_between_0_to_9(){
        List<String> resultlist= Arrays.asList(randomIntGenerator.generateNums(9,4).split(" "));
        List<String> result=resultlist.stream().filter((x)->x.matches("[0-8]{1}")).collect(Collectors.toList());
        assertEquals(resultlist.size(),4);
   }
   @Test
    public void should_be_return_random(){
       List<String> resultlist= Arrays.asList(randomIntGenerator.generateNums(9,4).split(" "));
       List<String> result=resultlist.stream().distinct().collect(Collectors.toList());
       assertEquals(resultlist.size(),4);
   }
}