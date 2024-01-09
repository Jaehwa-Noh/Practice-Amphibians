//
//  FakeAmphibiansInfoRepository.swift
//  Amphibians AppTests
//
//  Created by Jaehwa Noh on 1/9/24.
//


@testable import Amphibians_App

struct FakeAmphibiansInfoRepository: AmphibiansInfoRepository {
    let fakeAmphibiansRemoteDataSource: FakeAmphibiansRemoteDataSource
    
    func getAmphibiansInfo() async throws -> [Amphibians_App.AmphibiansInfoApiModel] {
        do {
            return try await fakeAmphibiansRemoteDataSource.getAmphibiansInfo()
        } catch {
            print("Repository \(error)")
            throw error
        }
    }
    
    
}
