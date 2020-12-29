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

submitNewRequest = () => {
    request.types = document.getElementById("types").value;
    request.description = document.getElementById("description").value;
    request.email = document.getElementById("email").value;
    request.phone = document.getElementById("phone").value;
    request.status = "UNDER_CONSIDERATION";
    request.address.city = document.getElementById("city").value;
    request.address.street = document.getElementById("street").value;
    request.address.house = document.getElementById("house").value;
    request.address.flat = document.getElementById("flat").value;
    createNewRequest(request);
}

const user = {
    email: "",
    name: "",
    password: "",
    role: ""
}

const request = {
    types: "",
    description: "",
    email: "",
    phone: "",
    status: "",
    address: {
        city: "",
        street: "",
        house: "",
        flat: ""
    }
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

declinedRequestById = (request_id) => {
    sendRequest('PUT', '/api/requests/declined/employee/' + request_id).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

acceptedRequestById = (request_id) => {
    sendRequest('PUT', '/api/requests/accepted/employee/' + request_id).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

performedRequestById = (request_id) => {
    getRequestById(request_id).then(request => {
        let price = document.getElementById("price_" + request_id).value;
        if (price === "") {
            alert("Введите стоимость услуги!")
        } else {
            request.price = price;
            sendRequest('PUT', '/api/requests/performed/', request).then(response => {
                if (response.ok) {
                    console.log(response);
                    document.location.reload(true);
                } else {
                    console.log(response);
                }
            });
        }
    })
}

getRequestById = (request_id) => {
    return sendRequest('GET', '/api/get/requests/' + request_id).then(response => {
        if (response.ok) {
            return response.json();
        } else {
            console.log(response);
        }
    });
}

createNewRequest = (request) => {
    sendRequest('POST', '/api/requests', request).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}


$(document).ready(function(){
    $('#types').change(function(){
        if (this.value === "CONNECTION") {
            document.getElementsByClassName("description")[0].hidden = true;
        } else {
            document.getElementsByClassName("description")[0].hidden = false;
        }
    });
});