package cn.lwjzt.dailypractice._20201209;

public class Singleton {

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {

        private static final Singleton INSTANCE = new Singleton();
    }

    public static void main(String[] args) {
        System.out.println(1);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println(Singleton.getInstance());
            System.out.println(1);
    }
}
