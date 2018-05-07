package com.example.web;

import org.bee.mocktest.repository.ToDoRepository;
import org.bee.mocktest.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Dell on 5/8/2018.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    private StudentService studentService;
    @MockBean
    private ToDoRepository toDoRepository;

    @Test
    public void retrieveDetailsForCourse() throws Exception {
        assertNotNull(studentService);
    }
}
