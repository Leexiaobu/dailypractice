package cn.lwjzt.dailypractice._20201207;

public class User {
    /**
     * 0未知 1女 2男
     */
    Integer age;

    Integer sex;

    public User(Integer age, Integer sex) {
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {
        User user = new User(2, 2);
        User user2 = new User(2, 1);
        int compare = new UserComparator().compare(user, user2);
        System.out.println(compare);
    }
}
