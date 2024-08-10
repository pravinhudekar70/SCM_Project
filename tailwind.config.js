/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./scm/src/main/resources/templates/**/*.html",  // Path to your HTML files
    "./scm/src/main/resources/static/**/*.js"        // Path to your JS files
  ],
  theme: {
    extend: {},
  },
  plugins: [],
  darkMode:'selector',
}
