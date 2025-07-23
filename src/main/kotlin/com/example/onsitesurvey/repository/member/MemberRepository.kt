package com.example.onsitesurvey.repository.member

import com.example.onsitesurvey.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository interface MemberRepository : JpaRepository<Member, Long> {
    fun findByUserId(userId: String): Member?
}
