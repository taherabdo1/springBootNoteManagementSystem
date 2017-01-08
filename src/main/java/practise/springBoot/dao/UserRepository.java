package practise.springBoot.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import practise.springBoot.entities.User;

@Transactional
public interface UserRepository  extends CrudRepository<User, Integer> {
}