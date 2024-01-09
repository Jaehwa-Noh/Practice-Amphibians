//
//  Amphibians_AppApp.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/8/24.
//

import SwiftUI

@main
struct Amphibians_AppApp: App {
    
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate: AppDelegate
    
    var body: some Scene {
        WindowGroup {
            AmphibiansApp(appDelegate: appDelegate)
        }
    }
}
