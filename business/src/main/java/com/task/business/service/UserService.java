package com.task.business.service;

import com.task.business.entity.User;
import lombok.NonNull;

public interface UserService {

    User getByLogin(@NonNull String login);

    void saveUser(User user);

    User getUserById(Long userId);
}
