# 🏃 RecorderKeeper

A simple Android app to track and store your personal best **running** and **cycling** records — all saved locally on-device using SharedPreferences.

---

## 📱 Screenshots

> _Replace the mockups below with real device screenshots once the app is running._

### Running Screen
```
┌──────────────────────────────┐
│  [  Running header image   ] │
│         Running              │
├──────────────────────────────┤
│  5km                  25:30  │
│                  5 Jun 2026  │
├──────────────────────────────┤
│  10km                 54:12  │
│                 12 Apr 2026  │
├──────────────────────────────┤
│  Half Marathon      1:55:00  │
│                  1 Mar 2026  │
├──────────────────────────────┤
│  Marathon           4:10:00  │
│                 20 Jan 2026  │
├──────────────────────────────┤
│   🏃 Running  |  🚴 Cycling  │
└──────────────────────────────┘
```

### Cycling Screen
```
┌──────────────────────────────┐
│  [  Cycling header image   ] │
│         Cycling              │
├──────────────────────────────┤
│  Longest Ride          120km │
│                  8 Jun 2026  │
├──────────────────────────────┤
│  Biggest Climb        1200m  │
│                 15 May 2026  │
├──────────────────────────────┤
│  Best Average Speed  32 km/h │
│                  3 Jun 2026  │
├──────────────────────────────┤
│   🏃 Running  |  🚴 Cycling  │
└──────────────────────────────┘
```

### Edit Record Screen
```
┌──────────────────────────────┐
│ ←  5km Record                │
├──────────────────────────────┤
│                              │
│   ┌──────────────────────┐   │
│   │  Time        25:30   │   │
│   └──────────────────────┘   │
│   ┌──────────────────────┐   │
│   │  Date     5 Jun 2026 │   │
│   └──────────────────────┘   │
│                              │
│   [        Save            ] │
│   [        Delete          ] │
└──────────────────────────────┘
```

### Overflow Menu (Reset)
```
┌──────────────────────────────┐
│  RecorderKeeper          ⋮   │
│                  ┌─────────┐ │
│                  │Reset    │ │
│                  │Running  │ │
│                  ├─────────┤ │
│                  │Reset    │ │
│                  │Cycling  │ │
│                  ├─────────┤ │
│                  │Reset All│ │
│                  └─────────┘ │
└──────────────────────────────┘
```

---

## ✨ Features

| Feature | Description |
|---|---|
| 🏃 **Running Records** | Track your personal bests for 5km, 10km, Half Marathon and Marathon |
| 🚴 **Cycling Records** | Track your Longest Ride, Biggest Climb and Best Average Speed |
| ✏️ **Edit a Record** | Tap any record row to open the edit screen and update the value + date |
| 🗑️ **Delete a Record** | Clear a single record from the edit screen using the Delete button |
| 🔄 **Reset Records** | Use the toolbar overflow menu to reset Running, Cycling, or All records at once |
| 💾 **Offline & Private** | All data is stored locally on the device using Android `SharedPreferences` — no account or internet required |
| 🌙 **Dark Mode** | Follows the system theme automatically (Day / Night support) |

---

## 🗺️ App Structure

```
RecorderKeeper/
├── MainActivity.kt             # Host activity: bottom nav + toolbar reset menu
├── running/
│   └── RunningFragment.kt      # Displays 5km, 10km, Half Marathon, Marathon records
├── cycling/
│   └── CyclingFragment.kt      # Displays Longest Ride, Biggest Climb, Best Average Speed
└── editRecord/
    └── EditRecordActivity.kt   # Shared edit/delete screen for any record type
```

---

## 🏗️ Tech Stack

| Layer | Technology |
|---|---|
| Language | **Kotlin** |
| UI | **XML layouts** + View Binding |
| Navigation | **Bottom Navigation View** + Fragment transactions |
| Storage | **SharedPreferences** (no database required) |
| UI Components | **Material Components** (TextInputLayout, MaterialButton, BottomNavigationView, Snackbar) |
| Min SDK | **31** (Android 12) |
| Target SDK | **36** |

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or newer
- Android device or emulator running API 31+

### Build & Run
```bash
# Clone the project
git clone https://github.com/your-username/RecorderKeeper.git

# Open in Android Studio, then run:
./gradlew assembleDebug
```

Or simply open the project in Android Studio and press **Run ▶**.

---

## 📂 Data Storage

Records are persisted in two separate `SharedPreferences` files:

| File | Keys stored |
|---|---|
| `running` | `5km record`, `5km date`, `10km record`, `10km date`, `Half Marathon record`, `Half Marathon date`, `Marathon record`, `Marathon date` |
| `cycling` | `Longest Ride record`, `Longest Ride date`, `Biggest Climb record`, `Biggest Climb date`, `Best Average Speed record`, `Best Average Speed date` |

---

## 📋 How To Use

1. **Launch the app** — the Running screen is shown by default.
2. **Tap a record row** (e.g. *5km*) to open the edit screen.
3. **Enter your record value** (e.g. `25:30`) and the **date** (e.g. `5 Jun 2026`).
4. Tap **Save** to store your record, or **Delete** to clear it.
5. Use the **bottom navigation** to switch between Running and Cycling.
6. Use the **⋮ overflow menu** in the toolbar to reset Running, Cycling, or All records at once.

---

## 🛠️ Known Issues / Future Ideas

- [ ] Add support for more sports (swimming, hiking, etc.)
- [ ] Add a history log per record
- [ ] Export/import records as CSV
- [ ] Add input validation (e.g. time format checks)
- [ ] Add widgets for the home screen

---

## 📄 License

```
Copyright (C) 2026 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0
```

