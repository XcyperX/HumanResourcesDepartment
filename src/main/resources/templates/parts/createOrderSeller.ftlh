<#import "listProductsBasketCustomerTable.ftlh" as lpb>
<#macro employee employees subdivisions products categories manufacturer sumPrice=0>
<#--<div class="container pl-5 pr-5">-->
    <div class="row">
        <div class="col-sm">
            <div class="modal-header pl-0 pb-0 pt-0 pr-0 mb-2">
                <h5 class="modal-title" id="exampleModalLabel">Контактная информация</h5>
            </div>
            <form id="createOrderCustomer" name="createOrderCustomer">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label class="custom-label">Введите имя</label>
                        <input id="first_name" type="text" name="first_name" class="form-control"
                               placeholder="Введите имя"
                               value="">
                    </div>
                    <div class="form-group col-md-4">
                        <label class="custom-label">Введите фамилию</label>
                        <input id="last_name" type="text" name="last_name" class="form-control"
                               placeholder="Введите фамилию"
                               value="">
                    </div>
                    <div class="form-group col-md-4">
                        <label class="custom-label">Введите отчетсво</label>
                        <input id="second_name" type="text" name="second_name" class="form-control"
                               placeholder="Введите фамилию"
                               value="">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <label class="custom-label">Введите телефон</label>
                        <input id="phone" type="text" name="phone" class="form-control"
                               placeholder="Введите телефон"
                               value="">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <label class="custom-label">Введите email</label>
                        <input id="email" type="text" name="email" class="form-control"
                               placeholder="Введите email"
                               value="">
                    </div>
                </div>
                <div class="modal-header pl-0 pb-0 pt-0 mb-2">
                    <h5 class="modal-title" id="exampleModalLabel">Адрес доставки</h5>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label class="custom-label">Введите город</label>
                        <input id="city" type="text" name="city" class="form-control"
                               placeholder="Введите город"
                               value="">
                    </div>
                    <div class="form-group col-md-3">
                        <label class="custom-label">Введите улицу</label>
                        <input id="street" type="text" name="street" class="form-control"
                               placeholder="Введите улицу"
                               value="">
                    </div>
                    <div class="form-group col-md-3">
                        <label class="custom-label">Введите дом</label>
                        <input id="house" type="text" name="house" class="form-control"
                               placeholder="Введите дом"
                               value="">
                    </div>
                    <div class="form-group col-md-3">
                        <label class="custom-label">Введите квартиру</label>
                        <input id="flat" type="text" name="flat" class="form-control"
                               placeholder="Введите квартиру"
                               value="">
                    </div>
                </div>
                <div class="modal-header pl-0 pb-0 pt-0 mb-2">
                    <h5 class="modal-title" id="exampleModalLabel">Список товаров</h5>
                </div>
                <@lpb.listProducts products=products categories=categories manufacturer=manufacturer/>

                <div class="pl-0 pb-0 pt-0 mb-1 mt-2">
                    <h5 id="price_order">Общая стоимость: <#list products as product><#local sumPrice += product.price></#list>${sumPrice?c} р.</h5>
                </div>
            </form>
        </div>
    </div>
</#macro>