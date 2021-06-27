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

submitCreateAndUpdateProvider = (provider_id) => {
    if (provider_id == null) {
        console.log("Нет id");
    } else {
        console.log("Есть id")
    }
    let createProvider = document.getElementById("createProvider");
    user.name_firm = createProvider.querySelector("#nameFirm").value;
    user.email = createProvider.querySelector("#email").value;
    user.password = createProvider.querySelector("#passwordUser").value;
    user.role = "PROVIDER";
    console.log(user);
    createNewUser(user);
}

submitCrateAndUpdateEmployees = (user_id) => {
    let legacyEmployee;
    if (user_id == null) {
        console.log("Нет id");
        legacyEmployee = document.getElementById("createEmployee");
    } else {
        console.log("Есть id");
        legacyEmployee = document.getElementById("createEmployee_" + user_id);
        position.date_dismissal = legacyEmployee.querySelector("#date_dismissal").value;
        passport.pas_id = Number(legacyEmployee.querySelector("#pas_id").value);
        address.address_id = Number(legacyEmployee.querySelector("#address_id").value);
        position.position_id = Number(legacyEmployee.querySelector("#position_id").value);
    }
    user.first_name = legacyEmployee.querySelector("#first_name").value;
    user.last_name = legacyEmployee.querySelector("#last_name").value;
    user.second_name = legacyEmployee.querySelector("#second_name").value;
    user.role = legacyEmployee.querySelector("#role_id").value;
    user.password = legacyEmployee.querySelector("#password").value;

    passport.number_series = Number(legacyEmployee.querySelector("#number_series").value);
    passport.passport_id = Number(legacyEmployee.querySelector("#passport_id").value);
    passport.issued_by = legacyEmployee.querySelector("#issued_by").value;
    passport.date_issue = legacyEmployee.querySelector("#date_issue").value;
    user.passport = JSON.parse(JSON.stringify(passport));

    user.email = legacyEmployee.querySelector("#email").value;
    user.phone = legacyEmployee.querySelector("#phone").value;
    user.date_birth = legacyEmployee.querySelector("#date_birth").value;

    address.city = legacyEmployee.querySelector("#city").value;
    address.street = legacyEmployee.querySelector("#street").value;
    address.house = legacyEmployee.querySelector("#house").value;
    address.flat = legacyEmployee.querySelector("#flat").value;
    user.address = JSON.parse(JSON.stringify(address));

    user.number_inn = Number(legacyEmployee.querySelector("#number_inn").value);
    user.gender = legacyEmployee.querySelector("#genders").value;
    user.subdivision_id = legacyEmployee.querySelector("#subdivision_id").value;

    position.position_name_id = legacyEmployee.querySelector("#positions_id").value;
    position.date_receipt = legacyEmployee.querySelector("#date_receipt").value;
    user.position = JSON.parse(JSON.stringify(position));

    console.log(user);
    if (user_id == null) {
        createNewEmployee(user);
    } else {
        updateEmployeeById(user_id, user);
    }
}

submitCreateAndUpdateProduct = (product_id) => {
    let legacyProduct;
    if (product_id == null) {
        legacyProduct = document.getElementById("createProduct");
    } else {
        legacyProduct = document.getElementById("updateProduct_" + product_id);
    }
    product.name = legacyProduct.querySelector("#name").value;
    product.description = legacyProduct.querySelector("#description").value;
    product.categories_id = legacyProduct.querySelector("#categories_id").value;
    product.manufacturer_id = legacyProduct.querySelector("#manufacturer_id").value;
    product.store_id = legacyProduct.querySelector("#store_id").value;
    product.user_id = legacyProduct.querySelector("#user_id").value;
    product.amount = legacyProduct.querySelector("#amount").value;
    product.price = Number(legacyProduct.querySelector("#price").value);
    let image_photo = legacyProduct.querySelector("#url_photo").files[0];
    let formData = new FormData();
    formData.append("file_test", image_photo, image_photo.name);
    formData.append("productDTO", JSON.stringify(product));
    console.log(formData.get("productDTO"));
    if (product_id == null) {
        console.log(formData);
        createNewProduct(formData);
    } else {
        updateProductById(product_id, formData);
    }
}

