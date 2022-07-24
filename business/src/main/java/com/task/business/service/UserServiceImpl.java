package com.task.business.service;

import com.task.business.dao.UserRepository;
import com.task.business.entity.User;
import com.task.business.service.exception.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Cacheable(value = "users", key = "#user.login")
    public User getByLogin(@NonNull String login) {
        return userRepository.findByLogin(login).orElseThrow(
                () -> new NotFoundException("User not found")
        );
    }
    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Cacheable(value = "users", key = "#user.id")
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User not found")
        );
    }
}
