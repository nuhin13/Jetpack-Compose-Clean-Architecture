package com.nuhin13.domain.entities

class PersonName(
    private val firstName: String? = null,
    private val lastName: String? = null,
    private val sureName: String? = null,
    private val fullName: String? = null,
) {
    override fun toString(): String {
        return "UserName(firstName=$firstName, lastName=$lastName, sureName=$sureName, fullName=$fullName)"
    }

    fun getName(): String {
        if (fullName != null) return fullName
        return "$firstName $lastName $sureName"
    }
}