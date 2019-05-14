package dev.top.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.top.entities.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

	@Query("select count(v) from Vote v where v.emailDuCollegue = :email ")
	Integer findVoteByEmail(@Param("email") String email);
	
}
