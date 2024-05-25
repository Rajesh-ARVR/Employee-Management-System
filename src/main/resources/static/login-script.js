// Select all elements with the class 'pw_hide'
const pwShowHide = document.querySelectorAll(".pw_hide");

// Iterate over each element with class 'pw_hide'
pwShowHide.forEach((icon) => {
    // Add a click event listener to each element
    icon.addEventListener("click", () => {
        // Select the corresponding password input field
        let passwordInput = icon.parentElement.querySelector("input[type='password']");
        
        // Toggle the visibility of the password field
        if (passwordInput.type === "password") {
            passwordInput.type = "text"; // Show password
            icon.classList.replace("uil-eye-slash", "uil-eye"); // Change icon to hide eye
        } else {
            passwordInput.type = "password"; // Hide password
            icon.classList.replace("uil-eye", "uil-eye-slash"); // Change icon to show eye
        }
    });
});
