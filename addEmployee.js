document.getElementById('employeeForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const formData = {
        name: e.target.name.value,
        age: parseInt(e.target.age.value),
        address: e.target.address.value,
        employeeId: e.target.employeeId.value,
        designation: e.target.designation.value,
        department: e.target.department.value,
        joiningDate: e.target.joiningDate.value
    };

    fetch('http://localhost:8080/ems', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Registration failed');
            }
            return response.json();
        })
        .then(data => {
            alert('Employee registered successfully!');
            e.target.reset();
        })
        .catch(error => {
            alert('Failed to register employee. Please try again.');
        });
});