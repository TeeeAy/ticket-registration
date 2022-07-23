package com.task.business.transformer;

import com.task.business.dto.UserDto;
import com.task.business.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer {

    public User transform(UserDto userDto) {
        return User.builder()
                .withLogin(userDto.getLogin())
                .withPassword(userDto.getPassword())
                .withFirstName(userDto.getFirstName())
                .withLastName(userDto.getLastName())
                .withEmail(userDto.getEmail())
                .withRoles(userDto.getRoles())
                .build();
    }
}
