//
//  AmphibiansInfoRepository.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//

import SwiftUI

protocol AmphibiansInfoRepository {
    func getAmphibiansInfo() async -> [AmphibiansInfoApiModel]
}

struct NetworkAmphibiansInfoRepository: AmphibiansInfoRepository {
    let amphibiansRemoteDataSource: AmphibiansRemoteDataSource
    
    func getAmphibiansInfo() async -> [AmphibiansInfoApiModel] {
        return await amphibiansRemoteDataSource.getAmphibiansInfo()
    }
    
    
}
