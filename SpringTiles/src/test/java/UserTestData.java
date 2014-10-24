/**
 * User: tvt
 * Date: 10/21/14
 * Time: 10:14 AM
 */
public class UserTestData {

    public static void main(String[] args) {

        for (int i = 0; i <= 1000; i++) {
            String insertQuery = "insert into user(dbupdatedate,password, role, username) value(now(), 'user','USER'," + "'user" + i + "');";
            System.out.println(insertQuery);
        }
    }
}
