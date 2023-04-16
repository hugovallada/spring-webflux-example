package com.github.hugovallada.webfluxcourse.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document


@Document
class User(
	@Id
	val id: ObjectId = ObjectId(),
	val name: String,
	@Indexed(unique = true)
	val email: String,
	val password: String
)