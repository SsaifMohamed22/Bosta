# Bosta Android Task 🚚📱

This is a simple Android application developed as part of the Bosta Android Task. The app consists of a single screen that displays a list of cities and their corresponding districts, fetched from Bosta’s public API.

## 📱 App Features
- Fetches cities and their districts from Bosta API.
- Displays data in a clean and responsive RecyclerView.
- Follows MVVM architecture for code separation and scalability.
- Uses Coroutines for asynchronous operations.
- Clean dependency injection using Dagger 2.
-  Jetpack components used for better lifecycle management

## 🛠️ Tech Stack
- **Language:** Kotlin
- **Architecture:** MVVM
- **Networking:** Retrofit 2
- **Dependency Injection:** Dagger 2
- **Async Programming:** Kotlin Coroutines
- **UI:** RecyclerView, ViewBinding
- **Jetpack:** ViewModel, LiveData 

## 🌐 API Used
- **Base URL:** `https://stg-app.bosta.co/api/v2`
- **Endpoint:**  
  `GET cities/getAllDistricts?countryId=60e4482c7cb7d4bc4849c4d5`

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/BostaAndroidTask.git
