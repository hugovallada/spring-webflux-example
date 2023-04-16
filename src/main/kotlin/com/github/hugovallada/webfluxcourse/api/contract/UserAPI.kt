package com.github.hugovallada.webfluxcourse.api.contract

import com.github.hugovallada.webfluxcourse.api.model.request.UserRequest
import com.github.hugovallada.webfluxcourse.api.model.response.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserAPI {

	@PostMapping
	fun save(@RequestBody request: UserRequest): ResponseEntity<Mono<Unit>>

	@GetMapping(value = ["/{id}"])
	fun findById(@PathVariable id: String): ResponseEntity<Mono<UserResponse>>

	@GetMapping
	fun findAll(): ResponseEntity<Flux<UserResponse>>

	@PatchMapping(value = ["/{id}"])
	fun update(@PathVariable id: String, @RequestBody request: UserRequest): ResponseEntity<Mono<UserResponse>>

	@DeleteMapping(value = ["/{id}"])
	fun delete(@PathVariable id: String): ResponseEntity<Mono<Unit>>

}