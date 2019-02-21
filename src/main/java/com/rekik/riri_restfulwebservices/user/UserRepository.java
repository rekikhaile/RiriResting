package com.rekik.riri_restfulwebservices.user;

import com.rekik.riri_restfulwebservices.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
}
