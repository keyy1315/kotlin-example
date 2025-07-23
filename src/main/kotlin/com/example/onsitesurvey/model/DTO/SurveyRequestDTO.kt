package com.example.onsitesurvey.model.DTO

data class SurveyRequestDTO(
    val roofData: String,
    val memberId: String,
    val submitTarget: String? = null,
    val submitTargetId: String? = null,
    val srlNo: String
)