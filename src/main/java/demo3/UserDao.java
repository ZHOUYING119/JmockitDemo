package demo3;

import demo1.DAOInterface;

/**
 * @Author: zhouying
 * @Date: 2019/6/19 0019
 * @Description:
 */
public class UserDao implements DAOInterface {
    public String getName() {
        return "zou";
    }

    public int getAge() {
        return 10;
    }
}