// script.js
document.addEventListener('DOMContentLoaded', () => {
    const taskForm = document.getElementById('task-form');
    const taskInput = document.getElementById('task-input');
    const taskList = document.getElementById('task-list');

    taskForm.addEventListener('submit', (e) => {
        e.preventDefault();
        addTask(taskInput.value);
        taskInput.value = '';
    });

    function addTask(description) {
        const li = document.createElement('li');
        li.innerHTML = `
            <span>${description}</span>
            <div>
                <button class="complete-btn">Complete</button>
                <button class="remove-btn">Remove</button>
            </div>
        `;

        taskList.appendChild(li);

        const completeBtn = li.querySelector('.complete-btn');
        const removeBtn = li.querySelector('.remove-btn');

        completeBtn.addEventListener('click', () => {
            li.classList.toggle('completed');
        });

        removeBtn.addEventListener('click', () => {
            taskList.removeChild(li);
        });
    }
});