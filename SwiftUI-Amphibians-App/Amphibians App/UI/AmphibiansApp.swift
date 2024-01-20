//
//  ContentView.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//

import SwiftUI

struct AmphibiansApp: View {
    private var amphibiansViewModel: AmphibiansViewModel!
    
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
    AmphibiansApp()
}
