package com.example.mvvmrecipe.domain.util

interface DomainMapper<T, DomainModel> {
    fun mapToDomain(model:T): DomainModel
    fun mapFromDomain(domainModel: DomainModel):T
}