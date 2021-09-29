package com.lti.bankingProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.bankingProject.beans.NetBankingAccount;

public interface CreateNetBankingAccountJpaDao extends JpaRepository<NetBankingAccount, Long>{

}
