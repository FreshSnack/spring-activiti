package repository;

import net.ruixin.flow.Application;
import net.ruixin.flow.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: mxding
 * @Date: 2019-01-11 16:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {
        System.out.println(userRepository);
    }
}
