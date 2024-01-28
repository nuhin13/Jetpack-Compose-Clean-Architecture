package com.nuhin13.data.di

import com.nuhin13.data.api.ApiService
import com.nuhin13.data.features.authentication.AuthRepoImpl
import com.nuhin13.data.features.authentication.datasource.AuthenticationDataSource
import com.nuhin13.data.features.post.PostRepoImpl
import com.nuhin13.data.features.post.datasource.PostDataSource
import com.nuhin13.data.features.post.datasource.PostDataSourceImpl
import com.nuhin13.data.features.post.datasource.PostHttpImpl
import com.nuhin13.data.features.user.UserRepoImpl
import com.nuhin13.data.features.user.datasource.UserHttpDataSourceImpl
import com.nuhin13.data.features.user.datasource.UserLocalDataSourceImpl
import com.nuhin13.domain.feature.authentication.repository.AuthenticationRepository
import com.nuhin13.domain.feature.post.repository.PostRepository
import com.nuhin13.domain.feature.user.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideAuthRepo(authenticationDataSource: AuthenticationDataSource): AuthenticationRepository {
        return AuthRepoImpl(authenticationDataSource)
    }

    @Provides
    @Singleton
    fun provideUserRepo(apiService: ApiService): UserRepository {
        val userHttpImpl = UserHttpDataSourceImpl(apiService)
        val userLocalSourceImpl = UserLocalDataSourceImpl(userHttpImpl)

        return UserRepoImpl(userLocalSourceImpl)
    }

    @Provides
    @Singleton
    fun providePostDataHttpSource(apiService: ApiService): PostDataSource {
        return PostHttpImpl(apiService)
    }

    @Provides
    @Singleton
    @Named("postLocalDataSource")
    fun providePostDataSource(postHttpImpl: PostHttpImpl): PostDataSource {
        return PostDataSourceImpl(postHttpImpl)
    }

    @Provides
    @Singleton
    fun providePostRepo(@Named("postLocalDataSource") postDataSource: PostDataSource): PostRepository {
        return PostRepoImpl(postDataSource)
    }
}