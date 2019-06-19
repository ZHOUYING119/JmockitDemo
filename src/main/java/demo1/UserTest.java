package demo1;

import mockit.Capturing;
import mockit.Injectable;
import mockit.NonStrictExpectations;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @Author: zhouying
 * @Date: 2019/6/19 0019
 * @Description:    @Tested @Injectable 配合, 注入      http://jmockit.cn/index.htm
 */
@RunWith(JMockit.class)
public class UserTest {

    @Tested
    UserService userService;

    @Test
    public void test(@Injectable DAOInterface daoInterface) {

        //2
        {
            Assert.assertEquals(null, userService.getName());       //默认返回null
            Assert.assertEquals(0, userService.getAge());           //默认返回0
            Assert.assertEquals("kill", userService.getKill());
        }

        //2
        {
            new NonStrictExpectations() {
                {
                    daoInterface.getName();
                    result = "zou";
                    daoInterface.getAge();
                    result = 10;
                }
            };

            Assert.assertEquals("zou", userService.getName());
            Assert.assertEquals(10, userService.getAge());
            Assert.assertEquals("kill", userService.getKill());
        }
    }

    @Test
    public void test2(@Capturing DAOInterface daoInterface) {

        new NonStrictExpectations() {
            {
                daoInterface.getName();
                result = "zou";
            }
        };
        Assert.assertEquals("zou", userService.getName());   //报错, NullPointerException!!  还没有注入!!!!!
    }
}