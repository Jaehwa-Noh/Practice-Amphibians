//
//  FakeAmphibiansRemoteDataSource.swift
//  Amphibians AppTests
//
//  Created by Jaehwa Noh on 1/9/24.
//

@testable import Amphibians_App
struct FakeAmphibiansRemoteDataSource {
    let fakeAmphibiansApi: AmphibiansApi
    let ioTask: TaskPriority
    
    func getAmphibiansInfo() async throws -> [AmphibiansInfoApiModel] {
        do {
            return try await Task.detached(priority: ioTask) {
                do {
                    return try await fakeAmphibiansApi.getAmphibiansInfo()
                } catch {
                    throw error
                }
            }.result.get()
        } catch {
            print("DataSource error \(error)")
            throw error
        }
    }
}

