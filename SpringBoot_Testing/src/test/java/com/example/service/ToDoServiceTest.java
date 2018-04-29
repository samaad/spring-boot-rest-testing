package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.ToDo;
import com.example.repository.ToDoRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ToDoServiceTest {

	@Mock
	private ToDoRepository toDoRepository;
	
	@InjectMocks
	private ToDoServiceImpl toDoService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllToDO(){
		List<ToDo> toDos = new ArrayList<>();
		toDos.add(new ToDo(1, "ToDo Sample 1", true));
		toDos.add(new ToDo(2, "ToDo Sample 2", true));
		toDos.add(new ToDo(3, "ToDo Sample 3", true));
		when(toDoRepository.findAll()).thenReturn(toDos);
		
		List<ToDo> result = toDoService.getAllToDo();
		assertEquals(3, result.size());
	}
	
	@Test
	public void testGetToDoById(){
		ToDo toDo = new ToDo(1, "Todo Sample 1", true);
		when(toDoRepository.findOne(1l)).thenReturn(toDo);
		ToDo result = toDoService.getToDoById(1);
		assertEquals(1, result.getId());
		assertEquals("Todo Sample 1", result.getText());
		assertEquals(true, result.isCompleted());
	}
	
	@Test
	public void saveToDo(){
		ToDo toDo = new ToDo(8, "ToDo Sample 8", true);
		when(toDoRepository.findOne(8l)).thenReturn(toDo);
		ToDo result = toDoService.saveToDo(toDo);
		assertEquals(8, result.getId());
		assertEquals("Todo Sample 8", result.getText());
		assertEquals(true, result.isCompleted());
	}
	
	@Test
	public void removeToDo(){
		ToDo toDo = new ToDo(8,"Todo Sample 8",true);
		toDoService.removeToDo(toDo);
        verify(toDoRepository, times(1)).delete(toDo);
	}
}