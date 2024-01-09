//
//  ErrorView.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/9/24.
//

import SwiftUI

struct ErrorView: View {
    let errorMessage: String
    let onRetryClick: () -> Void
    var body: some View {
        VStack {
            Text(errorMessage)
            Spacer()
                .frame(height:24)
            Button("Retry") {
                onRetryClick()
            }
        }
    }
}

#Preview {
    ErrorView(errorMessage: "", onRetryClick: {})
}
