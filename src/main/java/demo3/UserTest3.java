package demo3;

import demo1.DAOInterface;
import mockit.Capturing;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: zhouying
 * @Date: 2019/6/19 0019
 * @Description:
 */
public class UserTest3 {

    @Tested
    UserService3 userService3;

    @Test
    public void test(@Mocked UserDao userDao) {

        Assert.assertEquals(null, userService3.getName());  //被mock掉了
        Assert.assertEquals(0, userService3.getAge());      //被mock掉了
    }

    @Test
    public void test2(@Mocked DAOInterface daoInterface) {

        Assert.assertEquals("zou", userService3.getName());  //没有被mock掉了
        Assert.assertEquals(10, userService3.getAge());      //没有被mock掉了
    }

    @Test
    public void test3(@Capturing DAOInterface daoInterface) {           //子类 实现都会mock掉, 有奇效

        Assert.assertEquals(null, userService3.getName());  //被mock掉了
        Assert.assertEquals(0, userService3.getAge());      //被mock掉了
    }

}