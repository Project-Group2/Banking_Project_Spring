package com.lti.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.demo.beans.NetBankingAccount;

public interface CreateNetBankingAccountJpaDao extends JpaRepository<NetBankingAccount, Long>{

}
