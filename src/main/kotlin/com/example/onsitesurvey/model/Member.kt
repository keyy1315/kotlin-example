package com.example.onsitesurvey.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "member")
data class Member(
    @Id
    @Column(name = "id")
    var id: Long,
    @Column(name = "user_id")
    val userId: String,
    @Column(name = "user_name")
    val userName: String,
    @Column(name = "email")
    val email: String,
    @Column(name = "store_id")
    val storeId: String,
    @Column(name = "store_name")
    val storeName: String,
    @Column(name = "builder_id")
    val builderId: String,
    @Column(name = "builder_name")
    val builderName: String
)



