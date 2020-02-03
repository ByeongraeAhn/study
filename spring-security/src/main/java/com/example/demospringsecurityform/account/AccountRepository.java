package com.example.demospringsecurityform.account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AccountRepository
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {

	Account findByUsername(String username);
    
}