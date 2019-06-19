package demo3;

import demo1.DAOInterface;

/**
 * @Author: zhouying
 * @Date: 2019/6/19 0019
 * @Description:
 */
public class UserService3 {
    DAOInterface daoInterface = new UserDao();

    public String getName() {
        return daoInterface.getName();
    }

    public int getAge() {
        return daoInterface.getAge();
    }
}