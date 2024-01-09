//
//  AmphibiansApiService.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//
import SwiftUI

struct AmphibiansApiService: AmphibiansApi {
    let baseURL: String
    func getAmphibiansInfo() async -> [AmphibiansInfoApiModel] {
        let path = "amphibians"
        let url = URL(string: baseURL + path)
        guard let url = url else {
            return [AmphibiansInfoApiModel]()
        }
        var data: Data?
        var response: URLResponse?
        do {
            (data, response) = try await URLSession.shared.data(from: url)
        } catch {
            print(error.localizedDescription)
        }
        guard let httpResponse = response as? HTTPURLResponse,
              (200...299).contains(httpResponse.statusCode) else {
            return [AmphibiansInfoApiModel]()
        }
        guard let data = data else {
            return [AmphibiansInfoApiModel]()
        }
        
        let decoder = JSONDecoder()
        do {
            let responseAmphibians = try decoder.decode([AmphibiansInfoApiModel].self, from: data)
            return responseAmphibians
        } catch {
            
        }
        
        return [AmphibiansInfoApiModel]()
    }
}
