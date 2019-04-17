package com.example.TodoApp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.TodoApp.web.TaskController;
import com.example.TodoApp.web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoAppApplicationTests {
	
	@Autowired
	private TaskController trepo;
	@Autowired
	private UserController urepo;
	
	//Test out that controllers aren't null
	@Test
	public void contextLoads() {
		assertThat(trepo).isNotNull();
		assertThat(urepo).isNotNull();
	}

}
