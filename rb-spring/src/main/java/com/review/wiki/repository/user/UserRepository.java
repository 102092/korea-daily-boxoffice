package com.review.wiki.repository.user;

import java.util.List;
import java.util.Optional;

import com.review.wiki.model.commons.Id;
import com.review.wiki.model.user.ConnectedUser;
import com.review.wiki.model.user.Email;
import com.review.wiki.model.user.User;

public interface UserRepository {
	
    User save(User user);

    void update(User user);

    Optional<User> findById(Id<User, Long> userId);

    Optional<User> findByEmail(Email email);

    List<ConnectedUser> findAllConnectedUser(Id<User, Long> userId);

    List<Id<User, Long>> findConnectedIds(Id<User, Long> userId);


}
