package web.service;

import web.model.User;

import javax.validation.Valid;
import java.util.List;

public interface UserService {
    List<User> index();
    User show(Long id);

    void save(User user);

    void update(Long id,User user);

    void delete(Long id);
}
