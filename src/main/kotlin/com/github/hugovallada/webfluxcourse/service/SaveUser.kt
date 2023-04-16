package com.github.hugovallada.webfluxcourse.service

import com.github.hugovallada.webfluxcourse.api.model.request.UserRequest
import com.github.hugovallada.webfluxcourse.entity.User
import com.github.hugovallada.webfluxcourse.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class SaveUser(private val repository: UserRepository) {
	operator fun invoke(request: UserRequest): Mono<User> =
		repository.save(
			User(
				name = request.name,
				email = request.email,
				password = request.password
			)
		)

}