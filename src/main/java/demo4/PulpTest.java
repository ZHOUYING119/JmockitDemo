package demo4;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @Author: zhouying
 * @Date: 2019/6/19 0019
 * @Description:
 */
@RunWith(JMockit.class)
public class PulpTest {

    @Test
    public void test(@Mocked Pulp pulp) {

        Assert.assertEquals(null, Pulp.getStaticKey()); //静态方法mock掉了
        Assert.assertEquals(null, pulp.getKey());       //非静态方法mock掉了
    }

    @Test
    public void test2(@Injectable Pulp pulp) {

        Assert.assertEquals("xxx", Pulp.getStaticKey());    //静态方法没有mock掉
        Assert.assertEquals(null, pulp.getKey());           //非静态方法mock掉了
    }

    @Test
    public void test3(@Mocked Pulp pulp) {

        new Expectations(){
            {
                Pulp.getStaticKey();
                result = "zou";
            }
        };

        Assert.assertEquals("zou", Pulp.getStaticKey());    //静态方法没有mock掉
        Assert.assertEquals(null, pulp.getKey());           //非静态方法mock掉了
    }
}