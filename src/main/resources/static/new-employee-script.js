const skills = ["Java", "Spring Boot", "HTML", "CSS", "JavaScript", "React",
                        "Angular", "Node.js", "Python", "SQL", "Machine learning", 
                        "Analytics", "Operating Systems", "Computing", "Communication", 
                        "Cybersecurity", "UI UX Design", "Management"];
        const skillsContainer = document.getElementById('skills-container');

        skills.forEach((skill, index) => {
            const skillCheckbox = document.createElement('input');
            skillCheckbox.type = 'checkbox';
            skillCheckbox.name = 'employeeSkills';
            skillCheckbox.value = skill;
            skillCheckbox.className = 'form-check-input';

            const skillLabel = document.createElement('span');
            skillLabel.textContent = skill;

            const skillWrapper = document.createElement('div');
            skillWrapper.className = 'skill-checkbox';
            skillWrapper.appendChild(skillCheckbox);
            skillWrapper.appendChild(skillLabel);

            skillsContainer.appendChild(skillWrapper);

            if ((index + 1) % 3 === 0) {
                skillsContainer.appendChild(document.createElement('br'));
            }
        });

        function validateForm() {
            const checkboxes = document.querySelectorAll('input[name="employeeSkills"]');
            let checked = false;
            checkboxes.forEach(checkbox => {
                if (checkbox.checked) {
                    checked = true;
                }
            });
            if (!checked) {
                document.getElementById('errorMessage').style.display = 'block';
                return false;
            }
            return true;
        }
