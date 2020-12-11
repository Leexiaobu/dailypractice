package cn.lwjzt.dailypractice._20201207;

public class User {
    Integer age;
    Integer sex;

    public User(Integer age, Integer sex) {
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {
        User user = new User(2, null);
        User user2 = new User(2, 12);
        int compare = new UserComparator().compare(user, user2);
        System.out.println(compare);
    }
}
