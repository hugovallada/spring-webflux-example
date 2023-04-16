package com.github.hugovallada.webfluxcourse.service

import com.github.hugovallada.webfluxcourse.entity.User
import com.github.hugovallada.webfluxcourse.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class FindAll(private val repository: UserRepository) {
	operator fun invoke(): Flux<User> =
		repository.findAll()
}