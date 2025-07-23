package com.example.onsitesurvey.model

import jakarta.persistence.*

@Entity
class SurveyRoof(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0,
        @Column(name = "roof_data") val roofData: String,
        @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "survey_id") var survey: Survey? = null
)
