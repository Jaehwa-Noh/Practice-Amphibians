//
//  AmphibiansViewModel.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/9/24.
//

import SwiftUI

class AmphibiansViewModel: ObservableObject {
    @Published var amphibiansInfo: [AmphibiansInfoApiModel]
    @Published var amphibiansViewState: AmphibiansViewState = .loading
    private let amphibiansInfoRepository: AmphibiansInfoRepository
    
    enum AmphibiansViewState {
        case success([AmphibiansInfoApiModel])
        case loading
        case error(String)
    }
    
    init(amphibiansInfoRepository: AmphibiansInfoRepository) {
        self.amphibiansInfo = [AmphibiansInfoApiModel]()
        self.amphibiansInfoRepository = amphibiansInfoRepository
        getAmphibiansList()
    }
    
    func getAmphibiansList() {
        Task {
            let response: AmphibiansViewState
            await MainActor.run {
                amphibiansViewState = .loading
            }
            do {
                response = try await .success(amphibiansInfoRepository.getAmphibiansInfo())
            } catch {
                response = .error(error.localizedDescription)
            }
            
            await MainActor.run {
                amphibiansViewState = response
            }
        }
    }
    
    
}
