//
//  AmphibiansRemoteDataSource.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//

struct AmphibiansRemoteDataSource {
    let amphibiansApi: AmphibiansApi
    let ioTask: TaskPriority
    
    func getAmphibiansInfo() async -> [AmphibiansInfoApiModel] {
        do {
            return try await Task.detached(priority: ioTask) {
                await amphibiansApi.getAmphibiansInfo()
            }.result.get()
        } catch {
            print(error.localizedDescription)
            return [AmphibiansInfoApiModel]()
        }
    }
}


protocol AmphibiansApi {
    func getAmphibiansInfo() async -> [AmphibiansInfoApiModel]
}