submitCreateAndUpdateStore = (bool, store_id) => {
    let legacyStore;
    if (store_id == null) {
        legacyStore = document.getElementById("createStore");
    } else {
        legacyStore = document.getElementById("createStore_" + store_id);
    }

    store.name = legacyStore.querySelector("#name_store").value;
    store.is_provide = bool;
    user.user_id = legacyStore.querySelector("#user_id").value;
    store.users.push(JSON.parse(JSON.stringify(user)));
    createNewStore(store);
}

submitCrateOrder = (user_id) => {
    let legacyEmployee = document.getElementById("createOrder");
    let deliveries = JSON.parse(getCookie("customerBasket"));
    if (user_id != null) {
        order_history.user_id = Number(legacyEmployee.querySelector("#user_id").value);
    } else {
        customer.first_name = legacyEmployee.querySelector("#first_name").value;
        customer.last_name = legacyEmployee.querySelector("#last_name").value;
        customer.second_name = legacyEmployee.querySelector("#second_name").value;

        customer.email = legacyEmployee.querySelector("#email").value;
        customer.phone = legacyEmployee.querySelector("#phone").value;

        address.city = legacyEmployee.querySelector("#city").value;
        address.street = legacyEmployee.querySelector("#street").value;
        address.house = legacyEmployee.querySelector("#house").value;
        address.flat = legacyEmployee.querySelector("#flat").value;
        customer.address = JSON.parse(JSON.stringify(address));
        order_history.customer = JSON.parse(JSON.stringify(customer));
    }

    for (let i = 0; i < deliveries.users.length; i++) {
        for (let j = 0; j < deliveries.users[i].products.length; j++) {
            getProduct(deliveries.users[i].products[j].product.product_id).then(product => {
                order_history.price += (Number(deliveries.users[i].products[j].amount) * Number(product.price))
            });
            product_info.product.product_id = deliveries.users[i].products[j].product.product_id;
            product_info.amount = deliveries.users[i].products[j].amount;
            order_history.product_info_list.push(JSON.parse(JSON.stringify(product_info)));
        }
    }
    try {
        order_history.date_reception = legacyEmployee.querySelector("#date_reception").value;
        order_history.status = legacyEmployee.querySelector("#status_order").value;
    } catch (e) {
        order_history.status = "ACCEPTED";
        order_history.date_reception = null;
    }

    // order_history.price = document.getElementById("price_order").innerHTML.split(" ")[2];

    console.log(order_history);
    if (user_id == null) {
        createNewOrder(order_history);
        deleteCookie();
    } else {
        console.log("Писос")
    }
}

submitCreateDeliveries = (user_id, product_id) => {
    order_history.user_id = user_id;
    order_history.status = "APPLICATION_SENT";
}

submitCrateCustomer = (user_id) => {
    let legacyEmployee;
    if (user_id == null) {
        legacyEmployee = document.getElementById("createCustomer");
    } else {
        legacyEmployee = document.getElementById("updateEmployee_" + user_id);
        user.user_id = user_id;
        address.address_id = legacyEmployee.querySelector("#address_id").value;
    }
    user.first_name = legacyEmployee.querySelector("#first_name").value;
    user.last_name = legacyEmployee.querySelector("#last_name").value;
    user.second_name = legacyEmployee.querySelector("#second_name").value;
    user.role = "CUSTOMER"
    user.password = legacyEmployee.querySelector("#password").value;

    user.email = legacyEmployee.querySelector("#email").value;
    user.phone = legacyEmployee.querySelector("#phone").value;

    address.city = legacyEmployee.querySelector("#city").value;
    address.street = legacyEmployee.querySelector("#street").value;
    address.house = legacyEmployee.querySelector("#house").value;
    address.flat = legacyEmployee.querySelector("#flat").value;
    user.address = JSON.parse(JSON.stringify(address));

    console.log(user);
    if (user_id == null) {
        createNewEmployee(user);
    } else {
        updateEmployeeById(user_id, user);
    }
}

submitNewManufacturer = () => {
    if (document.getElementById("manufacturer_input").value !== "") {
        manufacturer.name = document.getElementById("manufacturer_input").value;
        createNewManufacturers(manufacturer);
    } else {
        alert("Введите название производителя!!!")
    }
}

submitNewSubdivision = () => {
    if (document.getElementById("subdivision_input").value !== "") {
        subdivision.name = document.getElementById("subdivision_input").value;
        createNewSubdivision(subdivision);
    } else {
        alert("Введите название подразделения!!!")
    }
}

