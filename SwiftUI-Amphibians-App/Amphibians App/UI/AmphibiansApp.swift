//
//  ContentView.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//

import SwiftUI

struct AmphibiansApp: View {
    @StateObject private var amphibiansViewModel: AmphibiansViewModel
    
    init(appDelegate: AppDelegate) {
        let amphibiansInfoRepository: AmphibiansInfoRepository = appDelegate.getAppContainer().amphibiansInfoRepository
        
        _amphibiansViewModel = StateObject(wrappedValue: AmphibiansViewModel(amphibiansInfoRepository: amphibiansInfoRepository))
    }
    
    var body: some View {
        switch amphibiansViewModel.amphibiansViewState {
        case .success(let amphibiansInfo):
            AmphibiansLisInfotView(
                amphibiansInfo: amphibiansInfo
            )
        case .loading:
            LoadingView()
        case .error(let errorMessage):
            ErrorView(errorMessage: errorMessage, onRetryClick: amphibiansViewModel.getAmphibiansList)
        }
    }
}

#Preview {
    AmphibiansApp(appDelegate: AppDelegate())
}
