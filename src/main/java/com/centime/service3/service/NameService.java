package com.centime.service3.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.centime.service3.annotation.LogMethodParam;
import com.centime.service3.dto.RequestJson;

@Service
public class NameService {

	public String postJson(final RequestJson request) {
		final String name = request.getName();
		final String surname = request.getSurname();
		
		if(StringUtils.isEmpty(name) && StringUtils.isEmpty(surname))
			throw new IllegalArgumentException("Both name and Surname cannot be empty.");
		
		final String resString = name.concat(" ").concat(surname);
		return resString;
	}

}
