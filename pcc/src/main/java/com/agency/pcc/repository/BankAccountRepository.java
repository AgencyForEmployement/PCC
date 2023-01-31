package com.agency.pcc.repository;

import com.agency.pcc.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

    BankAccount findByPan(String pan);
}
