package com.nuhin13.domain.entities

class Address(
    private val presentAddress: String? = null,
    private val permanentAddress: String? = null,
) {
    override fun toString(): String {
        return "UserAddress(presentAddress=$presentAddress, permanentAddress=$permanentAddress)"
    }

    fun getAddress(): String? {
        if (permanentAddress != null) return permanentAddress
        return presentAddress
    }
}