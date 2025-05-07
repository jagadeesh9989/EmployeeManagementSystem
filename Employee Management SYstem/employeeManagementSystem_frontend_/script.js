const API_URL = 'http://localhost:8080/api/employees';

document.addEventListener('DOMContentLoaded', loadEmployees);
document.getElementById('employeeForm').addEventListener('submit', handleFormSubmit);

function loadEmployees() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            const tbody = document.getElementById('employeeTableBody');
            tbody.innerHTML = '';
            data.forEach(emp => {
                tbody.innerHTML += `
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.name}</td>
                        <td>${emp.department}</td>
                        <td>${emp.role}</td>
                        <td>${emp.salary}</td>
                        <td>
                            <button onclick="editEmployee(${emp.id})">Edit</button>
                            <button onclick="deleteEmployee(${emp.id})">Delete</button>
                        </td>
                    </tr>
                `;
            });
        });
}



function handleFormSubmit(e) {
    e.preventDefault();

    const id = document.getElementById('empId').value;
    const employee = {
        name: document.getElementById('name').value,
        department: document.getElementById('department').value,
        role: document.getElementById('role').value,
        salary: parseFloat(document.getElementById('salary').value)
    };

    const method = id ? 'PUT' : 'POST';
    const url = id ? `${API_URL}/${id}` : API_URL;

    fetch(url, {
        method: method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(employee)
    })
    .then(res => res.json())
    .then(() => {
        document.getElementById('employeeForm').reset();
        loadEmployees();
    });
}

function editEmployee(id) {
    fetch(`${API_URL}/${id}`)
        .then(res => res.json())
        .then(emp => {
            document.getElementById('empId').value = emp.id;
            document.getElementById('name').value = emp.name;
            document.getElementById('department').value = emp.department;
            document.getElementById('role').value = emp.role;
            document.getElementById('salary').value = emp.salary;
        });
}

function deleteEmployee(id) {
    if (confirm('Delete employee?')) {
        fetch(`${API_URL}/${id}`, { method: 'DELETE' })
            .then(() => loadEmployees());
    }
}

function searchById() {
    const id = document.getElementById('searchId').value;
    const result = document.getElementById('searchResult');

    if (!id) {
        result.innerHTML = '<p style="color:red;">Enter valid ID</p>';
        return;
    }

    fetch(`${API_URL}/${id}`)
        .then(res => res.json())
        .then(emp => {
            result.innerHTML = `
                <p><strong>ID:</strong> ${emp.id}</p>
                <p><strong>Name:</strong> ${emp.name}</p>
                <p><strong>Department:</strong> ${emp.department}</p>
                <p><strong>Role:</strong> ${emp.role}</p>
                <p><strong>Salary:</strong> ${emp.salary}</p>
            `;
        })
        .catch(() => {
            result.innerHTML = '<p style="color:red;">Employee not found.</p>';
        });
}
