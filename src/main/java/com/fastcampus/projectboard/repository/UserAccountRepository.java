package com.fastcampus.projectboard.repository;

import com.fastcampus.projectboard.domain.QUserAccount;
import com.fastcampus.projectboard.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface UserAccountRepository extends
        JpaRepository<UserAccount, String>{
}
