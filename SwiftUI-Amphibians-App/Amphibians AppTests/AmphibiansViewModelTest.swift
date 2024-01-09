//
//  AmphibiansViewModelTest.swift
//  Amphibians AppTests
//
//  Created by Jaehwa Noh on 1/9/24.
//

import XCTest
@testable import Amphibians_App

final class AmphibiansViewModelTest: XCTestCase {

    private var amphibiansViewModel: AmphibiansViewModel?
    
    override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.
        try super.setUpWithError()
        let fakeAmphibiansApi = FakeAmphibiansApiService()
        let fakeAmphibiansRemoteDataSource = FakeAmphibiansRemoteDataSource(fakeAmphibiansApi: fakeAmphibiansApi, ioTask: .userInitiated)
        let fakeAmphibiansInfoRepository = FakeAmphibiansInfoRepository(fakeAmphibiansRemoteDataSource: fakeAmphibiansRemoteDataSource)
        
        amphibiansViewModel = AmphibiansViewModel(amphibiansInfoRepository:  fakeAmphibiansInfoRepository)
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        try super.tearDownWithError()
        amphibiansViewModel = nil
    }
    
    func test_AmphibiansViewModel_GetAmphibiansInfo_GetAmphibiansListSuccess() {
        Task {
            XCTAssertEqual(amphibiansViewModel!.amphibiansInfo, FakeData.getAmphibiansInfo)
        }
    }
}
