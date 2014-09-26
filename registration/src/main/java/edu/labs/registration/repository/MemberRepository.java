package edu.labs.registration.repository;

import edu.labs.registration.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Sergey Royz
 * Date: 26.09.2014
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
