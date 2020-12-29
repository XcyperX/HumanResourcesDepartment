<#macro createRequest>
    <div class="container pl-5 pr-5">
        <div class="row">
            <div class="col-sm">
                <form id="createRequest" name="createRequest">
                    <div class="form-row">
                        <label>Форма заявки</label>
                    </div>
                    <div class="form-row mb-2">
                        <label>Тип заявки</label>
                        <select id="types" class="form-control">
                            <option value="null"></option>
                            <#list types?values as type>
                                <option value="${type}">${type.getNameType()}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="form-row mb-2 description">
                        <label>Опишите проблему</label>
                        <input id="description" type="text" name="description" class="form-control" placeholder="Опишите проблему">
                    </div>
                    <div class="form-row mb-2">
                        <label>Введите свой email</label>
                        <input id="email" type="text" name="email" class="form-control" placeholder="Введите свой email">
                    </div>
                    <div class="form-row mb-2">
                        <label>Введите свой телефон</label>
                        <input id="phone" type="text" name="phone" class="form-control"
                               placeholder="Введите свой телефон">
                    </div>
                    <div class="form-row mb-2">
                        <div class="form-group col-md-3">
                            <label>Введите свой город</label>
                            <input id="city" type="text" name="city" class="form-control" placeholder="Введите город">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Введите свою улицу</label>
                            <input id="street" type="text" name="street" class="form-control" placeholder="Введите улицу">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Введите номер дома</label>
                            <input id="house" type="text" name="house" class="form-control" placeholder="Введите дом">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Введите номер квартиры</label>
                            <input id="flat" type="text" name="flat" class="form-control" placeholder="Введите квартиру">
                        </div>
                    </div>
                    <div class="form-row">
                        <input class="btn btn-primary  mb-4" type="button" onclick="submitNewRequest()" value="Отправить заявку">
                    </div>
                </form>
            </div>
        </div>
    </div>
</#macro>