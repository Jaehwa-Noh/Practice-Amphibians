//
//  AppDelegate.swift
//  Amphibians App
//
//  Created by Jaehwa Noh on 1/9/24.
//

import UIKit

class AppDelegate: NSObject, UIApplicationDelegate {
    private var appContainer: AppContainer?
    
    func application(_ application: UIApplication, willFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        self.appContainer = DefaultAppContainer()
        return true
    }
    
    func getAppContainer() -> AppContainer {
        return appContainer ?? DefaultAppContainer()
    }
}
