<#macro employee employees>
    <div class="row">
        <div class="col-sm">
            <div class="modal-header pl-0 pb-0 pt-0 pr-0 mb-2">
                <h5 class="modal-title" id="exampleModalLabel">Контактная информация</h5>
            </div>
            <form id="createCustomer" name="createCustomer">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label class="custom-label">Введите имя</label>
                        <input id="first_name" type="text" name="first_name" class="form-control"
                               placeholder="Введите имя"
                               value="<#if employees?has_content>${employees.firstName}</#if>">
                    </div>
                    <div class="form-group col-md-4">
                        <label class="custom-label">Введите фамилию</label>
                        <input id="last_name" type="text" name="last_name" class="form-control"
                               placeholder="Введите фамилию"
                               value="<#if employees?has_content>${employees.lastName}</#if>">
                    </div>
                    <div class="form-group col-md-4">
                        <label class="custom-label">Введите отчетсво</label>
                        <input id="second_name" type="text" name="second_name" class="form-control"
                               placeholder="Введите фамилию"
                               value="<#if employees?has_content>${employees.secondName}</#if>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <label class="custom-label">Введите телефон</label>
                        <input id="phone" type="text" name="phone" class="form-control"
                               placeholder="Введите телефон"
                               value="<#if employees?has_content>${employees.phone}</#if>">
                    </div>
                </div>
                <div class="modal-header pl-0 pb-0 pt-0 mb-2">
                    <h5 class="modal-title" id="exampleModalLabel">Данные для входа</h5>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label class="custom-label">Введите email</label>
                        <input id="email" type="text" name="email" class="form-control" placeholder="Введите email"
                               value="<#if employees?has_content>${employees.email}</#if>">
                    </div>
                    <div class="form-group col-md-6">
                        <label class="custom-label">Введите пароль</label>
                        <input id="password" type="text" name="password" class="form-control"
                               placeholder="Введите пароль"
                               value="<#if employees?has_content && employees.password?has_content>${employees.password}</#if>">
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
                               value="<#if employees?has_content && employees.address?has_content>${employees.address.city}</#if>">
                    </div>
                    <div class="form-group col-md-3">
                        <label class="custom-label">Введите улицу</label>
                        <input id="street" type="text" name="street" class="form-control"
                               placeholder="Введите улицу"
                               value="<#if employees?has_content && employees.address?has_content>${employees.address.street}</#if>">
                    </div>
                    <div class="form-group col-md-3">
                        <label class="custom-label">Введите дом</label>
                        <input id="house" type="text" name="house" class="form-control"
                               placeholder="Введите дом"
                               value="<#if employees?has_content && employees.address?has_content>${employees.address.house}</#if>">
                    </div>
                    <div class="form-group col-md-3">
                        <label class="custom-label">Введите квартиру</label>
                        <input id="flat" type="text" name="flat" class="form-control"
                               placeholder="Введите квартиру"
                               value="<#if employees?has_content && employees.address?has_content>${employees.address.flat}</#if>">
                    </div>
                    <input id="address_id" type="text" name="address_id"
                           value="<#if employees?has_content && employees.address?has_content>${employees.address.id}</#if>" hidden>
                </div>
            </form>
        </div>
    </div>
</#macro>