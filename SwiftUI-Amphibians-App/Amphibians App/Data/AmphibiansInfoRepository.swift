//
//  AmphibiansInfoRepository.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//

import SwiftUI
import Factory

protocol AmphibiansInfoRepository {
    func getAmphibiansInfo() async throws -> [AmphibiansInfoApiModel]
}

struct NetworkAmphibiansInfoRepository: AmphibiansInfoRepository {
    @Injected(\.networkAmphibiansDataSource) var amphibiansRemoteDataSource: AmphibiansRemoteDataSource
    
    func getAmphibiansInfo() async throws -> [AmphibiansInfoApiModel] {
        do {
            return try await amphibiansRemoteDataSource.getAmphibiansInfo()
        } catch {
            throw error
        }
    }
}
