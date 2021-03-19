<#import "parts/common.ftlh" as c>
<#import "parts/listManufaturer.ftlh" as man>
<#import "parts/listCategories.ftlh" as listCat>
<#import "parts/filteredBlock.ftlh" as fb>
<#import "parts/searchBlock.ftlh" as sb>
<#import "parts/listOrderHistory.ftlh" as loh>

<@c.page>
    <div class="row">
        <div class="col-sm-2">
            <div class="container">
                <div class="row mb-2">
                    <p class="text-justify">Количество заказов: ${countOrder}</p>
                </div>
                <div class="row mb-2">
                    <label>Выберите статус</label>
                    <select id="filter_provider_id" class="form-control">
                        <option value="0">Все</option>
                        <#list statuses?values as status>
                            <option value="${status}">${status.getNameStatus()}</option>
                        </#list>
                    </select>
                </div>
                <div class="row mb-2">
                    <label>Выберите даты</label>
                    <input id="date_start" type="date" name="date_start" class="form-control mb-1">
                    <input id="date_final" type="date" name="date_final" class="form-control">
                </div>
            </div>
        </div>
        <div class="col-sm-10">
            <div class="container-fluid">
                <@sb.searchBlock />
                <div class="row">
                    <@loh.listOrders users=users stores="" orderHistories=orderHistories manufacturer=manufacturer categories=categories products=products />
                </div>
            </div>
        </div>
    </div>
</@c.page>