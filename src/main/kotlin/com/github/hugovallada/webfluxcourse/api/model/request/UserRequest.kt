package com.github.hugovallada.webfluxcourse.api.model.request

@JvmRecord
data class UserRequest(
	val name: String,
	val email: String,
	val password: String
)
