//
//  AmphibiansListView.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//

import SwiftUI

struct AmphibiansLisInfotView: View {
    var amphibiansInfo: [AmphibiansInfoApiModel]
    
    var body: some View {
        ScrollView {
            LazyVStack {
                ForEach(amphibiansInfo, id: \.name) { amphibianInfo in
                    AmphibiansListItem(amphibian: amphibianInfo)
                }
            }
        }
    }
}

struct AmphibiansListItem: View {
    let amphibian: AmphibiansInfoApiModel
    
    var body: some View {
        ZStack {
            VStack(alignment: .leading) {
                Text("\(amphibian.name)(\(amphibian.type))")
                    .font(.title2)
                    
                AsyncImage(url: URL(string: "\(amphibian.imgSrc)")) {
                    phase in
                    if let image = phase.image {
                        image.resizable()
                            .scaledToFill()
                            .frame(height: 200)
                            .clipped()
                    } else if phase.error != nil {
                        HStack {
                            Spacer()
                            Image(systemName: "photo")
                                .frame(height: 200)
                            Spacer()
                        }
                    } else {
                        HStack {
                            Spacer()
                            ProgressView()
                                .frame(height: 200)
                            Spacer()
                        }
                    }
                }
                Text("\(amphibian.description)")
            }
            .padding(16)
        }
        .background(
            Color.green.opacity(0.1)
        )
        .clipShape(RoundedRectangle(cornerRadius: 8.0))
        .shadow(radius: 2)
        .padding(8)
    }
}

#Preview {
    AmphibiansLisInfotView(amphibiansInfo: [AmphibiansInfoApiModel]())
}
