package com.example.onsitesurvey.repository

import com.example.onsitesurvey.model.Survey
import com.example.onsitesurvey.repository.survey.SurveyRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository interface SurveyRepository : JpaRepository<Survey, Long>, SurveyRepositoryCustom {}
