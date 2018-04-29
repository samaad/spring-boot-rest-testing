package com.example.util;

import com.example.model.ToDo;

public class PayloadValidator {

	public static boolean validateCreatePayload(ToDo todo){
		if(todo.getId() > 0){
			return false;
		}
		return true;
	}
}
