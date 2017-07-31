package app.web;

import app.AppStarter;
import app.model.persistence.Group;
import app.model.persistence.User;
import app.persistence.GroupRepository;
import app.persistence.UserRepository;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppStarter.class)
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        userRepository.deleteAll();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(1002, Calendar.NOVEMBER, 19);

        userRepository.save(new User("Littlefinger", "secrets","Petyr", "Baelish",
                calendar.getTime(), new HashSet<Group>()));
    }


    @Test
    public void shouldGetUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username", IsEqual.equalTo("Littlefinger")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].password", IsEqual.equalTo("secrets")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", IsEqual.equalTo("Petyr")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName", IsEqual.equalTo("Baelish")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].dateOfBirth", IsEqual.equalTo("1002-11-19")));
    }
}