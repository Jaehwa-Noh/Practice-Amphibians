//
//  AmphibiansRemoteDataSourceTest.swift
//  Amphibians AppTests
//
//  Created by Jaehwa Noh on 1/9/24.
//

import XCTest
@testable import Amphibians_App

final class AmphibiansRemoteDataSourceTest: XCTestCase {

    func test_AmphibiansRemoteDataSource_LoadImage_VerifyLoadListSuccess() {
        Task {
            let amphibiansRemoteDataSource = NetworkAmphibiansDataSource(amphibiansApi: FakeAmphibiansApiService(), ioTask: .userInitiated)
            
            let amphibiansList = try await amphibiansRemoteDataSource.getAmphibiansInfo()
            
            XCTAssertEqual(FakeData.getAmphibiansInfo, amphibiansList)
        }
    }

}
