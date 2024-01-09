//
//  NetworkAmphibiansRepositoryTest.swift
//  Amphibians AppTests
//
//  Created by Jaehwa Noh on 1/9/24.
//

import XCTest
@testable import Amphibians_App

final class NetworkAmphibiansRepositoryTest: XCTestCase {
    
    func test_NetworkAmphibiansRepository_GetAmphibiansInfo_VerifyAmphibiansList() {
        Task {
            let repository = NetworkAmphibiansInfoRepository(amphibiansRemoteDataSource:
                                                                FakeAmphibiansRemoteDataSource(fakeAmphibiansApi: FakeAmphibiansApiService(), ioTask: .userInitiated)
            )
            let amphibiansList = try await repository.getAmphibiansInfo()
            XCTAssertEqual(FakeData.getAmphibiansInfo, amphibiansList)
        }
    }
}
