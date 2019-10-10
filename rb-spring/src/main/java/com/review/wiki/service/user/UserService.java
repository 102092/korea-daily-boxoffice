package com.review.wiki.service.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.review.wiki.error.NotFoundException;
import com.review.wiki.model.commons.Id;
import com.review.wiki.model.user.ConnectedUser;
import com.review.wiki.model.user.Email;
import com.review.wiki.model.user.User;
import com.review.wiki.repository.user.UserRepository;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional
    public User join(String name, Email email, String password) {
        checkArgument(isNotEmpty(password), "password must be provided.");
        checkArgument(
                password.length() >= 4 && password.length() <= 15,
                "password length must be between 4 and 15 characters."
        );

        User user = new User(name, email, passwordEncoder.encode(password));
        return save(user);
    }

    @Transactional
    public User login(Email email, String password) {
        checkNotNull(password, "password must be provided.");

        User user = findByEmail(email)
                .orElseThrow(() -> new NotFoundException(User.class, email));
        user.login(passwordEncoder, password);
        user.afterLoginSuccess();
        update(user);
        return user;
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Id<User, Long> userId) {
        checkNotNull(userId, "userId must be provided.");

        return userRepository.findById(userId);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByEmail(Email email) {
        checkNotNull(email, "email must be provided.");

        return userRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public List<ConnectedUser> findAllConnectedUser(Id<User, Long> userId) {
        checkNotNull(userId, "userId must be provided.");

        return userRepository.findAllConnectedUser(userId);
    }

    @Transactional(readOnly = true)
    public List<Id<User, Long>> findConnectedIds(Id<User, Long> userId) {
        checkNotNull(userId, "userId must be provided.");

        return userRepository.findConnectedIds(userId);
    }

    private User save(User user) {
        return userRepository.save(user);
    }

    private void update(User user) {
        userRepository.update(user);
    }

}