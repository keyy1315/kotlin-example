package com.example.onsitesurvey.model.enums

import com.fasterxml.jackson.annotation.JsonValue

enum class Role(@JsonValue val value: String) {
    T01("T01"),
    ADMIN("admin"),
    ADMIN_SUB("adminSub"),
    BUILDER("builder"),
    PARTNERS("partners");

    override fun toString(): String = value

    companion object {
        fun fromValue(value: String): Role? =
                values().find { it.value.equals(value, ignoreCase = true) }
    }
}
