//
//  AmphibiansRemoteDataSourceTest.swift
//  Amphibians AppTests
//
//  Created by Jaehwa Noh on 1/9/24.
//

import Factory
import XCTest
@testable import Amphibians_App

final class AmphibiansRemoteDataSourceTest: XCTestCase {

    func test_AmphibiansRemoteDataSource_LoadImage_VerifyLoadListSuccess() {
        Task {
            Container.shared.amphibiansApiService.register {
                FakeAmphibiansApiService()
            }
            
            let amphibiansRemoteDataSource = Container.shared.networkAmphibiansDataSource()
            
            let amphibiansList = try await amphibiansRemoteDataSource.getAmphibiansInfo()
            
            XCTAssertEqual(FakeData.getAmphibiansInfo, amphibiansList)
        }
    }

}
