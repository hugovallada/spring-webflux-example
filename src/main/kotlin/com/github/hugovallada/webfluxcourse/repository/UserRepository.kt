package com.github.hugovallada.webfluxcourse.repository

import com.github.hugovallada.webfluxcourse.entity.User
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class UserRepository(private val mongoTemplate: ReactiveMongoTemplate) {

	fun save(user: User): Mono<User> = mongoTemplate.save(user).also { it.subscribe()  }

	fun findAll(): Flux<User> =
		mongoTemplate.findAll(User::class.java)

}