//
//  AppContainer.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//

protocol AppContainer {
    var amphibiansInfoRepository: AmphibiansInfoRepository { get }
}

class DefaultAppContainer: AppContainer {
    
    let baseURL = "https://android-kotlin-fun-mars-server.appspot.com/"
    
    lazy var amphibiansApi = AmphibiansApiService(baseURL: baseURL)
    
    lazy var amphibiansRemoteDataSource = AmphibiansRemoteDataSource(
        amphibiansApi: amphibiansApi,
        ioTask: .userInitiated
    )
    
    var amphibiansInfoRepository: AmphibiansInfoRepository {
        NetworkAmphibiansInfoRepository(amphibiansRemoteDataSource: amphibiansRemoteDataSource)
    }
}

