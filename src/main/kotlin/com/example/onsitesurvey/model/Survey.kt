package com.example.onsitesurvey.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Survey(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0,
        @Column(name = "srl_no") val srlNo: String,
        @Column(name = "representative") val representative: String,
        @Column(name = "representative_id") val representativeId: String,
        @Column(name = "store") val store: String?,
        @Column(name = "store_id") val storeId: String?,
        @Column(name = "construction_point") val constructionPoint: String?,
        @Column(name = "construction_point_id") val constructionPointId: String?,
        @Column(name = "submit_status") val submitStatus: Boolean,
        @Column(name = "submit_date") val submitDate: LocalDateTime?,
        @Column(name = "submit_target") val submitTarget: String?,
        @Column(name = "submit_target_id") val submitTargetId: String?,
        @OneToOne(mappedBy = "survey", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        var surveyRoof: SurveyRoof? = null,
        @Column(name = "created_at") val createdAt: LocalDateTime = LocalDateTime.now(),
        @Column(name = "updated_at") val updatedAt: LocalDateTime = LocalDateTime.now(),
)