submitNewCategories = () => {
    if (document.getElementById("categories_input").value !== "") {
        subdivision.name = document.getElementById("categories_input").value;
        createNewCategories(subdivision);
    } else {
        alert("Введите название категории!!!")
    }
}

submitNewPosition = () => {
    if (document.getElementById("position_input").value !== "") {
        position.name = document.getElementById("position_input").value;
        createNewPosition(position);
    } else {
        alert("Введите название должности!!!")
    }
}

const manufacturer = {
    name: null
}

const store = {
    store_id: null,
    name: null,
    supplies_id: null,
    is_provide: false,
    products: null,
    users: []
}

const passport = {
    pas_id: null,
    number_series: null,
    passport_id: null,
    issued_by: "",
    date_issue: ""
}

const address = {
    address_id: null,
    city: "",
    street: "",
    house: "",
    flat: ""
}

const position = {
    position_id: null,
    position_name_id: "",
    date_receipt: "",
    date_dismissal: ""
}

const user = {
    user_id: null,
    first_name: null,
    last_name: null,
    second_name: null,
    name_firm: null,
    password: null,
    role: null,
    passport: null,
    email: null,
    phone: null,
    date_birth: null,
    address: null,
    number_inn: null,
    gender: null,
    subdivision_id: null,
    store: null,
    position: null
}

const order_history = {
    order_history_id: null,
    customer: null,
    user_id: null,
    provider_id: null,
    date_order: null,
    date_reception: null,
    product_info_list: [],
    status: null,
    price: null
}

const product_info = {
    product: {
        product_id: null
    },
    amount: null
}

const customer = {
    user_id: null,
    first_name: null,
    last_name: null,
    second_name: null,
    email: null,
    phone: null,
    address: null,
    order_histories: null
}

const subdivision = {
    name: ""
}

const vacation = {
    vacation_start: "",
    vacation_final: ""
}

const product = {
    product_id: null,
    name: "",
    description: "",
    categories_id: null,
    manufacturer_id: null,
    user_id: null,
    store_id: null,
    amount: null,
    url_photo: "",
    price: -1
}

sendRequest = (method, url, body) => {
    const headers = {
        'Content-Type': 'application/json'
    }
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

sendRequestWithFile = (method, url, body) => {
    const headers = {}
    console.log(body);
    if (body !== null) {
        return fetch(url, {
            method: method,
            body: body,
            headers: headers
        });
    } else {
        return fetch(url, {
            method: method,
            headers: headers
        });
    }
}

getUsers = (user_id) => {
    return sendRequest('GET', '/api/users/' + user_id, null).then(response => {
        if (response.ok) {
            return response.json();
        } else {
            console.log(response);
        }
    });
}

getProduct = (product_id) => {
    return sendRequest('GET', '/api/products/' + product_id, null).then(response => {
        if (response.ok) {
            return response.json();
        } else {
            console.log(response);
        }
    });
}

createNewOrder = (order) => {
    sendRequest('POST', '/api/new/customer/order', order).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
            alert("Ваш заказ принят! )");
            deleteCookie();
        } else {
            console.log(response);
        }
    });

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

