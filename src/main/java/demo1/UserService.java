package demo1;

/**
 * @Author: zhouying
 * @Date: 2019/6/19 0019
 * @Description:
 */
public class UserService {

    DAOInterface daoInterface;

    public String getName() {
        return daoInterface.getName();
    }

    public int getAge() {
        return daoInterface.getAge();
    }

    public String getKill() {
        return "kill";
    }
}