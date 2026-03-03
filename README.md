# 📜 Quativa - AI-Powered Quotes App

> **Quativa is a modern, high-performance Android application built with Jetpack Compose, Hilt, and Room. It leverages AI (LiteRT) for content generation and provides a fluid interface for discovering and sharing inspiring quotes.**

---

## 🚀 Features

- 🎨 **Modern UI:** 100% Jetpack Compose for a declarative, reactive, and fluid user experience.
- 🤖 **AI Integration:** Powered by Google's LiteRT (formerly TensorFlow Lite) for on-device intelligence.
- 💾 **Local Persistence:** Uses Room Database for lightning-fast local storage and offline access to your favorite quotes.
- 🏗️ **Dependency Injection:** Built with Dagger Hilt for a scalable and maintainable architecture.
- 🌐 **Networking:** Uses Retrofit for seamless API integrations and quote fetching.
- 📸 **Social Sharing:** Integrated with Capturable for converting UI components into beautiful shareable cards/images.
- ⚡ **Performance:** Optimized build times using Kotlin Symbol Processing (KSP).

---

## 🎨 Tech Stack

- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI Framework:** [Jetpack Compose](https://developer.android.com/compose)
- **Dependency Injection:** [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- **Local Storage:** [Room Database](https://developer.android.com/training/data-storage/room)
- **Machine Learning:** [LiteRT](https://ai.google.dev/edge/litert)
- **Networking:** [Retrofit](https://square.github.io/retrofit/)
- **Architecture:** MVVM + Repository Pattern
- **Asynchronous:** Kotlin Coroutines & Flow

---

## 🏗️ Project Structure

```text
com.surajvanshsv.quativa/
├── di/                 # Hilt Modules (Dependency Injection)
├── model/              # Data models for Quotes and Categories
├── repository/         # Data layer logic (Room & API)
├── room/               # Room Database, DAOs, and Entities
├── retrofit/           # Network API service definitions
├── screens/            # UI Composables (Home, Saved, Search, etc.)
├── viewmodels/         # UI State management and business logic
├── sharecard/          # Logic for generating shareable image cards
└── MainActivity.kt      # Application entry point
```

---

## ⚙️ Installation & Run

1. **Clone this repo:**
   ```bash
   git clone https://github.com/surajpsk12/Quativa.git
   cd Quativa
   ```

2. **Open in Android Studio (Ladybug or newer recommended).**

3. **Sync Project with Gradle Files and Run.**

---

## 🧪 Future Enhancements

* 🌓 Full Dynamic Theme support (Material You).
* 🔔 Scheduled Daily Quote notifications.
* ☁️ Cloud sync for saved quotes across devices.
* 🎙️ Voice-to-text search for quotes.

---

## 🤝 Contribution

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change or improve.

---

## 📜 License

MIT © 2025 [Suraj Kumar](https://github.com/surajpsk12)

---

## 📬 Connect with Me

*   **Suraj Kumar**
*   **Email**: [sk658139@gmail.com](mailto:sk658139@gmail.com)
*   **LinkedIn**: [linkedin.com/in/surajvansh12](https://www.linkedin.com/in/surajvansh12/)
*   **GitHub**: [github.com/surajpsk12](https://github.com/surajpsk12)
