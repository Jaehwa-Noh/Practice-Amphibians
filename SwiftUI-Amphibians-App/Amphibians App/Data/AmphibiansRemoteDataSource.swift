//
//  AmphibiansRemoteDataSource.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//

import Foundation
import Factory

protocol AmphibiansRemoteDataSource {
    func getAmphibiansInfo() async throws -> [AmphibiansInfoApiModel]
}

struct NetworkAmphibiansDataSource: AmphibiansRemoteDataSource {
    @Injected(\.amphibiansApiService) var amphibiansApi
    @Injected(\.userInitiated) var ioTask
    
    func getAmphibiansInfo() async throws -> [AmphibiansInfoApiModel] {
        do {
            return try await Task.detached(priority: ioTask) {
                do {
                    return try await amphibiansApi.getAmphibiansInfo()
                } catch {
                    throw error
                }
            }.result.get()
        } catch {
            throw error
        }

    }
}


protocol AmphibiansApi {
    func getAmphibiansInfo() async throws -> [AmphibiansInfoApiModel]
}
