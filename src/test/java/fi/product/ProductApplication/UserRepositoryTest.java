package fi.product.ProductApplication;

import fi.product.ProductApplication.domain.User;
import fi.product.ProductApplication.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Before
    public void setUp() throws Exception {
        User user1= new User("Minna", 55);
        User user2= new User("Harri", 35);
        
        assertNull(user1.getId());
        assertNull(user2.getId());
        this.userRepository.save(user1);
        this.userRepository.save(user2);
        assertNotNull(user1.getId());
        assertNotNull(user2.getId());
    }
 
    @Test
    public void testFetchData(){
        
        User userA = userRepository.findByName("Harri");
        assertNotNull(userA);
        assertEquals(38, userA.getAge());
        
        Iterable<User> users = userRepository.findAll();
        int count = 0;
        for(User p : users){
            count++;
        }
        assertEquals(count, 2);
    }
}