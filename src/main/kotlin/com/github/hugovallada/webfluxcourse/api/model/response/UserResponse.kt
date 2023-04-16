package com.github.hugovallada.webfluxcourse.api.model.response

import com.github.hugovallada.webfluxcourse.entity.User

data class UserResponse(
	var id: String,
	val name: String,
	val email: String,
	val password: String
) {
	companion object {
		fun from(user: User) = UserResponse(
			id = user.id.toHexString(), name = user.name,
			email = user.email, password = user.password
		)
	}
}
