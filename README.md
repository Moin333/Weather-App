# 🌦️ Weather App
This is a simple yet elegant weather app built with Kotlin and Jetpack Compose. The app fetches real-time weather information for a given city using the OpenWeatherMap API. It supports dark and light mode and automatically adapts to the system theme.

## 🚀 Features
- 🌡️ Display temperature, weather conditions, wind speed, and humidity for a given city.
- 🌙 Support for both light and dark modes.
- 🎨 Dynamic theming based on the current system theme.

## 📸 Screenshots

### Dark Mode
<img alt="Dark Mode Screenshot home" src=".\Screenshot 0 Dark.png" width="180"/>
<img alt="Dark Mode Screenshot search" src=".\Screenshot 1 Dark.png" width="180"/>

### Light Mode
<img alt="Light Mode Screenshot home" src=".\Screenshot 0 Light.png" width="180"/>
<img alt="Light Mode Screenshot search" src=".\Screenshot 1 Light.png" width="180"/>

## 🛠️ Technologies Used
1. Kotlin: Primary language for Android development.
2. Jetpack Compose: Modern Android UI toolkit for building responsive and declarative UI.
3. Retrofit: A type-safe HTTP client for Android used to consume the OpenWeatherMap API.
4. MVVM Architecture: Ensures separation of concerns and clean architecture by separating the UI (View), the business logic (ViewModel), and the data (Model).
5. Material3: For a modern UI look and feel.

## 🔧 How to Run
1. Clone the repository:
git clone https://github.com/Moin333/weather-app.git
2. Open the project in Android Studio.
3. Add your OpenWeatherMap API Key in the WeatherViewModel.kt file.
4. Build and run the project.

## How to Use
1. Launch the app.
2. Type the name of a city in the search bar.
3. Press Get Weather to display the current weather for the entered city.

## 📂 Project Structure
weather-app/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/weatherapp/
│   │   │   │   ├── MainActivity.kt          # Entry point of the app
│   │   │   │   ├── WeatherViewModel.kt      # Handles fetching weather data
│   │   │   │   ├── ui/
│   │   │   │   │   ├── HomeScreen.kt        # Displays weather details
│   │   │   │   │   ├── SearchScreen.kt      # Search weather by city name
│   │   │   │   ├── utils/
│   │   │   │   │   ├── WeatherRepository.kt # Utility functions for network operations
│   │   │   │   │   ├──WeatherService.kt
│   ├── AndroidManifest.xml                  # Application metadata
├── build.gradle                             # Build configuration file
├── README.md                                # Project documentation
└── settings.gradle                          # Project-level settings

## 🗂️ Main Files
1. MainActivity.kt: The entry point of the app, responsible for setting up the navigation and theme switching.
2. WeatherViewModel.kt: Handles the API calls to fetch weather data and exposes it to the UI components.
3. SearchScreen.kt: Contains the search bar where users can input a city name and search for weather.
4. HomeScreen.kt: Displays the weather data such as temperature, weather description, wind speed, and humidity.
5. utils: A utility class for network-related operations.

## Themes: Light and Dark Modes
The app automatically switches between light and dark mode based on the system setting, ensuring a consistent user experience.
1. Text Color: Adjusts according to the background theme.
2. Background Color: Changes based on light/dark mode for better readability.

🛡️License
This project is licensed under the MIT License. Feel free to use it as you wish.