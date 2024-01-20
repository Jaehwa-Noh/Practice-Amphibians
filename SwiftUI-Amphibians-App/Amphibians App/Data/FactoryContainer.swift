//
//  AppContainer.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/20/24.
//

import Factory

extension Container {
    var networkAmphibiansInfoRepository: Factory<AmphibiansInfoRepository> {
        self {
            NetworkAmphibiansInfoRepository()
        }
        .singleton
    }
    
    var networkAmphibiansDataSource: Factory<AmphibiansRemoteDataSource> {
        self {
            NetworkAmphibiansDataSource()
        }
        .singleton
    }
    
    var amphibiansApiService: Factory<AmphibiansApi> {
        self {
            let baseURL = "https://android-kotlin-fun-mars-server.appspot.com/"
            
            return AmphibiansApiService(baseURL: baseURL)
        }
        .singleton
    }
    
    var userInitiated: Factory<TaskPriority> {
        self {
            .userInitiated
        }
    }
}
