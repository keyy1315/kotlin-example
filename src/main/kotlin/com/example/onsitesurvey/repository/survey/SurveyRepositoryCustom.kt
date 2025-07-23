package com.example.onsitesurvey.repository.survey

import com.example.onsitesurvey.model.Member
import com.example.onsitesurvey.model.Survey

interface SurveyRepositoryCustom {
    fun findAllByT01(member: Member): List<Survey>
    fun findAllByAdmin(member: Member): List<Survey>
    fun findAllByAdminSub(member: Member): List<Survey>
    fun findAllByBuilder(member: Member): List<Survey>
    fun findAllByPartner(member: Member): List<Survey>
}
