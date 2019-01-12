package net.ruixin.flow.repository;

import net.ruixin.flow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: mxding
 * @Date: 2019-01-11 16:25
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}