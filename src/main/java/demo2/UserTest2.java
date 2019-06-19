package demo2;

import demo1.DAOInterface;
import mockit.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: zhouying
 * @Date: 2019/6/19 0019
 * @Description:
 */
public class UserTest2 {

    @Tested
    UserService2 userService2;

    @Test
    public void test(@Mocked DAOInterface daoInterface) {

        new NonStrictExpectations() {
            {
                daoInterface.getName();
                result = "zou";
            }
        };

        Assert.assertEquals("zou", userService2.getName(daoInterface));
        Assert.assertEquals(0, userService2.getAge(daoInterface));      //默认0
    }

    @Test
    public void test2() {

        DAOInterface daoInterface = new MockUp<DAOInterface>() {
            @Mock
            String getName() {
                return "zou";
            }
        }.getMockInstance();

        Assert.assertEquals("zou", userService2.getName(daoInterface));
        Assert.assertEquals(0, userService2.getAge(daoInterface));      //默认0
    }

}