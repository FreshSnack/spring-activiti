package repository;

import net.ruixin.flow.Application;
import net.ruixin.flow.entity.User;
import net.ruixin.flow.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

    @Test
    public void testAddUser() {
        User user = new User();
        user.setName("Lily");
        user.setPhone("57892");
        userRepository.save(user);
    }

    @Test
    public void testListUser() {
        List<User> userList = userRepository.findAll();
        userList.forEach(user -> {
            System.out.println(user.getId() + "|" + user.getName() + "|" + user.getPhone());
        });
    }
}
