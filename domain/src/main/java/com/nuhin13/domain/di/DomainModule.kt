package com.nuhin13.domain.di

import com.nuhin13.domain.feature.authentication.repository.AuthenticationRepository
import com.nuhin13.domain.feature.authentication.usecase.LoginUseCase
import com.nuhin13.domain.feature.authentication.usecase.RegistrationUseCase
import com.nuhin13.domain.feature.post.repository.PostRepository
import com.nuhin13.domain.feature.post.usecase.GetPostCommentList
import com.nuhin13.domain.feature.post.usecase.GetPostList
import com.nuhin13.domain.feature.user.repository.UserRepository
import com.nuhin13.domain.feature.user.usecase.GetUserDetails
import com.nuhin13.domain.feature.user.usecase.GetUserList
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    @Reusable
    fun provideLoginUseCase(authRepo: AuthenticationRepository): LoginUseCase {
        return LoginUseCase(authRepo)
    }

    @Provides
    @Reusable
    fun provideRegistrationUseCase(authRepo: AuthenticationRepository): RegistrationUseCase {
        return RegistrationUseCase(authRepo)
    }

    @Provides
    @Singleton
    fun providePostUseCase(postRepo: PostRepository): GetPostList {
        return GetPostList(postRepo)
    }

    @Provides
    @Singleton
    fun providePostCommentUseCase(postRepo: PostRepository): GetPostCommentList {
        return GetPostCommentList(postRepo)
    }

    @Provides
    @Singleton
    fun provideUserListCase(userRepo: UserRepository): GetUserList {
        return GetUserList(userRepo)
    }

    @Provides
    @Singleton
    fun provideUserDetailsCase(userRepo: UserRepository): GetUserDetails {
        return GetUserDetails(userRepo)
    }
}