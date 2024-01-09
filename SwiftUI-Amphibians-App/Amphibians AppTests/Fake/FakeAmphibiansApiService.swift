//
//  FakeAmphibiansApiService.swift
//  Amphibians AppTests
//
//  Created by Jaehwa Noh on 1/9/24.
//

@testable import Amphibians_App
struct FakeAmphibiansApiService: AmphibiansApi {
    
    func getAmphibiansInfo() async throws -> [Amphibians_App.AmphibiansInfoApiModel] {
        return FakeData.getAmphibiansInfo
    }
}


struct FakeData {
    static private let name1 = "name1"
    static private let type1 = "type1"
    static private let description1 = "description1"
    static private let imgSrc1 = "img1"
    
    static private let name2 = "name2"
    static private let type2 = "type2"
    static private let description2 = "description2"
    static private let imgSrc2 = "img2"
    
    static var getAmphibiansInfo: [AmphibiansInfoApiModel] {
        [AmphibiansInfoApiModel(
            name: name1,
            type: type1,
            description: description1,
            imgSrc: imgSrc1
        ),
         AmphibiansInfoApiModel(
            name: name2,
            type: type2,
            description: description2,
            imgSrc: imgSrc2
         )]
    }
}
