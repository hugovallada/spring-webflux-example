package com.github.hugovallada.webfluxcourse.api.contract

import com.github.hugovallada.webfluxcourse.api.model.UserRequest
import com.github.hugovallada.webfluxcourse.api.model.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserController {

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