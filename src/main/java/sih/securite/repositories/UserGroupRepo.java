package sih.securite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.securite.entities.UserGroup;

@Repository
public interface UserGroupRepo extends JpaRepository<UserGroup, Long> {

}
