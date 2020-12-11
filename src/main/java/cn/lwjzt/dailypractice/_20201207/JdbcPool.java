package cn.lwjzt.dailypractice._20201207;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
public class JdbcPool {
    Map<Thread, Connection> map = new HashMap<>();
    static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai";
    static final String USER = "root";
    static final String PASSWORD = "root";
    Integer poolSize;
    ThreadPoolExecutor poolExecutor;
    public JdbcPool(Integer poolSize) {
        this.poolExecutor = new ThreadPoolExecutor(poolSize, poolSize, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        this.poolSize = poolSize;
    }
    public void close() {
        this.poolExecutor.shutdown();
    }


    Connection getConnection(Thread thread) throws SQLException, ClassNotFoundException {
        /*防止Connection被关闭*/
        if (map.containsKey(thread) && map.get(thread) != null) {
            return map.get(thread);
        } else {
            Class.forName(DRIVER_NAME);
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            map.put(thread, con);
            return con;
        }
    }

    public Connection getConnection() throws ExecutionException, InterruptedException {
        Future<Connection> submit = poolExecutor.submit(() -> getConnection(Thread.currentThread()));
        return submit.get();
    }

    public static void main(String[] args) {
        JdbcPool jdbcPool = new JdbcPool(5);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Connection connection = jdbcPool.getConnection();
                    System.out.println(Thread.currentThread().getName() + ":" + connection);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
