package com.iftm.course.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.iftm.course.dto.UserDTO;
import com.iftm.course.entities.User;
import com.iftm.course.repositories.UserRepository;
import com.iftm.course.resources.exceptions.FieldMessage;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(UserUpdateValid ann) {
	}

	@Override
	public boolean isValid(UserDTO dto, ConstraintValidatorContext context) {
		
		// Declaração pra pegar os parâmetros da requisição
		@SuppressWarnings("unchecked")
		Map<String, String> map =
			(Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long uriId = Long.parseLong(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		User user = userRepository.findByEmail(dto.getEmail());
		if (user != null && !user.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "email already taken"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
}