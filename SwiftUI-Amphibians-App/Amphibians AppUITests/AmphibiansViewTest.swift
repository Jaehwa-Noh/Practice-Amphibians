//
//  AmphibiansViewTest.swift
//  Amphibians AppUITests
//
//  Created by Jaehwa Noh on 1/9/24.
//

import XCTest

final class AmphibiansViewTest: XCTestCase {

    var app: XCUIApplication?
    
    override func setUpWithError() throws {
        try super.setUpWithError()
        // Put setup code here. This method is called before the invocation of each test method in the class.

        // In UI tests it is usually best to stop immediately when a failure occurs.
        continueAfterFailure = false

        // In UI tests it’s important to set the initial state - such as interface orientation - required for your tests before they run. The setUp method is a good place to do this.
        
        app = XCUIApplication()
        app?.launch()
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        try super.tearDownWithError()
        app = nil
    }
    
    func test_AmphibiansListView_LoadList_AmphibiansListDisplaySuccess() {
        navigateToList()
    }
    
    func test_AmphibiansView_LoadImage_ImageDisplaySuccess() {
        navigateToList()
        let imageView = app!.images["Great Basin Spadefoot"]
        XCTAssertTrue(imageView.waitForExistence(timeout: 100))
    }
    
    func navigateToList() {
        let greatBasin = app!.staticTexts["Great Basin Spadefoot(Toad)"]
        XCTAssertTrue(greatBasin.waitForExistence(timeout: 100))
        XCTAssertTrue(greatBasin.exists)
    }
    
}
