package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> index();

    User show(Long id);

    void save(User user);

    void update(Long id, User user);

    void delete(Long id);
}
