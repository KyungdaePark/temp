package life.inha.icemarket.domain.auth;

import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
}

//public interface UserRepository extends JpaRepository<User, Integer>{
//
//}