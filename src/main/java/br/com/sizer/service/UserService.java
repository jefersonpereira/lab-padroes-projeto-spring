package br.com.sizer.service;

import br.com.sizer.model.User;

public interface UserService {
    User findOne(String username);

    User createUser(User user);
}
