@echo off
setlocal enabledelayedexpansion

echo ========================================
echo   Android Test Automation Script
echo ========================================
echo.
REM ========== 1. СОЗДАТЬ НОВЫЙ ЭМУЛЯТОР ==========
echo [2/7] Creating new emulator...
echo y | avdmanager create avd --name emulator-5564 --package "system-images;android-34;google_apis;x86_64" --device "pixel" --force
echo Emulator created
echo.

REM ========== 2. ЗАПУСК ЭМУЛЯТОРА ==========
echo [1/5] Starting emulator...
start /B emulator -avd emulator-5564 -no-snapshot -wipe-data -port 5564 -skin 720x1280 -gpu host
echo Emulator starting in background...
echo.

REM ========== 3. ОЖИДАНИЕ 1 МИНУТЫ ==========
echo [2/5] Waiting 120 seconds for emulator to boot...
timeout /t 120 /nobreak >nul
echo.

REM ========== 4. ЗАПУСК ТЕСТА ==========
echo [3/5] Running tests...
call gradlew.bat app:connectedAlphaDebugAndroidTest "-Pandroid.testInstrumentationRunnerArguments.class=org.wikipedia.lesson21.tests.FindItemByClassTest#verifyItemByClassAndIndex"
set TEST_RESULT=%errorlevel%
echo.

REM ========== 5. ЗАВЕРШЕНИЕ РАБОТЫ ЭМУЛЯТОРА ==========
echo [6/7] Stopping emulator...
adb -s emulator-5564 emu kill
timeout /t 3 /nobreak >nul
taskkill /IM emulator.exe /F >nul 2>&1
echo Emulator killed
echo.

REM ========== 6. ГЕНЕРАЦИЯ ОТЧЁТА ALLURE ==========
echo [5/5] Generating and opening Allure report...
cd app
if exist "build\allure-results" (
    echo Allure results found. Generating report...
    call allure serve build\allure-results
) else (
    echo WARNING: allure-results folder not found in app\build\
)
cd ..
echo.

pause
exit /b %TEST_RESULT%