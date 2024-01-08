//
//  AmphibiansListView.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//

import SwiftUI

struct AmphibiansLisInfotView: View {
    var body: some View {
        ScrollView {
            LazyVStack {
                AmphibiansListItem()
            }
        }
    }
}

struct AmphibiansListItem: View {
    var body: some View {
        VStack {
            Text("")
            AsyncImage(url: URL(string: ""))
            Text("")
        }
    }
}

#Preview {
    AmphibiansLisInfotView()
}
