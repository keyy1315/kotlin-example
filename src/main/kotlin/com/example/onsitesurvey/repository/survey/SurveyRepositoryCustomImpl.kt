package com.example.onsitesurvey.repository.survey

import com.example.onsitesurvey.model.Member
import com.example.onsitesurvey.model.QSurvey
import com.example.onsitesurvey.model.Survey
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class SurveyRepositoryCustomImpl(private val queryFactory: JPAQueryFactory) :
        SurveyRepositoryCustom {
    // T01 권한 매물 목록 조회 쿼리
    override fun findAllByT01(member: Member): List<Survey> {
        val surveys =
                queryFactory
                        .select(QSurvey.survey)
                        .from(QSurvey.survey)
                        .where(
                                QSurvey.survey
                                        .srlNo
                                        .ne("임시저장")
                                        .or(QSurvey.survey.representativeId.eq(member.userId))
                        )
                        .fetch()
        return surveys
    }

    // 1차 판매점 권한 매물 목록 조회 쿼리
    override fun findAllByAdmin(member: Member): List<Survey> {
        return queryFactory
                .select(QSurvey.survey)
                .from(QSurvey.survey)
                .where(
                        QSurvey.survey
                                .submitTargetId
                                .eq(member.storeId)
                                .or(QSurvey.survey.submitTarget.eq(member.storeName))
                                .or(QSurvey.survey.storeId.eq(member.storeId))
                                .or(QSurvey.survey.representativeId.eq(member.userId))
                )
                .fetch()
    }

    // 2차 판매점 슈퍼/일반 유저 권한 매물 목록 조회 쿼리
    override fun findAllByAdminSub(member: Member): List<Survey> {
        return queryFactory
                .select(QSurvey.survey)
                .from(QSurvey.survey)
                .where(
                        QSurvey.survey
                                .submitTargetId
                                .eq(member.storeId)
                                .or(QSurvey.survey.submitTarget.eq(member.storeName))
                                .or(QSurvey.survey.storeId.eq(member.storeId))
                                .or(QSurvey.survey.representativeId.eq(member.userId))
                )
                .fetch()
    }

    override fun findAllByBuilder(member: Member): List<Survey> {
        return queryFactory
                .select(QSurvey.survey)
                .from(QSurvey.survey)
                .where(
                        QSurvey.survey
                                .constructionPointId
                                .eq(member.builderId)
                                .or(QSurvey.survey.representativeId.eq(member.userId))
                )
                .fetch()
    }

    override fun findAllByPartner(member: Member): List<Survey> {
        return queryFactory
                .select(QSurvey.survey)
                .from(QSurvey.survey)
                .where(
                        QSurvey.survey
                                .constructionPointId
                                .eq(member.builderId)
                                .or(QSurvey.survey.representativeId.eq(member.userId))
                )
                .fetch()
    }
}
