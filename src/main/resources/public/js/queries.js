submitNewUser = () => {
    let createUser = document.forms.createUser;
    for (let i in createUser.elements) {
        let field = createUser.elements[i];
        if (field.type === 'text' || field.type === 'select-one') {
            if (typeof user[field.id] === 'number') {
                user[field.id] = Number(field.value);
            } else {
                user[field.id] = field.value;
            }
        } else if (field.type === 'file') {
            obj['note'] = field.files[0];
        }
    }
    console.log(user);
    createNewUser(user);
}

submitUpdateUserById = (user_id) => {
    let updateUser = document.forms.updateUser;
    for (let i in updateUser.elements) {
        let field = updateUser.elements[i];
        if (field.type === 'text' || field.type === 'select-one') {
            if (typeof user[field.id] === 'number') {
                user[field.id] = Number(field.value);
            } else {
                user[field.id] = field.value;
            }
        } else if (field.type === 'file') {
            obj['note'] = field.files[0];
        }
    }
    console.log(user);
    updateUserById(user_id, user);
}

submitNewEmployees = () => {
    employee.first_name = document.getElementById("first_name").value;
    employee.last_name = document.getElementById("last_name").value;
    employee.passport.number_series = Number(document.getElementById("number_series").value);
    employee.passport.passport_id = Number(document.getElementById("passport_id").value);
    employee.passport.issued_by = document.getElementById("issued_by").value;
    employee.passport.date_issue = document.getElementById("date_issue").value;
    employee.email = document.getElementById("email").value;
    employee.phone = document.getElementById("phone").value;
    employee.date_birth = document.getElementById("date_birth").value;
    employee.address.city = document.getElementById("city").value;
    employee.address.street = document.getElementById("street").value;
    employee.address.house = document.getElementById("house").value;
    employee.address.flat = document.getElementById("flat").value;
    employee.number_inn = Number(document.getElementById("number_inn").value);
    employee.gender = document.getElementById("genders").value;
    employee.subdivision_id = document.getElementById("subdivision").value;
    employee.position.position_name_id = document.getElementById("positions").value;
    employee.position.date_receipt = document.getElementById("date_receipt").value;
    console.log(employee);
    createNewEmployee(employee);
}

submitUpdateEmployees = (employee_id) => {
    let legacyEmployee = document.getElementById("createEmployee_" + employee_id);
    employee.first_name = legacyEmployee.querySelector("#first_name").value;
    employee.last_name = legacyEmployee.querySelector("#last_name").value;
    employee.passport.number_series = Number(legacyEmployee.querySelector("#number_series").value);
    employee.passport.passport_id = Number(legacyEmployee.querySelector("#passport_id").value);
    employee.passport.issued_by = legacyEmployee.querySelector("#issued_by").value;
    employee.passport.date_issue = legacyEmployee.querySelector("#date_issue").value;
    employee.email = legacyEmployee.querySelector("#email").value;
    employee.phone = legacyEmployee.querySelector("#phone").value;
    employee.date_birth = legacyEmployee.querySelector("#date_birth").value;
    employee.address.city = legacyEmployee.querySelector("#city").value;
    employee.address.street = legacyEmployee.querySelector("#street").value;
    employee.address.house = legacyEmployee.querySelector("#house").value;
    employee.address.flat = legacyEmployee.querySelector("#flat").value;
    employee.number_inn = Number(legacyEmployee.querySelector("#number_inn").value);
    employee.gender = legacyEmployee.querySelector("#genders").value;
    employee.subdivision_id = legacyEmployee.querySelector("#subdivision").value;
    employee.position.position_name_id = legacyEmployee.querySelector("#positions").value;
    employee.position.date_receipt = legacyEmployee.querySelector("#date_receipt").value;
    employee.position.date_dismissal = legacyEmployee.querySelector("#date_dismissal").value;
    employee.status = legacyEmployee.querySelector("#status").value;
    employee.passport.pas_id = Number(legacyEmployee.querySelector("#pas_id").value);
    employee.address.address_id = Number(legacyEmployee.querySelector("#address_id").value);
    employee.position.position_id = Number(legacyEmployee.querySelector("#position_id").value);
    console.log(employee);
    updateEmployeeById(employee_id, employee);
}

submitNewSubdivision = () => {
    if (document.getElementById("subdivision").value !== "") {
        subdivision.name = document.getElementById("subdivision").value;
        createNewSubdivision(subdivision);
    } else {
        alert("Введите название подразделения!!!")
    }
}

submitNewPosition = () => {
    if (document.getElementById("position").value !== "") {
        position.name = document.getElementById("position").value;
        createNewPosition(position);
    } else {
        alert("Введите название должности!!!")
    }
}

const user = {
    email: "",
    name: "",
    password: "",
    role: ""
}

const employee = {
    first_name: "",
    last_name: "",
    passport: {
        pas_id: null,
        number_series: -1,
        passport_id: -1,
        issued_by: "",
        date_issue: ""
    },
    email: "",
    phone: "",
    date_birth: "",
    address: {
        address_id: null,
        city: "",
        street: "",
        house: "",
        flat: ""
    },
    number_inn: -1,
    gender: "",
    subdivision_id: -1,
    position: {
        position_id: null,
        position_name_id: "",
        date_receipt: "",
        date_dismissal: ""
    },
    status: ""
}

const subdivision = {
    name: ""
}

const position = {
    name: ""
}

const vacation = {
    vacation_start: "",
    vacation_final: ""
}


sendRequest = (method, url, body) => {
    const headers = {
        'Content-Type': 'application/json'
    }
    console.log(body);
    if (body !== null) {
        return fetch(url, {
            method: method,
            body: JSON.stringify(body),
            headers: headers
        });
    } else {
        return fetch(url, {
            method: method,
            headers: headers
        });
    }
}

createNewUser = (user) => {
    sendRequest('POST', '/api/registrations', user).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

updateUserById = (user_id, user) => {
    sendRequest('PUT', '/api/users/' + user_id, user).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.href = "http://localhost:8080/users";
        } else {
            console.log(response);
        }
    });
}

deleteUserById = (user_id) => {
    sendRequest('DELETE', '/api/users/' + user_id).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

createNewSubdivision = (subdivision) => {
    sendRequest('POST', '/api/subdivisions', subdivision).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

createNewPosition = (position) => {
    sendRequest('POST', '/api/positions/names', position).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

createNewEmployee = (employee) => {
    sendRequest('POST', '/api/employees', employee).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

updateEmployeeById = (employee_id, employee) => {
    sendRequest('PUT', '/api/employees/' + employee_id, employee).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.href = "http://localhost:8080/employees";
        } else {
            console.log(response);
        }
    });
}

updateEmployeeVacationById = (employee_id) => {
    let legacyEmployee = document.getElementById("createEmployee_" + employee_id);
    vacation.vacation_start = legacyEmployee.querySelector("#vacation_start").value;
    vacation.vacation_final = legacyEmployee.querySelector("#vacation_final").value;
    console.log(vacation);
    sendRequest('PUT', '/api/employees/vacation/' + employee_id, vacation).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.href = "http://localhost:8080/vacation";
        } else {
            console.log(response);
        }
    });
}

getEmployeeById = (employee_id) => {
    return sendRequest('GET', '/api/get/employee/' + employee_id).then(response => {
        if (response.ok) {
            return response.json();
        } else {
            console.log(response);
        }
    });
}

deleteEmployeeById = (employee_id) => {
    sendRequest('DELETE', '/api/employees/' + employee_id).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}