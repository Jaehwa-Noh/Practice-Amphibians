//
//  AmphibiansApiService.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//
import SwiftUI

enum AmphibiansApiServiceError: Error {
    case NoData
    case HttpError
    case UrlError
}

struct AmphibiansApiService: AmphibiansApi {
    let baseURL: String
    func getAmphibiansInfo() async throws -> [AmphibiansInfoApiModel] {
        let path = "amphibians"
        let url = URL(string: baseURL + path)
        guard let url = url else {
            throw AmphibiansApiServiceError.UrlError
        }
        
        let urlSessionCofig = URLSessionConfiguration.default
        urlSessionCofig.timeoutIntervalForRequest = 10
        urlSessionCofig.timeoutIntervalForResource = 10
        let urlSession = URLSession(configuration: urlSessionCofig)
        
        var data: Data?
        var response: URLResponse?
        do {
            (data, response) = try await urlSession.data(from: url)
        } catch {
            throw error
        }
        guard let httpResponse = response as? HTTPURLResponse,
              (200...299).contains(httpResponse.statusCode) else {
            throw AmphibiansApiServiceError.HttpError
        }
        guard let data = data else {
            throw AmphibiansApiServiceError.NoData
        }
        
        let decoder = JSONDecoder()
        do {
            let responseAmphibians = try decoder.decode([AmphibiansInfoApiModel].self, from: data)
            return responseAmphibians
        } catch {
            throw error
        }
    }
}
