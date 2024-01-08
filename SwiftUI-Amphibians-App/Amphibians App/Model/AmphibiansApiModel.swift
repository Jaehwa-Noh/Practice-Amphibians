//
//  AmphibiansApiModel.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//

struct AmphibiansApiModel: Decodable {
    let name: String
    let type: String
    let description: String
    let imgSrc: String
    
    enum CodingKeys: String, CodingKey {
        case name
        case type
        case description
        case imgSrc = "img_src"
    }
}
