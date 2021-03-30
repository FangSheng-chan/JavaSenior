package test3;

import java.sql.PreparedStatement;

/**
 * @author fangsheng
 * @date 2021/3/3 下午4:15
 */
public class T5 {
    public static void main(String[] args) throws Exception {
        try (UserContext ss = new UserContext("ss")) {
            String currentUser = UserContext.currentUser();
            System.out.println(currentUser);

        }
    }
}

class UserContext implements AutoCloseable {

    static final ThreadLocal<String> ctx = new ThreadLocal<>();

    public UserContext(String user) {
        ctx.set(user);
    }

    public static String currentUser() {
        return ctx.get();
    }

    @Override
    public void close() throws Exception {
        ctx.remove();
    }
}