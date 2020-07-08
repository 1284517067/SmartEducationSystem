package rzh.smartsducationsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class SmartsducationsystemApplicationTests {

    @Resource
    DataSource dataSource;
    @Test
    void contextLoads() {
    }
    @Test
    void testDbConnection() throws Exception {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
