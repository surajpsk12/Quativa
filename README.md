# 📜 Quativa - AI Powered Quotes App

> **Quativa is a modern, high-performance Android application built with Jetpack Compose, Hilt, and Room. It leverages advanced AI for content generation and provides a fluid interface for discovering and sharing inspiring quotes.**

---

## 🚀 Features

- 🎨 **Modern UI:** 100% Jetpack Compose for a declarative, reactive, and fluid user experience.
- 🤖 **AI Integration:** 
    - **Groq Cloud AI:** Powered by Llama 3.1 (8B) via Groq's high-speed inference engine for near-instant quote generation.
    - **LiteRT (Formerly TensorFlow Lite):** On-device intelligence capabilities for future offline features.
- 💾 **Local Persistence:** Uses Room Database for lightning-fast local storage and offline access to your favorite quotes.
- 🏗️ **Dependency Injection:** Built with Dagger Hilt for a scalable and maintainable architecture.
- 🌐 **Networking:** Uses Retrofit for seamless API integrations with FavQs and Groq AI Cloud.
- 📸 **Social Sharing:** Integrated with Capturable for converting UI components into beautiful shareable cards/images.
- ⚡ **Performance:** Optimized build times using Kotlin Symbol Processing (KSP).

---

## 🎨 Tech Stack

- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI Framework:** [Jetpack Compose](https://developer.android.com/compose)
- **Dependency Injection:** [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- **Local Storage:** [Room Database](https://developer.android.com/training/data-storage/room)
- **AI/ML:** [Groq Cloud API](https://groq.com/) (Llama 3.1) & [LiteRT](https://ai.google.dev/edge/litert)
- **Networking:** [Retrofit](https://square.github.io/retrofit/) & OkHttp
- **Architecture:** MVVM + Repository Pattern
- **Asynchronous:** Kotlin Coroutines & Flow

---

## 🏗️ Project Structure

```text
com.surajvanshsv.quativa/
├── di/                 # Hilt Modules (Dependency Injection)
├── model/              # Data models for Quotes, Categories, and Groq API
├── repository/         # Data layer logic (Room & API)
├── room/               # Room Database, DAOs, and Entities
├── retrofit/           # Network API service definitions (FavQs & Groq)
├── screens/            # UI Composables (Home, Saved, Search, etc.)
├── viewmodels/         # UI State management and business logic
├── sharecard/          # Logic for generating shareable image cards
└── MainActivity.kt      # Application entry point
```

---

## ⚙️ Configuration & Run

1. **Clone this repo:**
   ```bash
   git clone https://github.com/surajpsk12/Quativa.git
   cd Quativa
   ```

2. **API Keys:**
   - Obtain a free API key from [Groq Cloud Console](https://console.groq.com/).
   - Add your key to `KeyProvider.kt` (or your preferred secure key management).

3. **Open in Android Studio (Ladybug or newer recommended).**

4. **Sync Project with Gradle Files and Run.**

---

## 🧪 Recent Changes

*   ✅ Migrated from Gemini Pro (Cloud) to **Groq (Llama 3.1)** for faster response times and improved reliability.
*   ✅ Refactored `RetrofitInstance` to support multiple base URLs (FavQs for random quotes and Groq for AI quotes).
*   ✅ Added Groq-compatible data models for seamless JSON serialization.

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
