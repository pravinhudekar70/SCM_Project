// console.log("Welcome to the script");

// // Get the current theme from localStorage or set to default
// let currentTheme = getTheme();

// // Initialize the theme on page load
// document.addEventListener('DOMContentLoaded',()=>{
//     changeTheme();
// })


// // Function to handle theme change and apply the current theme
// function changeTheme() {
//     // Set the theme on the web page
//     document.querySelector("html").classList.add(currentTheme);

//     // Set the listener for the change theme button
//     const changeThemeButton = document.querySelector('#theme_change_button');
    
//     // If the button exists, attach the event listener
//     if (changeThemeButton) {
//         changeThemeButton.addEventListener("click", () => {
//             const oldTheme = currentTheme;
//             console.log("Theme button clicked");

//             // Toggle between light and dark themes
//             currentTheme = (currentTheme === "dark") ? "light" : "dark";

//             // Update localStorage with the new theme
//             setTheme(currentTheme);

//             // Apply the new theme
//             document.querySelector("html").classList.remove(oldTheme);
//             document.querySelector("html").classList.add(currentTheme);
//             // change the button text
//             changeThemeButton.querySelector("span").textContent=currentTheme=="light" ? "Dark" :"Light";
//         });
//     }
// }

// // Function to set the theme in localStorage
// function setTheme(theme) {
//     localStorage.setItem("theme", theme);
// }

// // Function to get the theme from localStorage
// function getTheme() {
//     let theme = localStorage.getItem("theme");
//     return theme ? theme : "light";
// }


// Get the current theme from localStorage or set to default
let currentTheme = getTheme();

// Initialize the theme on page load
document.addEventListener('DOMContentLoaded', () => {
    
    applyTheme();
    document.querySelector('#theme_change_button').querySelector("span").textContent = (currentTheme === "light") ? "Dark" : "Light";
    setupThemeToggleButton();
   
});

// Function to apply the current theme to the webpage
function applyTheme() {
    document.documentElement.classList.add(currentTheme);
}

// Function to set up the theme toggle button
function setupThemeToggleButton() {
    let changeThemeButton = document.querySelector('#theme_change_button');

    if (changeThemeButton) {
        changeThemeButton.addEventListener("click", () => {
            toggleTheme();
            updateThemeButtonText(changeThemeButton);
        });
    }
}

// Function to toggle between light and dark themes
function toggleTheme() {
    const oldTheme = currentTheme;
    currentTheme = (currentTheme === "dark") ? "light" : "dark";
    setTheme(currentTheme);

    document.documentElement.classList.replace(oldTheme, currentTheme);
}

// Function to update the text of the theme toggle button
function updateThemeButtonText(button) {
    button.querySelector("span").textContent = (currentTheme === "light") ? "Dark" : "Light";
}

// Function to set the theme in localStorage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

// Function to get the theme from localStorage
function getTheme() {
    return localStorage.getItem("theme") || "light";
}
