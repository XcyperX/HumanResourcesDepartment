<#macro agreement products>
    <div class="row">
        <div class="col-sm">
            <form id="createAgreement" name="createAgreement">
                <div class="form-row mb-2">
                    <label>Выберите сотрудника</label>
                    <select id="employee_id" class="form-control">
                        <#list products as product>
                            <option value="${product.id}">${product.firstName} ${product.lastName}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6 pl-0 ml-0">
                        <label>Дата начала</label>
                        <input id="start" type="date" name="vacation_start" class="form-control"
                               value="">
                    </div>
                    <div class="form-group col-md-6 pr-0 mr-0">
                        <label>Дата окончания</label>
                        <input id="finish" type="date" name="vacation_final" class="form-control"
                               value="">
                    </div>
                </div>
                <div class="form-row mb-2">
                    <label>Начисление</label>
                    <select id="payment" class="form-control">
                        <#list payments?values as payment>
                            <option value="${payment}" selected>${payment.getNamePayment()}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6 pl-0 ml-0">
                        <label>Стоимость</label>
                        <input id="price" type="text" name="vacation_start" class="form-control"
                               value="">
                    </div>
                    <div class="form-group col-md-6 pr-0 mr-0">
                        <label>Код вычета</label>
                        <select id="deduction_code" class="form-control">
                                <option value="1" selected>403</option>
                        </select>
                    </div>
                </div>
            </form>
        </div>
    </div>
</#macro>