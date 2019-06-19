package demo2;

import demo1.DAOInterface;

/**
 * @Author: zhouying
 * @Date: 2019/6/19 0019
 * @Description:
 */
public class UserService2 {

    public String getName(DAOInterface daoInterface) {
        return daoInterface.getName();
    }

    public int getAge(DAOInterface daoInterface) {
        return daoInterface.getAge();
    }

}