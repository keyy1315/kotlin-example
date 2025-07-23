package com.example.onsitesurvey.controller

import com.example.onsitesurvey.model.DTO.SurveyRequestDTO
import com.example.onsitesurvey.model.Survey
import com.example.onsitesurvey.model.enums.Role
import com.example.onsitesurvey.service.SurveyService
import io.swagger.v3.oas.annotations.Operation
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("api/survey")
class SurveyController(private val surveyService: SurveyService) {
    private val log = LoggerFactory.getLogger(SurveyController::class.java)

    @GetMapping
    @Operation(summary = "Get all surveys")
    fun getSurvey(
            @RequestParam(required = true) role: Role,
            @RequestParam(required = true) memberId: String
    ): List<Survey> {
        return surveyService.getSurvey(role, memberId)
    }

    @PostMapping
    @Operation(summary = "Create a survey")
    fun createSurvey(@RequestBody surveyRequest: SurveyRequestDTO) {
        return surveyService.createSurvey(surveyRequest)
    }
}
