package dev.top.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.top.entities.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

	@Query("select count(v) from Vote v where v.emailDuCollegue = :email and v.sensDuVote = true ")
	Integer findVotePositifByEmail(@Param("email") String email);
	
	@Query("select count(v) from Vote v where v.emailDuCollegue = :email and v.sensDuVote = false ")
	Integer findVoteNegatifByEmail(@Param("email") String email);
	
	@Query("select count(v) from Vote v where v.emailDuVotant = :emailVotant and v.emailDuCollegue = :emailCollegue")
	Integer findVoteByEmail(@Param("emailVotant") String emailVotant, @Param("emailCollegue") String emailCollegue);
	
}
