//
//  NetworkAmphibiansRepositoryTest.swift
//  Amphibians AppTests
//
//  Created by Jaehwa Noh on 1/9/24.
//

import Factory
import XCTest
@testable import Amphibians_App

final class NetworkAmphibiansRepositoryTest: XCTestCase {
    
    func test_NetworkAmphibiansRepository_GetAmphibiansInfo_VerifyAmphibiansList() {
        Task {
            Container.shared.networkAmphibiansDataSource.register {
                FakeAmphibiansRemoteDataSource(fakeAmphibiansApi: FakeAmphibiansApiService(), ioTask: .userInitiated)
            }
            let repository = Container.shared.networkAmphibiansInfoRepository()
            
            let amphibiansList = try await repository.getAmphibiansInfo()
            XCTAssertEqual(FakeData.getAmphibiansInfo, amphibiansList)
        }
    }
}
