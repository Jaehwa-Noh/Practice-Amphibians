//
//  AppContainer.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/20/24.
//

import Factory

extension Container {
    var amphibiansInfoRepository: Factory<AmphibiansInfoRepository> {
        self {
            let baseURL = "https://android-kotlin-fun-mars-server.appspot.com/"
            
            lazy var amphibiansApi = AmphibiansApiService(baseURL: baseURL)
            
            lazy var amphibiansRemoteDataSource = NetworkAmphibiansDataSource(
                amphibiansApi: amphibiansApi,
                ioTask: .userInitiated
            )
            
            var amphibiansInfoRepository: AmphibiansInfoRepository {
                NetworkAmphibiansInfoRepository(amphibiansRemoteDataSource: amphibiansRemoteDataSource)
            }
            return amphibiansInfoRepository
        }
    }
}

