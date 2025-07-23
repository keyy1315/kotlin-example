package com.example.onsitesurvey.service

import com.example.onsitesurvey.model.DTO.SurveyRequestDTO
import com.example.onsitesurvey.model.Survey
import com.example.onsitesurvey.model.SurveyRoof
import com.example.onsitesurvey.model.enums.Role
import com.example.onsitesurvey.repository.SurveyRepository
import com.example.onsitesurvey.repository.member.MemberRepository
import java.time.LocalDateTime
import org.springframework.stereotype.Service

@Service
class SurveyService(
        private val surveyRepository: SurveyRepository,
        private val memberRepository: MemberRepository
) {
    fun getSurvey(role: Role, memberId: String): List<Survey> {
        val member = memberRepository.findByUserId(memberId)
        if (member == null) {
            throw RuntimeException("Member not found")
        }
        when (role) {
            Role.T01 -> {
                return surveyRepository.findAllByT01(member)
            }
            Role.ADMIN -> {
                return surveyRepository.findAllByAdmin(member)
            }
            Role.ADMIN_SUB -> {
                return surveyRepository.findAllByAdminSub(member)
            }
            Role.BUILDER -> {
                return surveyRepository.findAllByBuilder(member)
            }
            Role.PARTNERS -> {
                return surveyRepository.findAllByPartner(member)
            }
            else -> {
                return emptyList()
            }
        }
    }

    fun createSurvey(surveyRequestDTO: SurveyRequestDTO) {
        val member = memberRepository.findByUserId(surveyRequestDTO.memberId)
        if (member == null) {
            throw RuntimeException("Member not found")
        }
        val survey =
                Survey(
                        id = 0,
                        srlNo = surveyRequestDTO.srlNo,
                        representative = member.userName,
                        representativeId = member.userId,
                        submitStatus = surveyRequestDTO.submitTarget != null,
                        submitDate = surveyRequestDTO.submitTargetId?.let { LocalDateTime.now() },
                        submitTarget =
                                surveyRequestDTO.submitTargetId?.let {
                                    surveyRequestDTO.submitTarget
                                },
                        submitTargetId = surveyRequestDTO.submitTargetId,
                        store = member.storeName,
                        storeId = member.storeId,
                        constructionPoint = member.builderName,
                        constructionPointId = member.builderId,
                        createdAt = LocalDateTime.now(),
                        updatedAt = LocalDateTime.now(),
                )
        val surveyRoof =
                SurveyRoof(
                        id = 0,
                        roofData = surveyRequestDTO.roofData,
                        survey = survey,
                )
        survey.surveyRoof = surveyRoof
        surveyRepository.save(survey)
    }
}
