package com.github.hugovallada.webfluxcourse.controller

import com.github.hugovallada.webfluxcourse.api.contract.UserAPI
import com.github.hugovallada.webfluxcourse.api.model.request.UserRequest
import com.github.hugovallada.webfluxcourse.api.model.response.UserResponse
import com.github.hugovallada.webfluxcourse.service.FindAll
import com.github.hugovallada.webfluxcourse.service.SaveUser
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class UserController(private val saveUserService: SaveUser, private val findAllService: FindAll): UserAPI {

	override fun save(request: UserRequest): ResponseEntity<Mono<Unit>> {
		saveUserService(request)
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(Mono.empty())
	}

	override fun findById(id: String): ResponseEntity<Mono<UserResponse>> {
		TODO("Not yet implemented")
	}

	override fun findAll(): ResponseEntity<Flux<UserResponse>> {
		return ResponseEntity.ok().body(
			findAllService().map { UserResponse.from(it) }
		)
	}

	override fun update(id: String, request: UserRequest): ResponseEntity<Mono<UserResponse>> {
		TODO("Not yet implemented")
	}

	override fun delete(id: String): ResponseEntity<Mono<Unit>> {
		TODO("Not yet implemented")
	}
}