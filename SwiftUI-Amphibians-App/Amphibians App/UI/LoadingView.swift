//
//  LoadingView.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/9/24.
//

import SwiftUI

struct LoadingView: View {
    var body: some View {
        ProgressView()
            .controlSize(.large)
    }
}

#Preview {
    LoadingView()
}
