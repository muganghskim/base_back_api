package com.hskim.assetguardian.user.repository;



import com.hskim.assetguardian.user.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserEmail(String userEmail);

}