createNewProduct = (product) => {
    sendRequestWithFile('POST', '/api/product/image', product).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

addProductsByOrder = (orderId, elem) => {
    let storeId = elem.parentNode.parentNode;
    sendRequestWithFile('POST', '/api/add/products/orders/' + orderId + '/stock/' + storeId.querySelector("#store_id").value).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

updateProductById = (product_id, product) => {
    sendRequestWithFile('PUT', '/api/product/image/' + product_id, product).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

deleteProductById = (product_id) => {
    sendRequest('DELETE', '/api/products/' + product_id).then(response => {
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

createNewManufacturers = (manufacturers) => {
    sendRequest('POST', '/api/manufacturers', manufacturers).then(response => {
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

createNewCategories = (categories) => {
    sendRequest('POST', '/api/categories', categories).then(response => {
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

createNewStore = (store) => {
    sendRequest('POST', '/api/store', store).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

createNewEmployee = (employee) => {
    sendRequest('POST', '/api/registrations', employee).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

updateEmployeeById = (employee_id, employee) => {
    sendRequest('PUT', '/api/users/' + employee_id, employee).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
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
    sendRequest('PUT', '/api/products/vacation/' + employee_id, vacation).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.href = "http://localhost:8080/vacation";
        } else {
            console.log(response);
        }
    });
}

getEmployeeById = (employee_id) => {
    return sendRequest('GET', '/api/get/product/' + employee_id).then(response => {
        if (response.ok) {
            return response.json();
        } else {
            console.log(response);
        }
    });
}

deleteEmployeeById = (employee_id) => {
    sendRequest('DELETE', '/api/users/' + employee_id).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

filteredProductsByParams = () => {
    let manufacturer_id;
    let categories_id;
    let name;
    let provider_id;
    let store_id;
    let newUrl = window.location.href.toString().split("?")[0];
    try {
        name = "?name=" + document.getElementById("searchProduct").value;
    } catch (e) {
        name = ""
    }
    try {
        manufacturer_id = "&manufacturer_id=" + document.getElementById("filter_manufacturer_id").value;
    } catch (e) {
        manufacturer_id = ""
    }
    try {
        categories_id = "&categories_id=" + document.getElementById("filter_categories_id").value;
    } catch (e) {
        categories_id = ""
    }
    try {
        store_id = "&store_id=" + document.getElementById("filter_store_id").value;
    } catch (e) {
        store_id = ""
    }
    try {
        provider_id = "&provider_id=" + document.getElementById("filter_provider_id").value;
    } catch (e) {
        provider_id = ""
    }
    document.location.href = newUrl
        + name
        + store_id
        + manufacturer_id
        + categories_id
        + provider_id;
}

startScript = () => {
    getAmountProductInBasket();
    getAmountDeliveries();
}

getAmountProductInBasket = () => {
    try {
        let amount = getCookie("product").split(",");
        document.getElementById("productsInBasket").innerHTML = amount.length.toString();
    } catch (e) {
        console.log("Нет корзины");
    }
}

// getPriceProductsBasket = () => {
//     try {
//         sendRequest('GET', '/api/get/price/basket?products_id=' + getCookie("product").split(",")).then(response => {
//             if (response.ok) {
//                 response.text().then(function (fulfilde) {
//                     document.getElementById("priceProductBasket").innerHTML = "Сумма заказа: " + fulfilde.toString() + " р.";
//                 });
//             } else {
//                 console.log(response);
//             }
//         });
//     } catch (e) {
//         console.log("Нет товаров");
//     }
// }

let deliveriesUsers = {
    users: []
}

const deliveriesUserId = {
    user_id: null,
    products: []
}

addProductInDeliveries = (user_id, product_id, nameCookie) => {
    if (document.getElementById("amount_product_" + product_id).value === "" || document.getElementById("amount_product_" + product_id).value == null) {
        alert("Введите необходимое количество!!!")
    } else {
        if (getCookie(nameCookie) == null || getCookie(nameCookie) === "") {
            console.log("Cookie нет");
            deliveriesUserId.user_id = user_id;
            product_info.product.product_id = product_id;
            product_info.amount = document.getElementById("amount_product_" + product_id).value;
            deliveriesUserId.products.push(JSON.parse(JSON.stringify(product_info)));
            deliveriesUsers.users.push(JSON.parse(JSON.stringify(deliveriesUserId)));
            setCookie(nameCookie, JSON.stringify(deliveriesUsers));
            if (nameCookie === "providers") {
                getAmountDeliveries();
            } else {
                getAmountCustomerBasket();
            }
            console.log(JSON.parse(getCookie(nameCookie)));
        } else {
            console.log("Cookie есть");
            deliveriesUsers = JSON.parse(getCookie(nameCookie));
            deliveriesUserId.products = [];
            let user = deliveriesUsers.users.find(user => user.user_id === user_id);
            if (user !== undefined) {
                let product = user.products.find(productX => productX.product.product_id === product_id);
                if (product !== undefined) {
                    product.amount = document.getElementById("amount_product_" + product_id).value;
                    deliveriesUsers.users
                        .find(user => user.user_id === user_id).products
                        .find(productX => productX.product.product_id === product_id)
                        .amount = document.getElementById("amount_product_" + product_id).value;
                    setCookie(nameCookie, JSON.stringify(deliveriesUsers));
                } else {
                    product_info.product.product_id = product_id;
                    product_info.amount = document.getElementById("amount_product_" + product_id).value;
                    deliveriesUsers.users
                        .find(user => user.user_id === user_id).products.push(JSON.parse(JSON.stringify(product_info)));
                    setCookie(nameCookie, JSON.stringify(deliveriesUsers));
                    if (nameCookie === "providers") {
                        getAmountDeliveries();
                    } else {
                        getAmountCustomerBasket();
                    }
                }
            } else {
                deliveriesUserId.user_id = user_id;
                product_info.product.product_id = product_id;
                product_info.amount = document.getElementById("amount_product_" + product_id).value;
                deliveriesUserId.products.push(JSON.parse(JSON.stringify(product_info)));
                deliveriesUsers.users.push(JSON.parse(JSON.stringify(deliveriesUserId)));
                setCookie(nameCookie, JSON.stringify(deliveriesUsers));
                if (nameCookie === "providers") {
                    getAmountDeliveries();
                } else {
                    getAmountCustomerBasket();
                }
            }
            console.log(deliveriesUsers);
        }
    }
}

setDeliveriesInTable = () => {
    let listTables = document.getElementsByClassName("list_deliveries")[0];
    if (listTables !== undefined) {
        while (listTables.hasChildNodes()) {
            listTables.removeChild(listTables.lastChild);
        }
        let deliveries = JSON.parse(getCookie("providers"));
        for (let i = 0; i < deliveries.users.length; i++) {
            getUsers(deliveries.users[i].user_id).then(user => {
                let table = `<table class="table table-bordered mb-2">
                                <thead>
                                <tr>
                                    <th scope="col">Поставщик</th>
                                    <th scope="col">Товар</th>
                                    <th scope="col">Категория</th>
                                    <th scope="col">Производитель</th>
                                    <th scope="col">Заказано</th>
                                    <th scope="col">Стоимость</th>
                                </tr>
                                </thead>
                                <tbody id="listProducts">                                    
                            </table>
                            <div class="row col-auto mb-3">
                                <button type="button" class="btn btn-primary mr-2" onclick="deleteDeliveries(${user.user_id})">
                                    Отменить поставку
                                </button>
                                <button type="button" class="btn btn-primary" onclick="createNewOrderDeliveries(${user.user_id})">
                                    Оформить поставку
                                </button>
                            </div>`;
                table = document.createRange().createContextualFragment(table);
                let listProduct = table.getElementById("listProducts");
                for (let j = 0; j < deliveries.users[i].products.length; j++) {
                    let row = listProduct.insertRow(-1);
                    getProduct(deliveries.users[i].products[j].product.product_id).then(product => {
                        row.insertCell(-1).innerHTML = user.name_firm;
                        row.insertCell(-1).innerHTML = product.name;
                        row.insertCell(-1).innerHTML = product.categories_id;
                        row.insertCell(-1).innerHTML = product.manufacturer_id;
                        row.insertCell(-1).innerHTML = deliveries.users[i].products[j].amount;
                        row.insertCell(-1).innerHTML = (Number(deliveries.users[i].products[j].amount) * Number(product.price)).toString();
                    });
                    table.getElementById("listProducts").appendChild(row);
                }

                document.getElementsByClassName("list_deliveries")[0].appendChild(table);
            });
        }
    }
}

setProductsInCustomerBasket = () => {
    let sum = 0;
    let listTables = document.getElementsByClassName("listProducts")[0];
    if (listTables !== undefined) {
        while (listTables.hasChildNodes()) {
            listTables.removeChild(listTables.lastChild);
        }
        let deliveries = JSON.parse(getCookie("customerBasket"));
        for (let i = 0; i < deliveries.users.length; i++) {
            getUsers(deliveries.users[i].user_id).then(user => {
                for (let j = 0; j < deliveries.users[i].products.length; j++) {
                    getProduct(deliveries.users[i].products[j].product.product_id).then(product => {
                        let product_html = `<div class="col mb-4" id="product_${product.product_id}">
                                            <div class="card h-100">
                                                <div class="card-body pb-0">
                                                    <img src="data:image/jpg;base64,${product.base64Image}" class="card-img-top rounded mx-auto d-block" alt="..."
                                                         style="width: 60%;">
                                                </div>
                                                <div class="card-body">
                                                    <h6 class="card-title mb-0">${product.name}</h6>
                                                </div>
                                                <div class="card-footer">
                                                    <h5 class="modal-title mb-2">${(Number(deliveries.users[i].products[j].amount) * Number(product.price)).toString()} р.</h5>
                                                    <div class="row">
                                                        <input id="amount_product_${product.product_id}" type="text" name="amount_product_${product.product_id}" class="form-control col-7 mr-2"
                                                               placeholder="Количество"
                                                               value="${deliveries.users[i].products[j].amount}">
                                                        <button class="btn btn-primary btn-block col" onclick="addProductInDeliveries(${product.user_id}, ${product.product_id}, 'customerBasket')">
                                                            Добавить
                                                        </button>
                                                    </div>
                            
                                                </div>
                                            </div>
                                        </div>`
                        sum += (Number(deliveries.users[i].products[j].amount) * Number(product.price));
                        product_html = document.createRange().createContextualFragment(product_html);
                        listTables.appendChild(product_html);
                        document.getElementById("priceProductBasket").innerHTML = "Сумма заказа: " + sum.toString();
                    });
                }
            });
        }

    }
}

$(document).ready(function () {
    setDeliveriesInTable();
    setProductsInCustomerBasket()
    getAmountCustomerBasket();
    getAmountDeliveries();
});

createNewOrderDeliveries = (user_id) => {
    let deliveries = JSON.parse(getCookie("providers"));
    for (let i = 0; i < deliveries.users.length; i++) {
        if (deliveries.users[i].user_id === user_id) {
            order_history.provider_id = user_id;
            order_history.user_id = document.getElementById("user_id").value;
            let sum = 0;
            for (let j = 0; j < deliveries.users[i].products.length; j++) {
                getProduct(deliveries.users[i].products[j].product.product_id).then(product => {
                    order_history.price += (Number(deliveries.users[i].products[j].amount) * Number(product.price))
                    order_history.price = order_history.price.toString();
                });
                product_info.product.product_id = deliveries.users[i].products[j].product.product_id;
                product_info.amount = deliveries.users[i].products[j].amount;
                order_history.product_info_list.push(JSON.parse(JSON.stringify(product_info)));
            }

            order_history.status = "APPLICATION_SENT";
            console.log(order_history);
            createNewOrder(order_history);
            deleteDeliveries(user_id);
        }
    }
}

deleteDeliveries = (user_id) => {
    let deliveries = JSON.parse(getCookie("providers"));
    for (let i = 0; i < deliveries.users.length; i++) {
        if (deliveries.users[i].user_id === user_id) {
            deliveries.users.splice(i, 1);
        }
    }
    setCookie("providers", JSON.stringify(deliveries));
    setDeliveriesInTable();
}

getAmountDeliveries = () => {
    let amount = 0;
    let deliveries = JSON.parse(getCookie("providers"));
    for (let i = 0; i < deliveries.users.length; i++) {
        amount += deliveries.users[i].products.length;
    }
    try {
        document.getElementById("productsInDeliveries").innerHTML = amount.toString();
    } catch (e) {

    }
}

getAmountCustomerBasket = () => {
    let amount = 0;
    let deliveries = JSON.parse(getCookie("customerBasket"));
    for (let i = 0; i < deliveries.users.length; i++) {
        amount += deliveries.users[i].products.length;
    }
    try {
        document.getElementById("productsInBasket").innerHTML = amount.toString();
    } catch (e) {

    }
}

getCookie = (name) => {
    let matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : null;
}

getProductsByBasket = () => {
    if (getCookie("product") != null) {
        document.location.href = "http://localhost:8080/products/basket?products_id=" + getCookie("product");
    } else {
        document.location.href = "http://localhost:8080/products/basket?products_id=";
    }

}

getDeliveries = () => {
    document.location.href = "http://localhost:8080/admin/products/deliveries";
}
setCookie = (name, value, options = {}) => {

    options = {
        path: '/',
        // при необходимости добавьте другие значения по умолчанию
        ...options
    };

    if (options.expires instanceof Date) {
        options.expires = options.expires.toUTCString();
    }

    let updatedCookie = encodeURIComponent(name) + "=" + encodeURIComponent(value);

    for (let optionKey in options) {
        updatedCookie += "; " + optionKey;
        let optionValue = options[optionKey];
        if (optionValue !== true) {
            updatedCookie += "=" + optionValue;
        }
    }

    document.cookie = updatedCookie;
}

// Пример использования:
// setCookie('user', 'John', {secure: true, 'max-age': 3600});

deleteCookie = () => {
    setCookie("customerBasket", "", {
        'max-age': -1
    })
    document.location.href = "http://localhost:8080/products";
}
