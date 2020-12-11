package cn.lwjzt.dailypractice._20201207;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.age .equals(o2.age) ) {
            if (o1.sex .equals(o2.sex)) {
                return 0;
            }
            return o1.sex > o2.sex ? 1 : -1;
        }
        return o1.age > o2.age ? 1 : -1;
    }
}
